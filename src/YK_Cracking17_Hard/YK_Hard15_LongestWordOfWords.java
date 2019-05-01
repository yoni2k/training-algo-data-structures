package YK_Cracking17_Hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

/*
Source: Cracking 17.15
Given a list of words, return longest word that contains all the other words

Implementation:
- I implemented with Trie's - pretty complicated, performance-wise, touches every letter in the trie once.
    That's very efficient
- Implementation in the book (and mostly implemented also below) is completely different, it splits all the words in all possible ways, and check if
    themselves are words or can be split.  It's very inefficient, even with memorization.
    However, in the book we sort the array from the longest word (not implemented below but can be easily added), so in average case it will be pretty fast,
    in worst case, all possible length permutations will be tried
 */

public class YK_Hard15_LongestWordOfWords {

    private class YK_Trie {
        boolean isWord = false;
        YK_Trie[] tries = new YK_Trie[26];

        boolean isWord() {
            return isWord;
        }

        YK_Trie getTrie(char c) {
            return tries[c - 'a'];
        }

        private void addWord(String w, int ind) {
            if (ind == w.length()) {
                isWord = true;
                return;
            }
            char c = w.charAt(ind);

            if(tries[c - 'a'] == null) {
                tries[c - 'a'] = new YK_Trie();
            }
            tries[c - 'a'].addWord(w, ind + 1);
        }

        void addWord(String w) {
            addWord(w, 0);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("isWord: ");
            sb.append(isWord);
            sb.append(", tries: ");
            for(int i = 0 ; i <= 'z' - 'a'; i++) {
                if(tries[i] != null) {
                    sb.append((char)('a' + (char)i));
                    sb.append(' ');
                }
            }
            for(int i = 0 ; i <= 'z' - 'a'; i++) {
                if(tries[i] != null) {
                    sb.append('\n');
                    sb.append("  ");
                    sb.append((char)('a' + (char)i));
                    sb.append(": ");
                    sb.append(tries[i].toString());
                }
            }
            return sb.toString();
        }
    }


    private String searchAllShortsLongs(YK_Trie curLong, YK_Trie curShort, YK_Trie head, StringBuilder longStart, String longest) {
        System.out.println("searchAllShortsLongs, longStart: " + longStart.toString() + ", longest: " + longest);
        System.out.println("searchAllShortsLongs curLong:\n" + curLong);
        System.out.println("searchAllShortsLongs curShort:\n" + curShort);
        YK_Trie newCurLong;
        YK_Trie newCurShort;

        for(char c = 'a'; c <= 'z'; c++) {
            newCurLong = curLong.getTrie(c);
            newCurShort = curShort.getTrie(c);

            if((newCurLong != null) && (newCurShort != null)) {
                longStart.append(c);
                longest = searchShortLong(newCurLong, newCurShort, head, longStart, longest);
                longStart.deleteCharAt(longStart.length() - 1);
            }
        }

        return longest;
    }

    private String searchShortLong(YK_Trie curShort, YK_Trie curLong, YK_Trie head, StringBuilder longStart, String longest) {
        System.out.println("searchShortLong, longStart: " + longStart.toString() + ", longest: " + longest);
        System.out.println("searchShortLong curLong:\n" + curLong);
        System.out.println("searchShortLong curShort:\n" + curShort);
        if(         (curShort.isWord())
                &&  (curLong.isWord())
                &&  ((longest == null) || (longStart.length() > longest.length()))) {
                longest = longStart.toString();
        }

        longest = searchAllShortsLongs(curLong, curShort, head, longStart, longest);

        return longest;
    }

    private String getLongest(YK_Trie curNode, YK_Trie head, StringBuilder longStart, String longest) {

        if(curNode.isWord()) {
            longest = searchAllShortsLongs(curNode, head, head, longStart, longest);
        }

        YK_Trie newNode;
        for(char c = 'a'; c <= 'z'; c++) {
            newNode = curNode.getTrie(c);
            if(newNode != null) {
                longStart.append(c);
                longest = getLongest(newNode, head, longStart, longest);
                longStart.deleteCharAt(longStart.length() - 1);
            }
        }

        return longest;
    }

    private YK_Trie createDicTrie(String[] words) {
        YK_Trie head = new YK_Trie();

        for(String w : words) {
            head.addWord(w);
        }

        return head;
    }

    public String getLongestWordOfWords(String[] words) {
        YK_Trie head = createDicTrie(words);
        System.out.println(head);
        return getLongest(head, head, new StringBuilder(), null);
    }

    /**
     * After reading tips in the book
     */

    private boolean canSplit(String w, boolean canUseOrigWord, HashSet<String> dic, Hashtable<String, Boolean> mem) {
        if(canUseOrigWord && (dic.contains(w))) {
            return true;
        }
        if(mem.contains(w)) {
            return mem.get(w);
        }
        boolean ans = false;
        String str1;
        String str2;

        for(int i = 1; i < (w.length() - 1); i++) {
            str1 = w.substring(0,i);
            str2 = w.substring(i);

            if(     (dic.contains(str1) || canSplit(str1, true, dic, mem))
                    &&  (dic.contains(str2) || canSplit(str2, true, dic, mem))) {
                mem.put(w, true);
                ans = true;
            }
        }
        if(ans == false) {
            mem.put(w, false);
        }
        return ans;
    }

    public String getLongestWordOfWordsSplits(String[] words) {
        Hashtable<String, Boolean> mem = new Hashtable<>();
        HashSet<String> dic = new HashSet<>(Arrays.asList(words));
        String longest = null;

        for(String w : words) {
            if(canSplit(w, false, dic, mem)) {
                if((longest == null) || (w.length() > longest.length())) {
                    longest = w;
                }
            }
        }
        return longest;
    }
}
