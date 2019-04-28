package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard5_LongestSubArrayEqual0s1sTest {

    @Test
    void testNoSubArray() {
        assertArrayEquals(new int[] {}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0}));
        assertArrayEquals(new int[] {}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,0}));
        assertArrayEquals(new int[] {}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1}));
        assertArrayEquals(new int[] {}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,1}));
    }

    @Test
    void minSubArray() {
        assertArrayEquals(new int[] {0,1}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,1}));
        assertArrayEquals(new int[] {1,0}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,0}));
        assertArrayEquals(new int[] {0,1}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,0,1}));
        assertArrayEquals(new int[] {1,0}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,1,0}));
        assertArrayEquals(new int[] {0,1}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,1,1}));
        assertArrayEquals(new int[] {1,0}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,0,0}));
    }

    @Test
    void wholeArray() {
        assertArrayEquals(new int[] {0,1,0,1}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,1,0,1}));
        assertArrayEquals(new int[] {1,0,1,0}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,0,1,0}));
        assertArrayEquals(new int[] {0,0,1,1}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,0,1,1}));
        assertArrayEquals(new int[] {1,1,0,0}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,1,0,0}));
    }

    @Test
    void variousLen4() {
        assertArrayEquals(new int[] {},          new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,0,0,0}));
        assertArrayEquals(new int[] {0,1},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,0,0,1}));
        assertArrayEquals(new int[] {0,1},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,0,1,0}));
        assertArrayEquals(new int[] {0,0,1,1},   new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,0,1,1}));
        assertArrayEquals(new int[] {0,1},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,1,0,0}));
        assertArrayEquals(new int[] {0,1,0,1},   new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,1,0,1}));
        assertArrayEquals(new int[] {0,1,1,0},   new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,1,1,0}));
        assertArrayEquals(new int[] {0,1},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {0,1,1,1}));
        assertArrayEquals(new int[] {1,0},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,0,0,0}));
        assertArrayEquals(new int[] {1,0,0,1},   new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,0,0,1}));
        assertArrayEquals(new int[] {1,0,1,0},   new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,0,1,0}));
        assertArrayEquals(new int[] {1,0},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,0,1,1}));
        assertArrayEquals(new int[] {1,1,0,0},   new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,1,0,0}));
        assertArrayEquals(new int[] {1,0},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,1,0,1}));
        assertArrayEquals(new int[] {1,0},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,1,1,0}));
        assertArrayEquals(new int[] {},          new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayWithHashtable(new int[] {1,1,1,1}));
    }

    /**
     * Initial implementation without hash table
     */

    @Test
    void testNoSubArrayInitial() {
        assertArrayEquals(new int[] {}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0}));
        assertArrayEquals(new int[] {}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,0}));
        assertArrayEquals(new int[] {}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1}));
        assertArrayEquals(new int[] {}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,1}));
    }

    @Test
    void minSubArrayInitial() {
        assertArrayEquals(new int[] {0,1}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,1}));
        assertArrayEquals(new int[] {1,0}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,0}));
        assertArrayEquals(new int[] {0,1}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,0,1}));
        assertArrayEquals(new int[] {1,0}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,1,0}));
        assertArrayEquals(new int[] {0,1}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,1,1}));
        assertArrayEquals(new int[] {1,0}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,0,0}));
    }

    @Test
    void wholeArrayInitial() {
        assertArrayEquals(new int[] {0,1,0,1}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,1,0,1}));
        assertArrayEquals(new int[] {1,0,1,0}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,0,1,0}));
        assertArrayEquals(new int[] {0,0,1,1}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,0,1,1}));
        assertArrayEquals(new int[] {1,1,0,0}, new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,1,0,0}));
    }

    @Test
    void variousLen4Initial() {
        assertArrayEquals(new int[] {},          new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,0,0,0}));
        assertArrayEquals(new int[] {0,1},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,0,0,1}));
        assertArrayEquals(new int[] {0,1},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,0,1,0}));
        assertArrayEquals(new int[] {0,0,1,1},   new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,0,1,1}));
        assertArrayEquals(new int[] {0,1},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,1,0,0}));
        assertArrayEquals(new int[] {0,1,0,1},   new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,1,0,1}));
        assertArrayEquals(new int[] {0,1,1,0},   new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,1,1,0}));
        assertArrayEquals(new int[] {0,1},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {0,1,1,1}));
        assertArrayEquals(new int[] {1,0},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,0,0,0}));
        assertArrayEquals(new int[] {1,0,0,1},   new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,0,0,1}));
        assertArrayEquals(new int[] {1,0,1,0},   new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,0,1,0}));
        assertArrayEquals(new int[] {1,0},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,0,1,1}));
        assertArrayEquals(new int[] {1,1,0,0},   new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,1,0,0}));
        assertArrayEquals(new int[] {1,0},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,1,0,1}));
        assertArrayEquals(new int[] {1,0},       new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,1,1,0}));
        assertArrayEquals(new int[] {},          new YK_Hard5_LongestSubArrayEqual0s1s().getSubArrayInitial(new int[] {1,1,1,1}));
    }
}