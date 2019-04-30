package YK_Cracking17_Hard;

import java.util.ArrayList;
import java.util.HashSet;

/*
Source: Cracking 17.13
Given a sentence without spaces and words dictionary, split into words with least unrecognized characters.

Implementation:
- Mine - O(n * longestWordLen).  With a trie could be improved even a bit more.
- Book O(n^2) in a completely different way
Not sure why the book didn't use mine. Is it because I missed something and it doesn't work sometimes?
    Or is it because longestWordLen is O(n) anyways in worst case
 */

public class YK_Hard13_ReSpace {
    enum INFO_TYPE {START, SKIPPED}
    public class Info {
        INFO_TYPE type;
        int numUnrecognized;
        String str;

        Info(INFO_TYPE type, int numUnrecognized, String str) {
            this.type = type;
            this.numUnrecognized = numUnrecognized;
            this.str = str;
        }
    }

    private String[] createWords(String doc, Info[] infos) {

        ArrayList<String> words = new ArrayList<>();
        StringBuilder unr = null;
        for(int i = 0; i < infos.length; i++) {
            if(infos[i].type == INFO_TYPE.SKIPPED) {
                if(unr == null) {
                    unr = new StringBuilder();
                }
                unr.append(doc.charAt(i));
            } else {
                if(unr != null) {
                    words.add(unr.toString());
                    unr = null;
                }
                words.add(infos[i].str);
                i += infos[i].str.length() - 1;
            }
        }

        return words.toArray(new String[0]);
    }

    public String[] unconcatenate(String[] words, String doc) {

        HashSet<String> dic = new HashSet<>();
        int maxWordLen = 0;
        for(String w : words) {
            maxWordLen = Integer.max(maxWordLen, w.length());
            dic.add(w);
        }

        Info[] infos = new Info[doc.length()];

        String word;
        String wordBest = null;
        int numUnrSkipped;
        int numUnrWordStart;
        int numUnrWordStartMin;

        for(int i = doc.length() - 1; i >= 0; i--) {
            numUnrWordStartMin = Integer.MAX_VALUE;
            for(int j = 1; (j <= maxWordLen) && ((i + j) <= doc.length()); j++) { //wordLen
                word = doc.substring(i , i + j);
                if(dic.contains(word)) {
                    numUnrWordStart = ((i + j) < doc.length()) ? (infos[i+j].numUnrecognized) : 0;
                    if(numUnrWordStart < numUnrWordStartMin) {
                        numUnrWordStartMin = numUnrWordStart;
                        wordBest = word;
                    }
                }
            }

            numUnrSkipped = (i+1 < doc.length()) ? (1 + infos[i+1].numUnrecognized) : 1;

            if(numUnrWordStartMin < numUnrSkipped) {
                infos[i] = new Info(INFO_TYPE.START, numUnrWordStartMin, wordBest);
            } else {
                infos[i] = new Info(INFO_TYPE.SKIPPED, numUnrSkipped, null);
            }
        }

        return createWords(doc, infos);
    }
}
