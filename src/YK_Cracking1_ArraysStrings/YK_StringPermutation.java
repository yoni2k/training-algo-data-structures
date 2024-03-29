package YK_Cracking1_ArraysStrings;

/* Source: Cracking, page 90, question 1.2
    Given 2 strings, write a method to decide if one is a permutation of another

    Understanding details:
    - Permutation - same length

    Implementation details:
    - Null considered invalid string and throws YK_Exception
    - Case sensitive
    -
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import YK_Common.*;

public class YK_StringPermutation {

    static public boolean isPerm(String s1, String s2) throws YK_Exception {
        if (s1 == null) {
            throw new YK_Exception("s1 Null");
        }

        if (s2 == null) {
            throw new YK_Exception("s2 Null");
        }

        if (s1.length() != s2.length()) {
            System.out.println("Lengths differ, len1: " + s1.length() + ", len2: " + s2.length());
            return false;
        }

        Integer instances;
        HashMap<Character,Integer> hm_s1 = new HashMap<>();

        for(char c: s1.toCharArray()) {
            if (hm_s1.containsKey(c)) {
                instances = hm_s1.get(c);
                hm_s1.put(c, instances + 1);
            }
            else {
                hm_s1.put(c, 1);
            }
        }

        HashMap<Character,Integer> hm_s2 = new HashMap<>();

        for(char c: s2.toCharArray()) {
            if (hm_s2.containsKey(c)) {
                instances = hm_s2.get(c);
                hm_s2.put(c, instances + 1);
            }
            else {
                hm_s2.put(c, 1);
            }
        }

        if (hm_s1.size() != hm_s2.size()) {
            System.out.println("The sizes of hash tables don't match: s1: " + hm_s1.size() + ", s2: " + hm_s2.size());
            return false;
        }

        System.out.println("S1 HashMap: " + hm_s1.toString());
        System.out.println("S2 HashMap: " + hm_s2.toString());
        Integer val2;

        Set<Map.Entry<Character,Integer>> set1 = hm_s1.entrySet();

        for(Map.Entry <Character,Integer> entry1 : set1)
        {
            if(!hm_s2.containsKey(entry1.getKey()))
            {
                System.out.println("Following key doesn't exist, key1: " + entry1.getKey());
                return false;
            }

            val2 = hm_s2.get(entry1.getKey());

            if(entry1.getValue().intValue() != val2.intValue())
            {
                System.out.println("Following key doesn't equal, key: " + entry1.getKey() + ", value1: " + entry1.getValue() + ", value2: " + val2);
                return false;
            }
        }

        System.out.println("All members are equal");
        return true;
    }
}
