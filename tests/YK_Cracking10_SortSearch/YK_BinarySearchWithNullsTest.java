package YK_Cracking10_SortSearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_BinarySearchWithNullsTest {

    @Test
    void array1Yes () {
        String[] arr = {"ab"};

        assertEquals(0, new YK_BinarySearchWithNulls().findString(arr, "ab"));
    }

    @Test
    void array1NoBefore () {
        String[] arr = {"aa"};

        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "ab"));
    }

    @Test
    void array1NoAfter () {
        String[] arr = {"ac"};

        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "ab"));
    }

    @Test
    void array2NullFirstYes () {
        String[] arr = {"","ab"};

        assertEquals(1, new YK_BinarySearchWithNulls().findString(arr, "ab"));
    }

    @Test
    void array2NullSecondYes () {
        String[] arr = {"ab",""};

        assertEquals(0, new YK_BinarySearchWithNulls().findString(arr, "ab"));
    }

    @Test
    void arrayLargeNoAllNulls () {
        String[] arr = {"", "", "","","","","","","","","","","","","","","","","",""};

        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "ab"));
    }

    @Test
    void arrayLargeYesVariousPlaces() {
        String[] arr = {"a","","b","","","c","d","","e","","","","f","g","","","h","i","","j","","k","","l","m","","","n","",""};

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("") == false) {
                assertEquals(i, new YK_BinarySearchWithNulls().findString(arr, arr[i]));
            }
        }
    }

    @Test
    void arrayLargeNoVariousPlaces() {
        String[] arr = {"","","b","","","c","d","","e","","","","f","g","","","h","i","","j","","k","","l","m","","","n","",""};

        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "a"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "ba"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "ca"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "da"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "ea"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "fa"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "ga"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "ha"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "ia"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "ja"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "ka"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "la"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "ma"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "na"));
        assertEquals(-1, new YK_BinarySearchWithNulls().findString(arr, "o"));
    }


}