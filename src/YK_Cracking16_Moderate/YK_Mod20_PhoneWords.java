package YK_Cracking16_Moderate;

import java.util.ArrayList;
import java.util.HashMap;

/*
Source: Cracking 16.20
Given a dictionary and a number of old phone, give all words that match to the number.

2 implementations:
1. without preprocessing
2. with preprocessing
 */

public class YK_Mod20_PhoneWords {
    public YK_Mod20_PhoneWords() {}

    class Letter{
        Letter[] letters;
        boolean isEndWord;

        Letter(char[] word, int index) {
            letters = new Letter[26];

            if(index == word.length) {
                isEndWord = true;
            } else {
                isEndWord = false;
                letters[getIndex(word[index])] = new Letter(word, index + 1);
            }
        }

        private int getIndex(char letter) {
            return (int)letter - 'a';
        }
    }

    class Dictionary {
        Letter[] letters;

        Dictionary(String[] words) {
            letters = new Letter[26];

            for(String word : words) {
                letters[getIndex(word.charAt(0))] = new Letter(word.toCharArray(), 1);
            }
        }
    }

    private int getIndex(char letter) {
        return (int)letter - 'a';
    }

    private char[] getLetterChars(int num) {
        switch(num) {
            case 2:
                return new char[] {'a','b','c'};
            case 3:
                return new char[] {'d','e','f'};
            case 4:
                return new char[] {'g','h','i'};
            case 5:
                return new char[] {'j','k','l'};
            case 6:
                return new char[] {'m','n','o'};
            case 7:
                return new char[] {'p','q','r','s'};
            case 8:
                return new char[] {'t','u','v'};
            case 9:
                return new char[] {'w','x','y','z'};
            case 0:
            case 1:
            default:
                return new char[0];
        }
    }

    private void getMatchingWords(int[] nums, int indNums, ArrayList<String> strList, StringBuilder sb, Letter letter) {
        if(letter == null) {
            return;
        }

        if (indNums == nums.length) {
            if(letter.isEndWord) {
                strList.add(sb.toString());
            }
        } else {
            for(char ch : getLetterChars(nums[indNums])) {
                sb.append(ch);
                getMatchingWords(nums, indNums + 1, strList, sb, letter.letters[getIndex(ch)]);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public String[] getMatchingWords(String[] words, int[] nums) {
        ArrayList<String> strList = new ArrayList<>();
        Dictionary dic = new Dictionary(words);
        StringBuilder sb;

        for (char ch : getLetterChars(nums[0])) {
            sb = new StringBuilder();
            sb.append(ch);
            getMatchingWords(nums, 1, strList, sb, dic.letters[getIndex(ch)]);
        }
        return strList.toArray(new String[0]);
    }

    /**
     * After reading the book, implementing also a challenge of multiple lookups in O(1)
     */

    private HashMap<String,ArrayList<String>> dic;

    private char getNumFromLetter(char ch) {
        switch(ch) {
            case 'a':
            case 'b':
            case 'c':
                return '2';
            case 'd':
            case 'e':
            case 'f':
                return '3';
            case 'g':
            case 'h':
            case 'i':
                return '4';
            case 'j':
            case 'k':
            case 'l':
                return '5';
            case 'm':
            case 'n':
            case 'o':
                return '6';
            case 'p':
            case 'q':
            case 'r':
            case 's':
                return '7';
            case 't':
            case 'u':
            case 'v':
                return '8';
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                return '9';
        }
        return '0';
    }

    private String convertToNums(String word) {
        StringBuilder sb = new StringBuilder();

        for(char ch : word.toCharArray()) {
            sb.append(getNumFromLetter(ch));
        }
        return sb.toString();
    }

    public YK_Mod20_PhoneWords(String[] words) {
        dic = new HashMap<>();
        String converted;
        ArrayList<String> arrStr;

        for(String word : words) {
            converted = convertToNums(word);
            System.out.println("Putting converted: " + converted);
            if(dic.containsKey(converted)) {
                dic.get(converted).add(word);
            } else {
                arrStr = new ArrayList<>();
                arrStr.add(word);
                dic.put(converted, arrStr);
            }
        }
    }

    public String[] getMatchingWords(String nums) {
        if(dic.containsKey(nums)) {
            return dic.get(nums).toArray(new String[0]);
        } else {
            return new String[0];
        }
    }
}
