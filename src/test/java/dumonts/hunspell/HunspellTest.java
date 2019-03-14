package dumonts.hunspell;


import org.junit.Test;
import static org.junit.Assert.*;

public class HunspellTest {

    Hunspell dictionary = Hunspell.forDictionaryInResources("de");

    @Test
    public void testSpell() {
        assertTrue(dictionary.spell("Anfängerfehlerklassenbibliothek"));
        assertFalse(dictionary.spell("Anfangerfehlerklassenbibliothek"));
        assertTrue(dictionary.spell("ADAC-Notrufnummer"));
    }

    @Test
    public void testSuggest() {
        assertEquals("Anfängerfehlerklassenbibliothek", dictionary.suggest("Anfängerfehlerklassenbibliothek").get(0));
    }

}