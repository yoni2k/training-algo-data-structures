package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod20_PhoneWordsTest {

    @Test
    void emptyList() {
        String[] words = {"i","am","just","putting","a","few","random","words","tree","used"};
        String[] exp = {};
        int[] nums = {8,7,3,4};

        assertArrayEquals(exp, new YK_Mod20_PhoneWords().getMatchingWords(words, nums));

    }

    @Test
    void multValues() {
        String[] words = {"i","am","just","putting","a","few","random","words","tree","used"};
        String[] exp = {"tree","used"};
        int[] nums = {8,7,3,3};

        assertArrayEquals(exp, new YK_Mod20_PhoneWords().getMatchingWords(words, nums));

    }

    @Test
    void emptyListPreProcess() {
        String[] words = {"i","am","just","putting","a","few","random","words","tree","used"};
        String[] exp = {};
        String nums = "8734";

        YK_Mod20_PhoneWords phone = new YK_Mod20_PhoneWords(words);

        assertArrayEquals(exp, phone.getMatchingWords(nums));

    }

    @Test
    void multValuesPreProcess() {
        String[] words = {"i","am","just","putting","a","few","random","words","tree","used"};
        String[] exp = {"tree","used"};
        String nums = "8733";

        YK_Mod20_PhoneWords phone = new YK_Mod20_PhoneWords(words);

        assertArrayEquals(exp, phone.getMatchingWords(nums));
    }

}