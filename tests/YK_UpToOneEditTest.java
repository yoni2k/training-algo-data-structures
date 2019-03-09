import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_UpToOneEditTest {

    @Test
    void newClass() { new YK_UpToOneEdit(); }

    private void checkThrows(String s1, String s2, @SuppressWarnings("SameParameterValue") String excMessage) {
        Exception ex = assertThrows(YK_Exception.class, () -> YK_UpToOneEdit.isUpToOneEdit(s1,s2));
        assertTrue(ex.getMessage().contains(excMessage));
    }

    @Test
    void nullEmptyStrings() {

        checkThrows(null, "ab", "Null");
        checkThrows("ab", null, "Null");
        checkThrows(null, null, "Null");

        assertTrue(YK_UpToOneEdit.isUpToOneEdit("", ""));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("a", ""));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("", "a"));
    }

    @Test
    void same() {
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("", ""));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("abc","abc"));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("a","a"));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("aa","aa"));
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    void diffSameLen() {
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("ab","ba"));//2 changes
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abc","cba"));//same letters, 2 changes
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("aac","XXc"));//consecutive, beginning
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abbc","aXXc"));//consecutive, middle
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abcc","abXX"));//consecutive, end
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abcd","XbXd"));//beginning, middle
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abcd","XbcX"));//beginning, end
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abcdef","abXdXf"));//middle, middle
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abcd","aXcX"));//middle, end
    }

    @Test
    void lengthVeryDifferent() {
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("","ba"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("ba",""));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("a","aaa"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("aaa","a"));
    }

    @Test
    void lenOneDiffOK() {
        //length 0 and 1
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("","a"));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("a",""));

        //length 1 and 2
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("ab","a"));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("ab","b"));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("a","ab"));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("b","ab"));

        //length 2 and 3 - regular
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("abc","bc"));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("abc","ac"));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("abc","ab"));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("bc","abc"));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("ac","abc"));
        assertTrue(YK_UpToOneEdit.isUpToOneEdit("ab","abc"));
    }

    @Test
    void lenOneDiffNotOK() {
        //length 1 & 2
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("ab","c"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("c","ab"));

        //length 2 & 3
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abc","aa"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abc","ba"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abc","bb"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abc","cc"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abc","ca"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("abc","cb"));

        assertFalse(YK_UpToOneEdit.isUpToOneEdit("aa","abc"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("ba","abc"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("bb","abc"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("cc","abc"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("ca","abc"));
        assertFalse(YK_UpToOneEdit.isUpToOneEdit("cb","abc"));

    }
}