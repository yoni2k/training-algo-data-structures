package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod26_CalcTest {

    @Test
    void test() {
        assertEquals(6, new YK_Mod26_Calc().calc("2*3"));
        assertEquals(5, new YK_Mod26_Calc().calc("2+3"));
        assertEquals(10, new YK_Mod26_Calc().calc("2*3+4"));
        assertEquals(14, new YK_Mod26_Calc().calc("2+3*4"));
        assertEquals(1.25, new YK_Mod26_Calc().calc("2-3/4"));
        assertEquals(-3.5, new YK_Mod26_Calc().calc("2/4-4"));
        assertEquals(23.5, new YK_Mod26_Calc().calc("2*3+5/6*3+15"));

    }

}