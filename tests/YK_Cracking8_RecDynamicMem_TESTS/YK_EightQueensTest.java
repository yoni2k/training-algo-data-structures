package YK_Cracking8_RecDynamicMem_TESTS;

import YK_Cracking8_RecDynamicMem.YK_EightQueens;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_EightQueensTest {

    @Test
    void queens1() {
        assertEquals(1, new YK_EightQueens().printGetNumQueens(1) );
    }

    @Test
    void queens2() {
        assertEquals(0, new YK_EightQueens().printGetNumQueens(2) );
    }

    @Test
    void queens3() {
        assertEquals(0, new YK_EightQueens().printGetNumQueens(3) );
    }

    @Test
    void queens4() {
        assertEquals(2, new YK_EightQueens().printGetNumQueens(4) );
    }

    @Test
    void queens8() {
        assertEquals(92, new YK_EightQueens().printGetNumQueens(8) );
    }
}