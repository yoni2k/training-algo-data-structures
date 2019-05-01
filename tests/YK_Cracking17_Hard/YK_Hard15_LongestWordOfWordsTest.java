package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard15_LongestWordOfWordsTest {

    @Test
    void simple() {
        String[] words = {"dog", "walker", "dogwalker", "dogdog", "dogwalk", "walk", "walkdo", "walkdogwalke"};

        assertEquals("dogwalker", new YK_Hard15_LongestWordOfWords().getLongestWordOfWords(words));
    }

    @Test
    void noneExists() {
        String[] words = {"dog", "walker", "walk", "dogwalke", "dogwalkerr"};

        assertNull(new YK_Hard15_LongestWordOfWords().getLongestWordOfWords(words));
    }

    /**
     * After reading tips in the book
     */

    @Test
    void simpleSplits() {
        String[] words = {"dog", "walker", "dogwalker", "dogdog", "dogwalk", "walk", "walkdo", "walkdogwalke"};

        assertEquals("dogwalker", new YK_Hard15_LongestWordOfWords().getLongestWordOfWordsSplits(words));
    }

    @Test
    void noneExistsSplits() {
        String[] words = {"dog", "walker", "walk", "dogwalke", "dogwalkerr"};

        assertNull(new YK_Hard15_LongestWordOfWords().getLongestWordOfWordsSplits(words));
    }
}