package YK_Cracking1_ArraysStrings;

import YK_Common.*;

/* Source: Cracking page 90 1.3

    URLify - every time in String have ' ' replace with "%20".  Do it in place.
    Part of given: have enough room at the end for extra characters.

    Implementation comments: made it work also when have exactly and extra spaces at the end

 */

public class YK_InPlaceSpaceURLReplace {
    static public String URLify(String str, int size) throws YK_Exception {

        if(size < 0) {
            throw new YK_Exception("Negative");
        }

        if (str == null) {
            throw new YK_Exception("Null");
        }

        if(size == 0) {
            return str;
        }

        //Got it from outside as string to make it easier for testing
        char[] org = str.toCharArray();

        if (size > org.length) {
            throw new YK_Exception("Invalid, size: " + size + ", org.length: " + org.length);
        }

        System.out.println("String: \"" + String.valueOf(org) + "\", size: " + size);

        int to = org.length - 1;
        int from = size - 1;

        while(from >= 0) {
            if (org[from] == ' ') {
                to-=2;

                if (to < from) {
                    throw new YK_Exception("Insufficient room for space, to: " + to + ", from: " + from + ", array: \"" + String.valueOf(org) + "\"");
                }

                System.out.println("Replacing space with \"%20\" from: " + from + ", to: " + to);

                org[to] = '%';
                org[to + 1] = '2';
                org[to + 2] = '0';

            }
            else {
                System.out.println("Moving '" + org[to] + "' from: " + from + ", to: " + to);
                org[to] = org[from];
            }

            to--;
            from--;
        }

        System.out.println("String after replace, before move the the front: \"" + String.valueOf(org) + "\"");

        int placesToMoveForward = (to + 1);

        //noinspection ManualArrayCopy
        for(int i = 0; i < (org.length - placesToMoveForward); i++) {
            org[i] = org[i+placesToMoveForward];
        }

        for(int i = (org.length - placesToMoveForward); i < org.length; i++) {
            org[i] = ' ';
        }

        System.out.println("Final string: \"" + String.valueOf(org) + "\"");

        return String.valueOf(org);//returning to make it easier for tests
    }
}
