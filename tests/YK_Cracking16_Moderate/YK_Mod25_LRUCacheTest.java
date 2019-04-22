package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod25_LRUCacheTest {
    @Test
    void simple() {
        YK_Mod25_LRUCache cache = new YK_Mod25_LRUCache(3);

        cache.insert(1,11);
        cache.insert(2,12);
        cache.insert(3,13);

        assertEquals(11, cache.retrieve(1));
        assertEquals(12, cache.retrieve(2));
        assertEquals(13, cache.retrieve(3));

        cache.insert(4,14);

        assertEquals(12, cache.retrieve(2));
        assertEquals(13, cache.retrieve(3));
        assertEquals(14, cache.retrieve(4));

        assertThrows(NullPointerException.class, () -> cache.retrieve(1));

        cache.update(2, 22);
        cache.insert(5,15);

        assertEquals(14, cache.retrieve(4));
        assertEquals(22, cache.retrieve(2));
        assertEquals(15, cache.retrieve(5));

        assertThrows(NullPointerException.class, () -> cache.retrieve(3));


    }

}