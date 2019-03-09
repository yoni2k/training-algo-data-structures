/* Source: Cracking page 91 1.6

    String compression: compress strings aabcccccaaa -> a2b1c5a3.
    Only if it improves, return compressed.
    Can assume only letters (not numbers for example).
 */

@SuppressWarnings("WeakerAccess")
public class YK_StringCompress {
    static public String compress(String str) {

        if(str.compareTo("") == 0) {
            System.out.println("Received empty string, returning empty string");
            return str;
        }

        StringBuilder sb = new StringBuilder();

        char prevChar = str.charAt(0);
        int numInstances = 1;

        for(char c : str.substring(1).toCharArray()) {
            if (c == prevChar) {
                numInstances++;
            }
            else {
                sb.append(prevChar);
                sb.append(numInstances);

                prevChar = c;
                numInstances = 1;
            }
        }

        sb.append(prevChar);
        sb.append(numInstances);

        String out;

        if(sb.length() < str.length()) {
            System.out.println("Compressed is shorter, returning compressed: \"" + sb.toString() + "\", len: " + sb.length() + ", full: \"" + str + "\", len: " + str.length() );
            out = sb.toString();
        }
        else {
            System.out.println("Compressed is NOT shorter, returning original. Compressed: \"" + sb.toString() + "\", len: " + sb.length() + ", full: \"" + str + "\", len: " + str.length() );
            out = str;
        }

        return out;
    }
}
