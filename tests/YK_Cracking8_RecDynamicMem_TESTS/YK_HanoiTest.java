package YK_Cracking8_RecDynamicMem_TESTS;

import YK_Cracking8_RecDynamicMem.YK_Hanoi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_HanoiTest {

    @Test
    void hanoi1Adjacent() {
        assertEquals(2, new YK_Hanoi().countMovesHanoiAdjacent(1));
    }

    @Test
    void hanoi2Adjacent() {
        assertEquals(8, new YK_Hanoi().countMovesHanoiAdjacent(2));
    }

    @Test
    void hanoi3Adjacent() {
        assertEquals(26, new YK_Hanoi().countMovesHanoiAdjacent(3));
    }

    @Test
    void hanoi4Adjacent() {
        assertEquals(80, new YK_Hanoi().countMovesHanoiAdjacent(4));
    }

    @Test
    void hanoi1() {
        assertEquals(1, new YK_Hanoi().countMovesHanoi(1));
    }

    @Test
    void hanoi2() {
        assertEquals(3, new YK_Hanoi().countMovesHanoi(2));
    }

    @Test
    void hanoi3() {
        assertEquals(7, new YK_Hanoi().countMovesHanoi(3));
    }

    @Test
    void hanoi4() {
        assertEquals(15, new YK_Hanoi().countMovesHanoi(4));
    }
}