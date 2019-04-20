package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod16_MinPartArrayToOrderTest {

    @Test
    void ordered() {
        int[] arr = {1,2,3};
        int[] exp = {0,0};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrder(arr));
    }

    @Test
    void orderedEvenNum() {
        int[] arr = {1,2,3,4};
        int[] exp = {0,0};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrder(arr));
    }

    @Test
    void oppOrder() {
        int[] arr = {3,2,1};
        int[] exp = {0,3};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrder(arr));
    }

    @Test
    void oppOrderEvenNum() {
        int[] arr = {4,3,2,1};
        int[] exp = {0,4};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrder(arr));
    }

    @Test
    void complicated() {
        int[] arr = {1,4,17,18,3,22,10,16,20,25};
        int[] exp = {1,9};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrder(arr));
    }

    @Test
    void startOrdered() {
        int[] arr = {1,2,4,3};
        int[] exp = {2,4};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrder(arr));
    }

    @Test
    void endOrdered() {
        int[] arr = {2,1,3,4};
        int[] exp = {0,2};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrder(arr));
    }

    @Test
    void orderedOneFunc() {
        int[] arr = {1,2,3};
        int[] exp = {0,0};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrderOneFunc(arr));
    }

    @Test
    void orderedEvenNumOneFunc() {
        int[] arr = {1,2,3,4};
        int[] exp = {0,0};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrderOneFunc(arr));
    }

    @Test
    void oppOrderOneFunc() {
        int[] arr = {3,2,1};
        int[] exp = {0,3};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrderOneFunc(arr));
    }

    @Test
    void oppOrderEvenNumOneFunc() {
        int[] arr = {4,3,2,1};
        int[] exp = {0,4};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrderOneFunc(arr));
    }

    @Test
    void complicatedOneFunc() {
        int[] arr = {1,4,17,18,3,22,10,16,20,25};
        int[] exp = {1,9};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrderOneFunc(arr));
    }

    @Test
    void startOrderedOneFunc() {
        int[] arr = {1,2,4,3};
        int[] exp = {2,4};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrderOneFunc(arr));
    }

    @Test
    void endOrderedOneFunc() {
        int[] arr = {2,1,3,4};
        int[] exp = {0,2};

        assertArrayEquals(exp, new YK_Mod16_MinPartArrayToOrder().getIndexesToOrderOneFunc(arr));
    }
}