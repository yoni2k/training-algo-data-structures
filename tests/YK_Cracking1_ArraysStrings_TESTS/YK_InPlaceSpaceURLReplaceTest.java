package YK_Cracking1_ArraysStrings_TESTS;

import YK_Cracking1_ArraysStrings.YK_InPlaceSpaceURLReplace;
import YK_Common.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_InPlaceSpaceURLReplaceTest {

    @Test
    void newClass() { new YK_InPlaceSpaceURLReplace(); }

    @Test
    void noSpacesFull() {
        assertEquals("abc", YK_InPlaceSpaceURLReplace.URLify("abc", 3));
    }

    @Test
    void simpleJustExact() {
        assertEquals("a%20b", YK_InPlaceSpaceURLReplace.URLify("a b  ", 3));
        assertEquals("%20ab", YK_InPlaceSpaceURLReplace.URLify(" ab  ", 3));
    }

    @Test
    void spacesAtTheEndExact() {
        assertEquals("a%20b%20", YK_InPlaceSpaceURLReplace.URLify("a b     ", 4));
        assertEquals("%20ab%20", YK_InPlaceSpaceURLReplace.URLify(" ab     ", 4));
    }

    @Test
    void extraSpaceAtTheEnd() {
        assertEquals("abc ", YK_InPlaceSpaceURLReplace.URLify("abc ", 3));
        assertEquals("a%20b ", YK_InPlaceSpaceURLReplace.URLify("a b   ", 3));
        assertEquals("%20ab ", YK_InPlaceSpaceURLReplace.URLify(" ab   ", 3));
        assertEquals("a%20b%20 ", YK_InPlaceSpaceURLReplace.URLify("a b      ", 4));
        assertEquals("%20ab%20 ", YK_InPlaceSpaceURLReplace.URLify(" ab      ", 4));
    }

    private void checkThrows(String org, int size, String excMessage) {
        Exception exc = assertThrows(YK_Exception.class, () -> YK_InPlaceSpaceURLReplace.URLify(org,size));
        assertTrue(exc.getMessage().contains(excMessage));
    }

    @Test
    void emptyStringInvalidNumbers() {
        assertEquals("", YK_InPlaceSpaceURLReplace.URLify("", 0));

        checkThrows("abc", -1, "Negative");
        checkThrows(null, 0, "Null");
        checkThrows("abc", 4, "Invalid");
        checkThrows("ab c", 4, "Insufficient");
        checkThrows("ab  c   ", 5, "Insufficient");
        checkThrows("ab  c   ", 5, "Insufficient");
    }
}