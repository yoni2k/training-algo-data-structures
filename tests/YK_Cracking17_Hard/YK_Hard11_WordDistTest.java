package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard11_WordDistTest {

    @Test
    void testStandalone() {
        String[] dic = {"a", "b", "a", "c", "a", "b", "c"};

        assertEquals(1, new YK_Hard11_WordDist(dic).minDist(dic, "a", "b"));
        assertEquals(1, new YK_Hard11_WordDist(dic).minDist(dic, "a", "c"));
        assertEquals(1, new YK_Hard11_WordDist(dic).minDist(dic, "b", "a"));
        assertEquals(1, new YK_Hard11_WordDist(dic).minDist(dic, "b", "c"));
        assertEquals(1, new YK_Hard11_WordDist(dic).minDist(dic, "c", "a"));
        assertEquals(2, new YK_Hard11_WordDist(dic).minDist(dic, "c", "b"));
    }

    @Test
    void testPreProcess() {
        String[] dic = {"a", "b", "a", "c", "a", "b", "c"};
        YK_Hard11_WordDist dist = new YK_Hard11_WordDist(dic);

        assertEquals(1, dist.minDist("a", "b"));
        assertEquals(1, dist.minDist("a", "c"));
        assertEquals(1, dist.minDist("b", "a"));
        assertEquals(1, dist.minDist("b", "c"));
        assertEquals(1, dist.minDist("c", "a"));
        assertEquals(2, dist.minDist("c", "b"));
    }

}