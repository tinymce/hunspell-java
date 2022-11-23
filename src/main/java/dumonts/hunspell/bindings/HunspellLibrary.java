package dumonts.hunspell.bindings;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.PointerByReference;
/**
 * JNA Wrapper for library <b>hunspell</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class HunspellLibrary implements Library {
	public static final String JNA_LIBRARY_NAME = "hunspell";
	public static final NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(HunspellLibrary.JNA_LIBRARY_NAME);
	static {
		Native.register(HunspellLibrary.class, HunspellLibrary.JNA_NATIVE_LIB);
	}
	/**
	 * Original signature : <code>Hunhandle* Hunspell_create(const char*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:51</i>
	 */
	public static native PointerByReference Hunspell_create(String affpath, String dpath);
	/**
	 * Original signature : <code>Hunhandle* Hunspell_create_key(const char*, const char*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:54</i>
	 */
	public static native PointerByReference Hunspell_create_key(String affpath, String dpath, String key);
	/**
	 * Original signature : <code>void Hunspell_destroy(Hunhandle*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:58</i>
	 */
	public static native void Hunspell_destroy(PointerByReference pHunspell);
	/**
	 * load extra dictionaries (only dic files)<br>
	 * output: 0 = additional dictionary slots available, 1 = slots are now full<br>
	 * Original signature : <code>int Hunspell_add_dic(Hunhandle*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:62</i>
	 */
	public static native int Hunspell_add_dic(PointerByReference pHunspell, String dpath);
	/**
	 * load extra dictionaries (only dic files)<br>
	 * output: 0 = additional dictionary slots available, 1 = slots are now full<br>
	 * Original signature : <code>int Hunspell_add_dic(Hunhandle*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:62</i>
	 */
	public static native int Hunspell_add_dic(PointerByReference pHunspell, Pointer dpath);
	/**
	 * spell(word) - spellcheck word<br>
	 * output: 0 = bad word, not 0 = good word<br>
	 * Original signature : <code>int Hunspell_spell(Hunhandle*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:68</i>
	 */
	public static native int Hunspell_spell(PointerByReference pHunspell, String charPtr1);
	/**
	 * spell(word) - spellcheck word<br>
	 * output: 0 = bad word, not 0 = good word<br>
	 * Original signature : <code>int Hunspell_spell(Hunhandle*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:68</i>
	 */
	public static native int Hunspell_spell(PointerByReference pHunspell, Pointer charPtr1);
	/**
	 * Original signature : <code>char* Hunspell_get_dic_encoding(Hunhandle*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:70</i>
	 */
	public static native Pointer Hunspell_get_dic_encoding(PointerByReference pHunspell);
	/**
	 * suggest(suggestions, word) - search suggestions<br>
	 * input: pointer to an array of strings pointer and the (bad) word<br>
	 *   array of strings pointer (here *slst) may not be initialized<br>
	 * output: number of suggestions in string array, and suggestions in<br>
	 *   a newly allocated array of strings (*slts will be NULL when number<br>
	 *   of suggestion equals 0.)<br>
	 * Original signature : <code>int Hunspell_suggest(Hunhandle*, char***, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:79</i>
	 */
	public static native int Hunspell_suggest(PointerByReference pHunspell, PointerByReference slst, String word);
	/**
	 * suggest(suggestions, word) - search suggestions<br>
	 * input: pointer to an array of strings pointer and the (bad) word<br>
	 *   array of strings pointer (here *slst) may not be initialized<br>
	 * output: number of suggestions in string array, and suggestions in<br>
	 *   a newly allocated array of strings (*slts will be NULL when number<br>
	 *   of suggestion equals 0.)<br>
	 * Original signature : <code>int Hunspell_suggest(Hunhandle*, char***, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:79</i>
	 */
	public static native int Hunspell_suggest(PointerByReference pHunspell, PointerByReference slst, Pointer word);
	/**
	 * analyze(result, word) - morphological analysis of the word<br>
	 * Original signature : <code>int Hunspell_analyze(Hunhandle*, char***, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:87</i>
	 */
	public static native int Hunspell_analyze(PointerByReference pHunspell, PointerByReference slst, String word);
	/**
	 * analyze(result, word) - morphological analysis of the word<br>
	 * Original signature : <code>int Hunspell_analyze(Hunhandle*, char***, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:87</i>
	 */
	public static native int Hunspell_analyze(PointerByReference pHunspell, PointerByReference slst, Pointer word);
	/**
	 * stem(result, word) - stemmer function<br>
	 * Original signature : <code>int Hunspell_stem(Hunhandle*, char***, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:93</i>
	 */
	public static native int Hunspell_stem(PointerByReference pHunspell, PointerByReference slst, String word);
	/**
	 * stem(result, word) - stemmer function<br>
	 * Original signature : <code>int Hunspell_stem(Hunhandle*, char***, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:93</i>
	 */
	public static native int Hunspell_stem(PointerByReference pHunspell, PointerByReference slst, Pointer word);
	/**
	 * stem(result, analysis, n) - get stems from a morph. analysis<br>
	 * example:<br>
	 * char ** result, result2;<br>
	 * int n1 = Hunspell_analyze(result, "words");<br>
	 * int n2 = Hunspell_stem2(result2, result, n1);<br>
	 * Original signature : <code>int Hunspell_stem2(Hunhandle*, char***, char**, int)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:104</i>
	 */
	public static native int Hunspell_stem2(PointerByReference pHunspell, PointerByReference slst, PointerByReference desc, int n);
	/**
	 * generate(result, word, word2) - morphological generation by example(s)<br>
	 * Original signature : <code>int Hunspell_generate(Hunhandle*, char***, const char*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:111</i>
	 */
	public static native int Hunspell_generate(PointerByReference pHunspell, PointerByReference slst, String word, String word2);
	/**
	 * generate(result, word, word2) - morphological generation by example(s)<br>
	 * Original signature : <code>int Hunspell_generate(Hunhandle*, char***, const char*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:111</i>
	 */
	public static native int Hunspell_generate(PointerByReference pHunspell, PointerByReference slst, Pointer word, Pointer word2);
	/**
	 * generate(result, word, desc, n) - generation by morph. description(s)<br>
	 * example:<br>
	 * char ** result;<br>
	 * char * affix = "is:plural"; // description depends from dictionaries, too<br>
	 * int n = Hunspell_generate2(result, "word", &affix, 1);<br>
	 * for (int i = 0; i < n; i++) printf("%s\n", result[i]);<br>
	 * Original signature : <code>int Hunspell_generate2(Hunhandle*, char***, const char*, char**, int)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:124</i>
	 */
	public static native int Hunspell_generate2(PointerByReference pHunspell, PointerByReference slst, String word, PointerByReference desc, int n);
	/**
	 * generate(result, word, desc, n) - generation by morph. description(s)<br>
	 * example:<br>
	 * char ** result;<br>
	 * char * affix = "is:plural"; // description depends from dictionaries, too<br>
	 * int n = Hunspell_generate2(result, "word", &affix, 1);<br>
	 * for (int i = 0; i < n; i++) printf("%s\n", result[i]);<br>
	 * Original signature : <code>int Hunspell_generate2(Hunhandle*, char***, const char*, char**, int)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:124</i>
	 */
	public static native int Hunspell_generate2(PointerByReference pHunspell, PointerByReference slst, Pointer word, PointerByReference desc, int n);
	/**
	 * add word to the run-time dictionary<br>
	 * Original signature : <code>int Hunspell_add(Hunhandle*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:134</i>
	 */
	public static native int Hunspell_add(PointerByReference pHunspell, String word);
	/**
	 * add word to the run-time dictionary<br>
	 * Original signature : <code>int Hunspell_add(Hunhandle*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:134</i>
	 */
	public static native int Hunspell_add(PointerByReference pHunspell, Pointer word);
	/**
	 * add word to the run-time dictionary with affix flags of<br>
	 * the example (a dictionary word): Hunspell will recognize<br>
	 * affixed forms of the new word, too.<br>
	 * Original signature : <code>int Hunspell_add_with_affix(Hunhandle*, const char*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:142</i>
	 */
	public static native int Hunspell_add_with_affix(PointerByReference pHunspell, String word, String example);
	/**
	 * add word to the run-time dictionary with affix flags of<br>
	 * the example (a dictionary word): Hunspell will recognize<br>
	 * affixed forms of the new word, too.<br>
	 * Original signature : <code>int Hunspell_add_with_affix(Hunhandle*, const char*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:142</i>
	 */
	public static native int Hunspell_add_with_affix(PointerByReference pHunspell, Pointer word, Pointer example);
	/**
	 * remove word from the run-time dictionary<br>
	 * Original signature : <code>int Hunspell_remove(Hunhandle*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:148</i>
	 */
	public static native int Hunspell_remove(PointerByReference pHunspell, String word);
	/**
	 * remove word from the run-time dictionary<br>
	 * Original signature : <code>int Hunspell_remove(Hunhandle*, const char*)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:148</i>
	 */
	public static native int Hunspell_remove(PointerByReference pHunspell, Pointer word);
	/**
	 * free suggestion lists<br>
	 * Original signature : <code>void Hunspell_free_list(Hunhandle*, char***, int)</code><br>
	 * <i>native declaration : src/main/cpp/hunspell/src/hunspell/hunspell.h:153</i>
	 */
	public static native void Hunspell_free_list(PointerByReference pHunspell, PointerByReference slst, int n);
	public static class Hunhandle extends PointerType {
		public Hunhandle(Pointer address) {
			super(address);
		}
		public Hunhandle() {
			super();
		}
	};
}
