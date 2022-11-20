package dumonts.hunspell;

import com.sun.jna.Memory;
import com.sun.jna.ptr.PointerByReference;
import dumonts.hunspell.bindings.HunspellLibrary;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Hunspell implements Closeable {
    private final PointerByReference handle;
    private final String encoding;
    private final Charset charset;

    public Hunspell(Path dictionary, Path affix) {
        handle = HunspellLibrary.Hunspell_create(affix.toString(), dictionary.toString());
        if (this.handle == null) {
            throw new RuntimeException("Unable to create Hunspell instance");
        }
        encoding = HunspellLibrary.Hunspell_get_dic_encoding(handle).getString(0);
        charset = Charset.forName(encoding);
    }

    public static Hunspell forDictionaryInResources(String language, String resourcePath) {
        try {
            ClassLoader loader = Hunspell.class.getClassLoader();
            InputStream dictionaryStream = loader.getResourceAsStream(resourcePath + language + ".dic");
            InputStream affixStream = loader.getResourceAsStream(resourcePath + language + ".aff");
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

    public static Hunspell forDictionaryInResources(String language) {
        return forDictionaryInResources(language, "");
    }

    public boolean spell(String word) {
        if (handle == null) {
            throw new RuntimeException("Attempt to use hunspell instance after closing");
        }
        final byte[] bytes = word.getBytes(charset);
        try (Memory m = new Memory(bytes.length + 1)) {
            m.write(0, bytes, 0, bytes.length);
            m.setByte(bytes.length, (byte) 0);
            int result = HunspellLibrary.Hunspell_spell(handle, m);
            return result != 0;
        }
    }

    public void add(String word) {
        if (handle == null) {
            throw new RuntimeException("Attempt to use hunspell instance after closing");
        }
        final byte[] bytes = word.getBytes(charset);
        try (Memory m = new Memory(bytes.length + 1)) {
            m.write(0, bytes, 0, bytes.length);
            m.setByte(bytes.length, (byte) 0);
            HunspellLibrary.Hunspell_add(handle, m);
        }
    }

    public String[] suggest(String word) {
        final PointerByReference ptr = new PointerByReference();
        final byte[] bytes = word.getBytes(charset);
        int suggestionCount;
        String[] result;
        try (final Memory m = new Memory(bytes.length + 1)) {
            m.write(0, bytes, 0, bytes.length);
            m.setByte(bytes.length, (byte) 0);
            suggestionCount = HunspellLibrary.Hunspell_suggest(handle, ptr, m);
            if (suggestionCount > 0) {
                result = ptr.getValue().getStringArray(0, suggestionCount, encoding);
                HunspellLibrary.Hunspell_free_list(handle, ptr, suggestionCount);
            } else {
                result = new String[]{};
            }
        }
        return result;
    }

    public void close() {
        if (handle != null) {
            HunspellLibrary.Hunspell_destroy(handle);
        }
    }
}