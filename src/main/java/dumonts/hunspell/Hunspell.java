package dumonts.hunspell;

import hunspell.HunspellLibrary;
import org.bridj.Pointer;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hunspell implements Closeable {
    private final Pointer<HunspellLibrary.Hunhandle> handle;

    public Hunspell(Path dictionary, Path affix) {
        Pointer<Byte> aff = Pointer.pointerToCString(affix.toString());
        Pointer<Byte> dic = Pointer.pointerToCString(dictionary.toString());
        handle = HunspellLibrary.Hunspell_create(aff, dic);
        if (this.handle == null) {
            throw new RuntimeException("Unable to create Hunspell instance");
        }
    }

    public static Hunspell forDictionaryInResources(String language) {
        try {
            ClassLoader loader = Hunspell.class.getClassLoader();
            InputStream dictionaryStream = loader.getResourceAsStream(language + ".dic");
            InputStream affixStream = loader.getResourceAsStream(language + ".aff");
            if (dictionaryStream == null || affixStream == null) {
                throw new RuntimeException("Could not find dictionary for language \"" + language + "\" in classpath");
            }
            Path dictionary = Files.createTempFile(language, ".dic");
            Path affix = Files.createTempFile(language, ".aff");
            Files.copy(dictionaryStream, dictionary, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(affixStream, affix, StandardCopyOption.REPLACE_EXISTING);
            return new Hunspell(dictionary, affix);
        } catch (IOException e) {
            throw new RuntimeException("Could not create temporary dictionaries for language \"" + language + "\"", e);
        }
    }

    public boolean spell(String word) {
        if (handle == null) {
            throw new RuntimeException("Attempt to use hunspell instance after closing");
        }
        Pointer<Byte> str = Pointer.pointerToCString(word);
        int result = HunspellLibrary.Hunspell_spell(handle, str);
        return result != 0;
    }

    public void add(String word) {
        if (handle == null) {
            throw new RuntimeException("Attempt to use hunspell instance after closing");
        }
        Pointer<Byte> str = Pointer.pointerToCString(word);
        HunspellLibrary.Hunspell_add(handle, str);
    }

    public List<String> suggest(String word) {
        // Create pointer to native string array
        Pointer<Pointer<Pointer<Byte>>> nativeSuggestionArray = Pointer.allocatePointerPointer(Byte.class);
        // Hunspell will allocate the array and fill it with suggestions
        int suggestionCount = HunspellLibrary.Hunspell_suggest(handle, nativeSuggestionArray, Pointer.pointerToCString(word));
        if(suggestionCount == 0) {
            // Return early and don't try to free the array
            return new ArrayList<>();
        }
        // Ask bridj for a `java.util.List` that wraps `nativeSuggestionArray`
        List<Pointer<Byte>> nativeSuggestionList = nativeSuggestionArray.get().validElements(suggestionCount).asList();
        // Convert C Strings to java strings
        List<String> suggestions = nativeSuggestionList.stream().map(Pointer::getCString).collect(Collectors.toList());

        // We can free the underlying buffer now because Java's `String` owns it's own memory
        HunspellLibrary.Hunspell_free_list(handle, nativeSuggestionArray, suggestionCount);
        return suggestions;
    }

    public void close() {
        if (handle != null) {
            HunspellLibrary.Hunspell_destroy(handle);
        }
    }
}
