package hunspell.bindings;

import junit.framework.TestCase;
import org.bridj.Pointer;

public class HunspellLibraryTest extends TestCase {

    public void testHunspell_create() {
        Pointer<Byte> aff = Pointer.pointerToCString("de.aff");
        Pointer<Byte> dic = Pointer.pointerToCString("de.dic");
        Pointer<HunspellLibrary.Hunhandle> handle = HunspellLibrary.Hunspell_create(aff, dic);
        assertNotNull(handle);
    }
}