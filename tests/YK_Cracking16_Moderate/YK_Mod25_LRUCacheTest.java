package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod25_LRUCacheTest {
    @Test
    void simple() {
        YK_Mod25_LRUCache cache = new YK_Mod25_LRUCache(3);

        cache.insert(1,11); cache.printList();
        cache.insert(2,12); cache.printList();
        cache.insert(3,13); cache.printList();

        assertEquals(11, cache.retrieve(1));cache.printList();
        assertEquals(12, cache.retrieve(2));cache.printList();
        assertEquals(13, cache.retrieve(3));cache.printList();

        cache.insert(4,14);cache.printList();

        assertEquals(12, cache.retrieve(2));cache.printList();
        assertEquals(13, cache.retrieve(3));cache.printList();
        assertEquals(14, cache.retrieve(4));cache.printList();

        assertThrows(NullPointerException.class, () -> cache.retrieve(1));cache.printList();

        cache.update(2, 22);cache.printList();
        cache.insert(5,15);cache.printList();

        assertEquals(14, cache.retrieve(4));cache.printList();
        assertEquals(22, cache.retrieve(2));cache.printList();
        assertEquals(15, cache.retrieve(5));cache.printList();

        assertThrows(NullPointerException.class, () -> cache.retrieve(3));cache.printList();
    }

}