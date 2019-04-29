package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard7_RepeatingNamesFreqsTest {

    @Test
    void test() {
        String[][] init = new String[][] {
                {"1", "11"},
                {"2", "12"},
                {"3", "13"},
                {"4", "14"},
                {"5", "15"}
        };

        String[][] pairs = new String[][] {
                {"1","2"},
                {"1","4"},
                {"5","1"}
        };

        String[][] exp = new String[][] {
                {"1","52"},
                {"3", "13"}
        };

        assertArrayEquals(exp, new YK_Hard7_RepeatingNamesFreqs().getRealFreq(init, pairs));
    }

    @Test
    void testNoneConnected() {
        String[][] init = new String[][] {
                {"1","11"},
                {"2","12"},
                {"3", "13"},
                {"4", "14"}
        };

        String[][] pairs = new String[][] {
        };

        String[][] exp = new String[][] {
                {"1","11"},
                {"2","12"},
                {"3", "13"},
                {"4", "14"}
        };

        assertArrayEquals(exp, new YK_Hard7_RepeatingNamesFreqs().getRealFreq(init, pairs));
    }

    @Test
    void testAllConnected() {
        String[][] init = new String[][] {
                {"1","11"},
                {"2","12"},
                {"3", "13"},
                {"4", "14"}
        };

        String[][] pairs = new String[][] {
                {"1","2"},
                {"1","4"},
                {"3","2"}
        };

        String[][] exp = new String[][] {
                {"1","50"}
        };

        assertArrayEquals(exp, new YK_Hard7_RepeatingNamesFreqs().getRealFreq(init, pairs));
    }

}