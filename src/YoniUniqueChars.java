
/*  Implement an algorithm to determine if a string has all unique characters.
    What if you can't use unique characters?

    Assumptions:
    - Characters set:
        - Initial - "a-zA-z0-1 "
        - More complex: TBD
    - Case sensitive, t!=T

    Source: Cracking, page 90, 1.1
 */

import java.util.HashMap;

public class YoniUniqueChars {

    public static boolean isUnique(String str) throws YoniException{

        if (str == null) {
            throw new YoniException("Null");
        }

        for(char c : str.toCharArray()) {

            if (isValidLetter(c) == false) {
                throw new YoniException("Invalid");
            }
        }

        HashMap<Character,Boolean> ht = new HashMap<>();

        for(char c : str.toCharArray()) {

            if (ht.containsKey(c)) {
                return false;
            }
            else {
                ht.put(c, true);
            }
        }

        return true;
    }

    //Without using hash table
    public static boolean isUniqueNoDataStructures(String str) throws YoniException{

        if (str == null) {
            throw new YoniException("Null");
        }

        for(char c : str.toCharArray()) {

            if (isValidLetter(c) == false) {
                throw new YoniException("Invalid");
            }
        }

        int index;
        boolean [] digits = new boolean['9' - '0' + 1];
        boolean [] smallLetters = new boolean['z' - 'a' + 1];
        boolean [] capitalLetters = new boolean['Z' - 'A' + 1];
        boolean bSpaceAppeared = false;

        for(char c : str.toCharArray()) {

            if(isDigit(c)) {
                index = (c - '0');
                if(digits[index]) {
                    return false;
                }
                digits[index] = true;
            }
            else if(isSmallLetter(c)) {
                index = (c - 'a');
                if(smallLetters[index]) {
                    return false;
                }
                smallLetters[index] = true;
            }
            else if(isCapitalLetter(c)) {
                index = (c - 'A');
                if(capitalLetters[index]) {
                    return false;
                }
                capitalLetters[index] = true;
            }
            else { //space
                if(bSpaceAppeared) {
                    return false;
                }
                bSpaceAppeared = true;
            }
        }

        return true;
    }

    static private boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    static private boolean isSmallLetter(char c) {
        return (c >= 'a' && c <= 'z');
    }

    static private boolean isCapitalLetter (char c) {
        return (c >= 'A' && c <= 'Z');
    }

    static private boolean isSpace (char c) {
        return (c == ' ');
    }

    static private boolean isValidLetter(char c) {
        return isDigit(c) || isSmallLetter(c) || isCapitalLetter(c) || isSpace(c);
    }
}
