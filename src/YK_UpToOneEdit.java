/*
    Source: Cracking, page 91, 1.5

    Given 2 strings, return true if they are 0 or 1 letter edit away (replace, remove, insert).
 */

public class YK_UpToOneEdit {
    static public boolean isUpToOneEdit(String s1, String s2) throws YK_Exception {

        if (s1 == null) {
            throw new YK_Exception("S1 Null");
        }

        if (s2 == null) {
            throw new YK_Exception("S2 Null");
        }

        int len1 = s1.length();
        int len2 = s2.length();

        System.out.println("Comparing s1: \"" + s1 + "\" to s2: \"" + s2 + "\"");

        boolean bUpToOneEdit;

        if (len1 == len2){
            System.out.println("Strings are of same size " + len1 + ", comparing if same or with one replace");

            bUpToOneEdit = compareSameLen(s1,s2);
        }
        else if (len1 == (len2 + 1)) {
            System.out.println("s1 is longer by 1 with length " + len1 + ", checking if has 1 insert");

            bUpToOneEdit = compareLenPlusOne(s2, s1);
        }
        else if (len1 == (len2 - 1)) {
            System.out.println("s2 is longer by 1 with length " + len2 + ", checking if has 1 insert");

            bUpToOneEdit = compareLenPlusOne(s1, s2);
        }
        else {
            System.out.println("Strings are not up to 1 edit, Strings lengths differ by more than 1, len1: " + len1 + ", len2: " + len2);
            bUpToOneEdit = false;
        }

        System.out.println("Strings are up to 1 edit: " + bUpToOneEdit);

        return bUpToOneEdit;
    }

    private static boolean compareLenPlusOne(String small, String big) {

        char[] ch_small = small.toCharArray();
        char[] ch_big = big.toCharArray();

        boolean bInsertSeen = false;

        for(int i = 0; i < ch_small.length; i++) {
            if(bInsertSeen) {
                if(ch_small[i] != ch_big[i+1]) {
                    System.out.println("Change seen after insertion in smaller string index " + i + ", small char: " + ch_small[i] + ", big char: " + ch_big[i+1]);
                    return false;
                }
            }
            else {
                if(ch_small[i] != ch_big[i]) {
                    System.out.println("Insertion seen in index " + i + ", small char: " + ch_small[i] + ", big char: " + ch_big[i]);
                    bInsertSeen = true;
                }
            }
        }

        return true;
    }

    private static boolean compareSameLen(String s1, String s2) {
        char[] ch_s1 = s1.toCharArray();
        char[] ch_s2 = s2.toCharArray();

        boolean bReplaceSeen = false;

        for(int i = 0; i < ch_s1.length; i++) {
            if(bReplaceSeen) {
                if(ch_s1[i] != ch_s2[i]) {
                    System.out.println("2nd replace seen in index " + i + ", s1 char: " + ch_s1[i] + ", s2 char: " + ch_s2[i]);
                    return false;
                }
            }
            else {
                if(ch_s1[i] != ch_s2[i]) {
                    System.out.println("Replace seen in index " + i +", s1 char: " + ch_s1[i] + ", s2 char: " + ch_s2[i]);
                    bReplaceSeen = true;
                }
            }
        }

        return true;
    }
}
