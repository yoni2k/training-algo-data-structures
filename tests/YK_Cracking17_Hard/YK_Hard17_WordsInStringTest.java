package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard17_WordsInStringTest {

    @Test
    void test() {
        String word = "cate";
        String[] words = {"a","cat","ate","tee"};
        boolean[] exp = {true, true, true, false};

        assertArrayEquals(exp, new YK_Hard17_WordsInString().subStringsInLarge(word, words));
    }

}