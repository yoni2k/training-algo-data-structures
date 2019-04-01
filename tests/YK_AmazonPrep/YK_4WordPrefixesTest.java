package YK_AmazonPrep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_4WordPrefixesTest {

    @Test
    void emptyTree() {
        String[] exp = {};
        YK_4WordPrefixes prefs = new YK_4WordPrefixes();

        assertEquals(0, prefs.getNumPref("eli"));
        assertArrayEquals(exp, prefs.getWordsWithPref("eli"));
    }

    @Test
    void oneLetter() {
        YK_4WordPrefixes prefs = new YK_4WordPrefixes();

        prefs.add("e");

        String[] exp1 = {};
        assertEquals(0, prefs.getNumPref("eli"));
        assertArrayEquals(exp1, prefs.getWordsWithPref("eli"));

        String[] exp2 = {"e"};
        assertEquals(1, prefs.getNumPref("e"));
        assertArrayEquals(exp2, prefs.getWordsWithPref("e"));
    }

    @Test
    void oneFullWord() {
        YK_4WordPrefixes prefs = new YK_4WordPrefixes();

        prefs.add("eli");

        String[] exp1 = {"eli"};
        assertEquals(1, prefs.getNumPref("eli"));
        assertArrayEquals(exp1, prefs.getWordsWithPref("eli"));
    }

    @Test
    void onePartialWord() {
        YK_4WordPrefixes prefs = new YK_4WordPrefixes();

        prefs.add("eliav");

        String[] exp1 = {"eliav"};
        assertEquals(1, prefs.getNumPref("eli"));
        assertArrayEquals(exp1, prefs.getWordsWithPref("eli"));
    }

    @Test
    void twoPartialWords() {
        YK_4WordPrefixes prefs = new YK_4WordPrefixes();

        prefs.add("eliav");
        prefs.add("eliad");
        prefs.add("amitai");

        String[] expBoth = {"eliad","eliav"};
        String[] expEliav = {"eliav"};
        String[] expEliad = {"eliad"};
        assertEquals(2, prefs.getNumPref("e"));
        assertArrayEquals(expBoth, prefs.getWordsWithPref("e"));

        assertEquals(2, prefs.getNumPref("el"));
        assertArrayEquals(expBoth, prefs.getWordsWithPref("el"));

        assertEquals(2, prefs.getNumPref("eli"));
        assertArrayEquals(expBoth, prefs.getWordsWithPref("eli"));

        assertEquals(2, prefs.getNumPref("elia"));
        assertArrayEquals(expBoth, prefs.getWordsWithPref("elia"));

        assertEquals(1, prefs.getNumPref("eliav"));
        assertArrayEquals(expEliav, prefs.getWordsWithPref("eliav"));

        assertEquals(1, prefs.getNumPref("eliad"));
        assertArrayEquals(expEliad, prefs.getWordsWithPref("eliad"));
    }

    @Test
    void twoWordsDiffLen() {
        YK_4WordPrefixes prefs = new YK_4WordPrefixes();

        prefs.add("eliavile");
        prefs.add("eliad");
        prefs.add("amitai");

        String[] expBoth = {"eliad","eliavile"};
        String[] expEliav = {"eliavile"};
        String[] expEliad = {"eliad"};
        assertEquals(2, prefs.getNumPref("e"));
        assertArrayEquals(expBoth, prefs.getWordsWithPref("e"));

        assertEquals(2, prefs.getNumPref("el"));
        assertArrayEquals(expBoth, prefs.getWordsWithPref("el"));

        assertEquals(2, prefs.getNumPref("eli"));
        assertArrayEquals(expBoth, prefs.getWordsWithPref("eli"));

        assertEquals(2, prefs.getNumPref("elia"));
        assertArrayEquals(expBoth, prefs.getWordsWithPref("elia"));

        assertEquals(1, prefs.getNumPref("eliav"));
        assertArrayEquals(expEliav, prefs.getWordsWithPref("eliav"));

        assertEquals(1, prefs.getNumPref("eliavile"));
        assertArrayEquals(expEliav, prefs.getWordsWithPref("eliav"));

        assertEquals(1, prefs.getNumPref("eliad"));
        assertArrayEquals(expEliad, prefs.getWordsWithPref("eliad"));
    }

}