import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YoniInPlaceSpaceURLReplaceTest {

    @Test
    void noSpacesFull() {
        assertEquals("abc", YoniInPlaceSpaceURLReplace.URLify("abc", 3));
    }

    @Test
    void simpleJustExact() {
        assertEquals("a%20b", YoniInPlaceSpaceURLReplace.URLify("a b  ", 3));
        assertEquals("%20ab", YoniInPlaceSpaceURLReplace.URLify(" ab  ", 3));
    }

    @Test
    void spacesAtTheEndExact() {
        assertEquals("a%20b%20", YoniInPlaceSpaceURLReplace.URLify("a b     ", 4));
        assertEquals("%20ab%20", YoniInPlaceSpaceURLReplace.URLify(" ab     ", 4));
    }

    @Test
    void extraSpaceAtTheEnd() {
        assertEquals("abc ", YoniInPlaceSpaceURLReplace.URLify("abc ", 3));
        assertEquals("a%20b ", YoniInPlaceSpaceURLReplace.URLify("a b   ", 3));
        assertEquals("%20ab ", YoniInPlaceSpaceURLReplace.URLify(" ab   ", 3));
        assertEquals("a%20b%20 ", YoniInPlaceSpaceURLReplace.URLify("a b      ", 4));
        assertEquals("%20ab%20 ", YoniInPlaceSpaceURLReplace.URLify(" ab      ", 4));
    }

    private void checkThrows(String org, int size, String excMessage) {
        Exception exc = assertThrows(YoniException.class, () -> YoniInPlaceSpaceURLReplace.URLify(org,size));
        assertTrue(exc.getMessage().contains(excMessage));
    }

    @Test
    void emptyStringInvalidNumbers() {
        assertEquals("", YoniInPlaceSpaceURLReplace.URLify("", 0));

        checkThrows("abc", -1, "Negative");
        checkThrows(null, 0, "Null");
        checkThrows("abc", 4, "Invalid");
        checkThrows("ab c", 4, "Insufficient");
        checkThrows("ab  c   ", 5, "Insufficient");
    }
}