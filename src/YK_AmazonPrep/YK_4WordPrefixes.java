package YK_AmazonPrep;

import java.util.ArrayList;

/*
Given 2 commands "add" to dictionary and "find", find how many prefixes exist for the find prefix command in the dictionary
 */

public class YK_4WordPrefixes {
    final private int YK_NUM_LETTERS = 26;
    private MyNode[] nodes = new MyNode[YK_NUM_LETTERS];

    private int ind(char c) {
        return (c - 'a');
    }

    private char indToChar(int index) {
        return (char)('a' + index);
    }

    private class MyNode {
        int numPref = 0;
        MyNode[] nodes = new MyNode[YK_NUM_LETTERS];
        boolean endOfWord = false;

        void add(char[] word, int wordIndex) {
            numPref++;
            if(word.length == wordIndex) {
                endOfWord = true;
            } else {
                int nodeInd = ind(word[wordIndex]);
                if(nodes[nodeInd] == null) {
                    nodes[nodeInd] = new MyNode();
                }
                nodes[nodeInd].add(word, wordIndex + 1);
            }
        }

        int getNumPref(char[] word, int wordIndex) {
            if(word.length == wordIndex) {
                return numPref;
            } else {
                int nodeIndex = ind(word[wordIndex]);
                if(nodes[nodeIndex] == null) {
                    return 0;
                }
                return nodes[nodeIndex].getNumPref(word, wordIndex + 1);
            }
        }

        void getAllWords(StringBuilder sb, ArrayList<String> arr) {
            if(endOfWord) {
                arr.add(sb.toString());
            }
            int indexAddedChar;
            for(int i = 0; i < YK_NUM_LETTERS; i++) {
                if(nodes[i] != null) {
                    indexAddedChar = sb.length();
                    sb.append(indToChar(i));
                    nodes[i].getAllWords(sb, arr);
                    sb.deleteCharAt(indexAddedChar);
                }
            }
        }

        String[] getWordsWithPref(char[] word, int wordIndex) {
            if(word.length == wordIndex) {
                ArrayList<String> arrStr = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                sb.append(word);
                getAllWords(sb,arrStr);
                String[] res = new String[arrStr.size()];
                for(int i = 0; i < arrStr.size(); i++) {
                    res[i] = arrStr.get(i);
                }
                return res;
            } else {
                int nodeIndex = ind(word[wordIndex]);
                if(nodes[nodeIndex] == null) {
                    return new String[0];
                }
                return nodes[nodeIndex].getWordsWithPref(word, wordIndex + 1);
            }
        }
    }

    public void add(String s) {
        char[] arr = s.toCharArray();
        int index = ind(arr[0]);
        if(nodes[index] == null) {
            nodes[index] = new MyNode();
        }
        nodes[index].add(arr, 1);
    }

    public int getNumPref(String s) {
        char[] arr = s.toCharArray();
        int index = ind(arr[0]);
        if(nodes[index] == null) {
            return 0;
        }
        return nodes[index].getNumPref(arr, 1);
    }

    public String[] getWordsWithPref(String s) {
        char[] arr = s.toCharArray();
        int index = ind(arr[0]);
        if(nodes[index] == null) {
            return new String[0];
        }
        return nodes[index].getWordsWithPref(arr, 1);
    }
}
