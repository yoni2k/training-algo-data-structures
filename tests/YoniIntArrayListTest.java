import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class YoniIntArrayListTest {

    @Test
    void createDefaultCapacity() {
        YoniIntArrayList al = new YoniIntArrayList();

        assertEquals(10, al.getCapacity());
        assertEquals(0, al.size());
        assertEquals("", al.toString());

    }

    @Test
    void createLargeCapacity() {
        YoniIntArrayList al = new YoniIntArrayList(100);

        assertEquals(100, al.getCapacity());
        assertEquals(0, al.size());
        assertEquals("", al.toString());
    }

    @Test
    void createNegativeCapacity() {
        YoniException exc = assertThrows(YoniException.class, () -> new YoniIntArrayList(-2) );
        assertTrue(exc.getMessage().contains("Negative"));
    }

    @Test
    void addLessCapacity() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());
    }

    @Test
    void enlarge() {
        YoniIntArrayList al = new YoniIntArrayList();
        assertEquals(10, al.getCapacity());

        for (int i = 1; i <= 15; i++) {
            al.add(i);
        }

        assertEquals(20, al.getCapacity());
        assertEquals(15, al.size());
        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 ", al.toString());
    }

    @Test
    void addAtIndexBeginning() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.add(0, 100);

        assertEquals(10, al.getCapacity());
        assertEquals(6, al.size());
        assertEquals("100 1 2 3 4 5 ", al.toString());
    }

    @Test
    void addAtIndexEnd() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.add(5, 100);

        assertEquals(10, al.getCapacity());
        assertEquals(6, al.size());
        assertEquals("1 2 3 4 5 100 ", al.toString());
    }

    @Test
    void addMiddle() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.add(2, 100);

        assertEquals(10, al.getCapacity());
        assertEquals(6, al.size());
        assertEquals("1 2 100 3 4 5 ", al.toString());
    }

    @Test
    void addAtIndexBeginningNoRoom() {
        YoniIntArrayList al = new YoniIntArrayList(5);

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(5, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.add(0, 100);

        assertEquals(10, al.getCapacity());
        assertEquals(6, al.size());
        assertEquals("100 1 2 3 4 5 ", al.toString());
    }

    @Test
    void addAtIndexEndNoRoom() {
        YoniIntArrayList al = new YoniIntArrayList(5);

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(5, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.add(5, 100);

        assertEquals(10, al.getCapacity());
        assertEquals(6, al.size());
        assertEquals("1 2 3 4 5 100 ", al.toString());
    }

    @Test
    void addMiddleNoRoom() {
        YoniIntArrayList al = new YoniIntArrayList(5);

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(5, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.add(2, 100);

        assertEquals(10, al.getCapacity());
        assertEquals(6, al.size());
        assertEquals("1 2 100 3 4 5 ", al.toString());
    }

    @Test
    void addNegativeIndex() {
        YoniIntArrayList al = new YoniIntArrayList(5);

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(5, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        YoniException exc = assertThrows(YoniException.class, () -> al.add(-2, 100));
        assertTrue(exc.getMessage().contains("Negative"));
    }

    @Test
    void addTooLargeIndex() {
        YoniIntArrayList al = new YoniIntArrayList(5);

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(5, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        YoniException exc = assertThrows(YoniException.class, () -> al.add(7, 100));
        assertTrue(exc.getMessage().contains("Invalid"));
    }

    @Test
    void addIndexLargerThanCapacity() {
        YoniIntArrayList al = new YoniIntArrayList(5);

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(5, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        YoniException exc = assertThrows(YoniException.class, () -> al.add(7, 100));
        assertTrue(exc.getMessage().contains("Invalid"));
    }

    @Test
    void clear() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 11; i++)
            al.add(i);

        assertEquals(20, al.getCapacity());
        assertEquals(11, al.size());
        assertEquals("1 2 3 4 5 6 7 8 9 10 11 ", al.toString());

        al.clear();

        assertEquals(20, al.getCapacity());
        assertEquals(0, al.size());
        assertEquals("", al.toString());
    }

    @Test
    void contains() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        assertTrue(al.contains(1));
        assertTrue(al.contains(3));
        assertTrue(al.contains(5));
        assertFalse(al.contains(6));
    }

    @Test
    void ensureCapacity() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.ensureCapacity(15);

        assertEquals(15, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());
    }

    @Test
    void get() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        assertEquals(1, al.get(0));
        assertEquals(3, al.get(2));
        assertEquals(5,al.get(4));

        YoniException exc;
        exc = assertThrows(YoniException.class, () -> al.get(-1));
        assertTrue(exc.getMessage().contains("Negative"));

        exc = assertThrows(YoniException.class, () -> al.get(6));
        assertTrue(exc.getMessage().contains("Invalid"));

        exc = assertThrows(YoniException.class, () -> al.get(9));
        assertTrue(exc.getMessage().contains("Invalid"));

        exc = assertThrows(YoniException.class, () -> al.get(10));
        assertTrue(exc.getMessage().contains("Invalid"));

        exc = assertThrows(YoniException.class, () -> al.get(11));
        assertTrue(exc.getMessage().contains("Invalid"));
    }

    @Test
    void removeFirst() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.remove(0);

        assertEquals(10, al.getCapacity());
        assertEquals(4, al.size());
        assertEquals("2 3 4 5 ", al.toString());
    }

    @Test
    void removeMiddle() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.remove(2);

        assertEquals(10, al.getCapacity());
        assertEquals(4, al.size());
        assertEquals("1 2 4 5 ", al.toString());
    }

    @Test
    void removeEnd() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.remove(4);

        assertEquals(10, al.getCapacity());
        assertEquals(4, al.size());
        assertEquals("1 2 3 4 ", al.toString());
    }

    @Test
    void removeInvalid() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        YoniException exc;
        exc = assertThrows(YoniException.class, () -> al.remove(-1));
        assertTrue(exc.getMessage().contains("Negative"));

        exc = assertThrows(YoniException.class, () -> al.remove(5));
        assertTrue(exc.getMessage().contains("Invalid"));

        exc = assertThrows(YoniException.class, () -> al.remove(9));
        assertTrue(exc.getMessage().contains("Invalid"));

        exc = assertThrows(YoniException.class, () -> al.remove(10));
        assertTrue(exc.getMessage().contains("Invalid"));

        exc = assertThrows(YoniException.class, () -> al.remove(20));
        assertTrue(exc.getMessage().contains("Invalid"));
    }

    @Test
    void setFirst() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.set(0, 100);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("100 2 3 4 5 ", al.toString());
    }

    @Test
    void setMiddle() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.set(2, 100);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 100 4 5 ", al.toString());
    }

    @Test
    void setEnd() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        al.set(4, 100);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 100 ", al.toString());
    }

    @Test
    void setInvalid() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());

        YoniException exc;



        exc = assertThrows(YoniException.class, () -> al.set(-1, 100));
        assertTrue(exc.getMessage().contains("Negative"));

        exc = assertThrows(YoniException.class, () -> al.set(5, 100));
        assertTrue(exc.getMessage().contains("Invalid"));

        exc = assertThrows(YoniException.class, () -> al.set(9, 100));
        assertTrue(exc.getMessage().contains("Invalid"));

        exc = assertThrows(YoniException.class, () -> al.set(10, 100));
        assertTrue(exc.getMessage().contains("Invalid"));

        exc = assertThrows(YoniException.class, () -> al.set(20, 100));
        assertTrue(exc.getMessage().contains("Invalid"));
    }
    @Test
    void trimToSizeMoreMin() {
        YoniIntArrayList al = new YoniIntArrayList(100);

        for (int i = 1; i <= 100; i++)
            al.add(i);

        assertEquals(100, al.getCapacity());
        assertEquals(100, al.size());

        for(int i = 99; i > 14; i--)
            al.remove(i);

        assertEquals(100, al.getCapacity());
        assertEquals(15, al.size());

        al.trimToSize();

        assertEquals(15, al.getCapacity());
        assertEquals(15, al.size());
    }

    @Test
    void trimToSizeLessMinWasMoreThanDefault() {
        YoniIntArrayList al = new YoniIntArrayList(100);

        for (int i = 1; i <= 100; i++)
            al.add(i);

        assertEquals(100, al.getCapacity());
        assertEquals(100, al.size());

        for(int i = 99; i > 4; i--)
            al.remove(i);

        assertEquals(100, al.getCapacity());
        assertEquals(5, al.size());

        al.trimToSize();

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());
    }

    @Test
    void trimToSizeLessMinWasDefault() {
        YoniIntArrayList al = new YoniIntArrayList();

        for (int i = 1; i <= 5; i++)
            al.add(i);

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());


        al.trimToSize();

        assertEquals(10, al.getCapacity());
        assertEquals(5, al.size());
        assertEquals("1 2 3 4 5 ", al.toString());
    }
}