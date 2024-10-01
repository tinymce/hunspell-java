package cloud.tiny.hunspell;


import org.junit.Test;
import static org.junit.Assert.*;

public class HunspellTest {

    @Test
    public void testSpell() {
        Hunspell dictionary = Hunspell.forDictionaryInResources("de");
        assertTrue(dictionary.spell("Anfängerfehlerklassenbibliothek"));
        assertFalse(dictionary.spell("Anfangerfehlerklassenbibliothek"));
        assertTrue(dictionary.spell("ADAC-Notrufnummer"));
    }

    @Test
    public void testAdd() {
        Hunspell dictionary = Hunspell.forDictionaryInResources("de");
        assertFalse(dictionary.spell("abcdefgh"));
        dictionary.add("abcdefgh");
        assertTrue(dictionary.spell("abcdefgh"));
    }

    @Test
    public void testSuggest() {
        Hunspell dictionary = Hunspell.forDictionaryInResources("de");
        assertEquals("willkommen", dictionary.suggest("willkome")[0]);
    }
}