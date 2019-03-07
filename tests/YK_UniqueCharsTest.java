import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_UniqueCharsTest {

    @Test
    void emptyNullString() {
        assertTrue(YK_UniqueChars.isUnique(""));

        Exception exc = assertThrows(YK_Exception.class, () -> YK_UniqueChars.isUnique(null));
        assertTrue(exc.getMessage().contains("Null"));

    }

    @Test
    void unique() {
        assertTrue(YK_UniqueChars.isUnique("abcd"));
        assertTrue(YK_UniqueChars.isUnique("abcABC"));//Case insensitive
    }

    @Test
    void notUnique() {
        assertFalse(YK_UniqueChars.isUnique("abca"));//beg end
        assertFalse(YK_UniqueChars.isUnique("aabc"));//following letters
    }

    @Test
    void validRange() {
        String smallLetters =   "abcdefghijklmnopqrstuvxyz";
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String numbers = "1234567890";
        String space = " ";

        assertTrue(YK_UniqueChars.isUnique(smallLetters));
        assertTrue(YK_UniqueChars.isUnique(capitalLetters));
        assertTrue(YK_UniqueChars.isUnique(numbers));
        assertTrue(YK_UniqueChars.isUnique(space));
    }

    private void isInvalidThrown(String str) {
        Exception exc = assertThrows(YK_Exception.class, () -> YK_UniqueChars.isUnique(str));
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
        assertTrue(YK_UniqueChars.isUniqueNoDataStructures(""));

        Exception exc = assertThrows(YK_Exception.class, () -> YK_UniqueChars.isUniqueNoDataStructures(null));
        assertTrue(exc.getMessage().contains("Null"));

    }

    @Test
    void uniqueNoHash() {
        assertTrue(YK_UniqueChars.isUniqueNoDataStructures("abcd"));
        assertTrue(YK_UniqueChars.isUniqueNoDataStructures("abcABC"));//Case insensitive
    }

    @Test
    void notUniqueNoHash() {
        assertFalse(YK_UniqueChars.isUniqueNoDataStructures("abca"));//beg end
        assertFalse(YK_UniqueChars.isUniqueNoDataStructures("aabc"));//following letters
    }

    @Test
    void validRangeNoHash() {
        String smallLetters =   "abcdefghijklmnopqrstuvxyz";
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String numbers = "1234567890";
        String space = " ";

        assertTrue(YK_UniqueChars.isUniqueNoDataStructures(smallLetters));
        assertTrue(YK_UniqueChars.isUniqueNoDataStructures(capitalLetters));
        assertTrue(YK_UniqueChars.isUniqueNoDataStructures(numbers));
        assertTrue(YK_UniqueChars.isUniqueNoDataStructures(space));
    }

    private void isInvalidThrownNoHash(String str) {
        Exception exc = assertThrows(YK_Exception.class, () -> YK_UniqueChars.isUniqueNoDataStructures(str));
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