import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueCharsTest {

    @Test
    void emptyNullString() {
        assertTrue(UniqueChars.isUnique(""));

        Exception exc = assertThrows(YoniException.class, () -> UniqueChars.isUnique(null));
        assertTrue(exc.getMessage().contains("Null"));

    }

    @Test
    void unique() {
        assertTrue(UniqueChars.isUnique("abcd"));
        assertTrue(UniqueChars.isUnique("abcABC"));//Case insensitive
    }

    @Test
    void notUnique() {
        assertFalse(UniqueChars.isUnique("abca"));//beg end
        assertFalse(UniqueChars.isUnique("aabc"));//following letters
    }

    @Test
    void validRange() {
        String smallLetters =   "abcdefghijklmnopqrstuvxyz";
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String numbers = "1234567890";
        String space = " ";

        assertTrue(UniqueChars.isUnique(smallLetters));
        assertTrue(UniqueChars.isUnique(capitalLetters));
        assertTrue(UniqueChars.isUnique(numbers));
        assertTrue(UniqueChars.isUnique(space));
    }

    private void isInvalidThrown(String str) {
        Exception exc = assertThrows(YoniException.class, () -> UniqueChars.isUnique(str));
        assertTrue(exc.getMessage().contains("Invalid"));
    }

    @Test
    void outsideOfValidRange() {

        String invalidStr = "~!@#$%^&*()_+`-=[]\\{}|;':\",./<>?";
        String strBegUnique = "abc";
        String strEndUnique = "xyz";
        String strBegNotUnique = "aabc";
        String strEndNotUnique = "xxyz";

        char[] invalidChars = invalidStr.toCharArray();

        for(char c : invalidChars) {

            isInvalidThrown(c + strEndUnique);//beginning unique
            isInvalidThrown(strBegUnique + c + strEndUnique);//middle unique
            isInvalidThrown(strBegUnique + c);//end unique

            isInvalidThrown(c + strEndNotUnique);//beginning not unique
            isInvalidThrown(strBegNotUnique + c + strEndNotUnique);//middle not unique
            isInvalidThrown(strBegNotUnique + c);//end not unique
        }
    }

    /* ------------------------------------------
     From here same tests without using Hash Map
     ------------------------------------------*/
    @Test
    void emptyNullStringNoHash() {
        assertTrue(UniqueChars.isUniqueNoDataStructures(""));

        Exception exc = assertThrows(YoniException.class, () -> UniqueChars.isUniqueNoDataStructures(null));
        assertTrue(exc.getMessage().contains("Null"));

    }

    @Test
    void uniqueNoHash() {
        assertTrue(UniqueChars.isUniqueNoDataStructures("abcd"));
        assertTrue(UniqueChars.isUniqueNoDataStructures("abcABC"));//Case insensitive
    }

    @Test
    void notUniqueNoHash() {
        assertFalse(UniqueChars.isUniqueNoDataStructures("abca"));//beg end
        assertFalse(UniqueChars.isUniqueNoDataStructures("aabc"));//following letters
    }

    @Test
    void validRangeNoHash() {
        String smallLetters =   "abcdefghijklmnopqrstuvxyz";
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String numbers = "1234567890";
        String space = " ";

        assertTrue(UniqueChars.isUniqueNoDataStructures(smallLetters));
        assertTrue(UniqueChars.isUniqueNoDataStructures(capitalLetters));
        assertTrue(UniqueChars.isUniqueNoDataStructures(numbers));
        assertTrue(UniqueChars.isUniqueNoDataStructures(space));
    }

    private void isInvalidThrownNoHash(String str) {
        Exception exc = assertThrows(YoniException.class, () -> UniqueChars.isUniqueNoDataStructures(str));
        assertTrue(exc.getMessage().contains("Invalid"));
    }

    @Test
    void outsideOfValidRangeNoHash() {

        String invalidStr = "~!@#$%^&*()_+`-=[]\\{}|;':\",./<>?";
        String strBegUnique = "abc";
        String strEndUnique = "xyz";
        String strBegNotUnique = "aabc";
        String strEndNotUnique = "xxyz";

        char[] invalidChars = invalidStr.toCharArray();

        for(char c : invalidChars) {

            isInvalidThrownNoHash(c + strEndUnique);//beginning unique
            isInvalidThrownNoHash(strBegUnique + c + strEndUnique);//middle unique
            isInvalidThrownNoHash(strBegUnique + c);//end unique

            isInvalidThrownNoHash(c + strEndNotUnique);//beginning not unique
            isInvalidThrownNoHash(strBegNotUnique + c + strEndNotUnique);//middle not unique
            isInvalidThrownNoHash(strBegNotUnique + c);//end not unique
        }
    }
}