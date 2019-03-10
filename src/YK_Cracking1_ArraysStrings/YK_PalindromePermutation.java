package YK_Cracking1_ArraysStrings;

import java.util.HashMap;
import YK_Common.*;

/* Source: Cracking, page 91, 1.4
    Check if permutation of a string that's given is a palindrome.

    Implementation logic:
        Either pairs only, or only 1 odd letter.
 */

public class YK_PalindromePermutation {

    public static boolean isPermPalindrome(String str) {

        if (str == null) {
            throw new YK_Exception("Null");
        }

        if (str.equals("")) {
            return true;
        }

        HashMap<Character,Integer> hm = new HashMap<>();
        int numInstances;

        for(char c: str.toCharArray()) {
            if(hm.containsKey(c)) {
                numInstances = hm.get(c);
                hm.put(c, numInstances+1);
            }
            else {
                hm.put(c, 1);
            }
        }

        boolean bOddAppeared = false;

        for(int numInstances2 : hm.values()) {
            if ((numInstances2 % 2) != 0) { //odd
                if(bOddAppeared) {
                    return false;
                }
                bOddAppeared = true;
            }
        }

        return true;
    }
}
