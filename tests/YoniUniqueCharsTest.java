import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YoniUniqueCharsTest {

    @Test
    void emptyNullString() {
        assertTrue(YoniUniqueChars.isUnique(""));

        Exception exc = assertThrows(YoniException.class, () -> YoniUniqueChars.isUnique(null));
        assertTrue(exc.getMessage().contains("Null"));

    }

    @Test
    void unique() {
        assertTrue(YoniUniqueChars.isUnique("abcd"));
        assertTrue(YoniUniqueChars.isUnique("abcABC"));//Case insensitive
    }

    @Test
    void notUnique() {
        assertFalse(YoniUniqueChars.isUnique("abca"));//beg end
        assertFalse(YoniUniqueChars.isUnique("aabc"));//following letters
    }

    @Test
    void validRange() {
        String smallLetters =   "abcdefghijklmnopqrstuvxyz";
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String numbers = "1234567890";
        String space = " ";

        assertTrue(YoniUniqueChars.isUnique(smallLetters));
        assertTrue(YoniUniqueChars.isUnique(capitalLetters));
        assertTrue(YoniUniqueChars.isUnique(numbers));
        assertTrue(YoniUniqueChars.isUnique(space));
    }

    private void isInvalidThrown(String str) {
        Exception exc = assertThrows(YoniException.class, () -> YoniUniqueChars.isUnique(str));
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
        assertTrue(YoniUniqueChars.isUniqueNoDataStructures(""));

        Exception exc = assertThrows(YoniException.class, () -> YoniUniqueChars.isUniqueNoDataStructures(null));
        assertTrue(exc.getMessage().contains("Null"));

    }

    @Test
    void uniqueNoHash() {
        assertTrue(YoniUniqueChars.isUniqueNoDataStructures("abcd"));
        assertTrue(YoniUniqueChars.isUniqueNoDataStructures("abcABC"));//Case insensitive
    }

    @Test
    void notUniqueNoHash() {
        assertFalse(YoniUniqueChars.isUniqueNoDataStructures("abca"));//beg end
        assertFalse(YoniUniqueChars.isUniqueNoDataStructures("aabc"));//following letters
    }

    @Test
    void validRangeNoHash() {
        String smallLetters =   "abcdefghijklmnopqrstuvxyz";
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String numbers = "1234567890";
        String space = " ";

        assertTrue(YoniUniqueChars.isUniqueNoDataStructures(smallLetters));
        assertTrue(YoniUniqueChars.isUniqueNoDataStructures(capitalLetters));
        assertTrue(YoniUniqueChars.isUniqueNoDataStructures(numbers));
        assertTrue(YoniUniqueChars.isUniqueNoDataStructures(space));
    }

    private void isInvalidThrownNoHash(String str) {
        Exception exc = assertThrows(YoniException.class, () -> YoniUniqueChars.isUniqueNoDataStructures(str));
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