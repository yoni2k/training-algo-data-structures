/* Source: Cracking page 90 1.3

    URLify - every time in String have ' ' replace with "%20".  Do it in place.
    Part of given: have enough room at the end for extra characters.

    Implementation comments: made it work also when have exactly and extra spaces at the end

 */

public class YoniInPlaceSpaceURLReplace {
    static public String URLify(String str, int size) throws YoniException {

        if(size < 0) {
            throw new YoniException("Negative");
        }

        if (str == null) {
            throw new YoniException("Null");
        }

        if(size == 0) {
            return str;
        }

        //Got it from outside as string to make it easier for testing
        char[] org = str.toCharArray();

        if (size > org.length) {
            throw new YoniException("Invalid, size: " + size + ", org.length: " + org.length);
        }

        System.out.println("String: \"" + String.valueOf(org) + "\", size: " + size);

        int to = org.length - 1;
        int from = size - 1;

        while(from >= 0) {
            if (to < from) {
                throw new YoniException("Insufficient room, to: " + to + ", from: " + from + ", array: \"" + String.valueOf(org) + "\"");
            }

            if (org[from] == ' ') {

                to-=2;

                if (to < from) {
                    throw new YoniException("Insufficient room for space, to: " + to + ", from: " + from + ", array: \"" + String.valueOf(org) + "\"");
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
