package YK_Cracking17_Hard;

/*
Source: Cracking 17.17
Given a long word, and a long array of short words, find which of the short words appear in the long word.
    (I understood the problem to be just to say yes or no,
    in the solution in the book locations of each word are also returned.
    This is slightly more complicated, but with some changes can be done below)

Implementations:
1. Mine - Trie of the long word with maximum length of longest short word
2. In the book in addition to solution like mine above, there is the opposite direction
    of putting the short words in a trie, and then going over the long word.   It says in the book
    that it's more efficient.  However, that's not true considering the following note.
3. In my implementation, I put in the trie only up the the length of the longest short word, that's why
    it's more efficient than the version in the book, therefore same efficiency of Lb*LMS (but slightly less complex) than
    the alternative solution with putting the short words in the trie.

 */

public class YK_Hard17_WordsInString {
    private class YK_Trie {
        YK_Trie[] tries = new YK_Trie[26];

        void insert(char[] arr, int start, int len) {
            if(len == 0) {
                return;
            }
            char c = arr[start];
            if(tries[c - 'a'] == null) {
                tries[c - 'a'] = new YK_Trie();
            }
            tries[c - 'a'].insert(arr, start + 1, len - 1);
        }

        private boolean contains(char[] arr, int index) {
            if(index == arr.length) {
                return true;
            }

            char c = arr[index];
            if (tries[c - 'a'] == null) {
                return false;
            } else {
                return tries[c - 'a'].contains(arr, index + 1);
            }

        }

        boolean contains(String s) {
            return contains(s.toCharArray(), 0);
        }
    }

    private int getMaxShortLen(String[] shorts) {
        int max = 0;

        for(String str : shorts) {
            max = Integer.max(max, str.length());
        }
        return max;
    }

    public boolean[] subStringsInLarge(String str, String[] shorts) {
        int maxShortLen = getMaxShortLen(shorts);
        char[] longArr = str.toCharArray();
        YK_Trie head = new YK_Trie();
        int maxLenInsert;

        for(int i = 0 ; i < longArr.length; i++) {
            maxLenInsert = ((i + maxShortLen) > longArr.length) ? (longArr.length - i) : maxShortLen;
            head.insert(longArr, i, maxLenInsert);
        }

        boolean[] ans = new boolean[longArr.length];

        for(int i = 0; i < longArr.length; i++) {
            ans[i] = head.contains(shorts[i]);
        }

        return ans;
    }
}
