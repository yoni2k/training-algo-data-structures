package YK_Cracking16_Moderate;

import java.util.Arrays;

/*
Source: Cracking 16.18
Given a pattern, and actual string, with letters 'a' and 'b' in pattern representing some strings in actual string,
return whether actual string matches the pattern.

Two implementations: my initial implementation (works, slightly worse O since looking for all possible b-s, but longer and more complicatedd.
And 2nd improved implementation a merge of mine and book's
 */

public class YK_Mod18_PatternMatch {

    private boolean compArrays(char[] arr, int ind1, int ind2, int lenToCompare) {
        if(( (ind1 + lenToCompare) > arr.length) || ((ind2 + lenToCompare) > arr.length)){
            return false;
        }
        for (int i = 0; i < lenToCompare; i++) {
            if(arr[ind1 + i] != arr[ind2 + i]) {
                return false;
            }
        }
        return true;
    }

    private boolean matchesPattern(char[] pattern, char[] value, int indPattern, int indValue, int aLen, int indBStart, int bLen) {
        if((indPattern == pattern.length) && (indValue == value.length)) {
            return true;
        } else if((indPattern == pattern.length) || (indValue == value.length)) {
            return false;
        }

        if(pattern[indPattern] == 'a') {
            if(compArrays(value, 0, indValue, aLen) == false) {
                return false;
            }
            return matchesPattern(pattern, value, indPattern + 1, indValue + aLen, aLen, indBStart, bLen);
        } else { //b
            if(indBStart != Integer.MIN_VALUE) {
                if(compArrays(value, indBStart, indValue, bLen) == false) {
                    return false;
                }
                return matchesPattern(pattern, value, indPattern + 1, indValue + bLen, aLen, indBStart, bLen);
            } else {
                for(int i = indValue + 1; i <= value.length; i++) {
                    bLen = (i - indValue);
                    if(matchesPattern(pattern, value, indPattern + 1, indValue + bLen, aLen, indValue, bLen)) {
                        return true;
                    }
                }
                return false;
            }
        }
    }


    public boolean matchesPattern(String sPattern, String sValue) {
        char[] pattern = sPattern.toCharArray();
        char[] value = sValue.toCharArray();

        //switch to start with 'a'
        if(pattern[0] == 'b') {
            for(int i = 0 ; i < pattern.length ; i++) {
                pattern[i] = (pattern[i] == 'a') ? 'b' : 'a';
            }
        }

        for(int i = 1 ; i <= value.length ; i++) {
            if(matchesPattern(pattern, value, 1, i, i, Integer.MIN_VALUE, Integer.MIN_VALUE)) {
                return true;
            }
        }
        return false;
    }


    private int countLetter(char[] arr, char toFind) {
        int num = 0;
        for(char let : arr) {
            if ( let == toFind ) {
                num++;
            }
        }
        return num;
    }


    /*************************************************************

    Implementation following reading the book

     *************************************************************/

    private boolean matchesPatternImproved(char[] pattern, char[] value, int aLen, int indBStart, int bLen) {
        int indValue = 0;
        int ind1;
        int sizeToComp;

        System.out.println( "Pattern: " + Arrays.toString(pattern) + ", value: " + Arrays.toString(value) +
                            ", aLen: " + aLen + ", indBStart: " + indBStart + ", bLen: " + bLen);

        for(char patLetter : pattern) {
            if(patLetter == 'a') {
                sizeToComp = aLen;
                ind1 = 0;
            } else { //'b'
                sizeToComp = bLen;
                ind1 = indBStart;
            }
            if(compArrays(value, ind1, indValue, sizeToComp) == false) {
                return false;
            }
            indValue += sizeToComp;
        }
        return true;
    }

    public boolean matchesPatternImprovedBasedOnBook(String sPattern, String sValue) {
        System.out.println("pattern: " + sPattern + ", value: " + sValue);

        char[] pattern = sPattern.toCharArray();
        char[] value = sValue.toCharArray();

        //switch to start with 'a'
        if(pattern[0] == 'b') {
            for(int i = 0 ; i < pattern.length ; i++) {
                pattern[i] = (pattern[i] == 'a') ? 'b' : 'a';
            }
        }

        int numA = countLetter(pattern, 'a');
        int numB = pattern.length - numA;
        int maxSizeA = value.length / numA;
        int sizeForBs;
        int indBStart = 0;
        if(numB > 0) {
            char letToLookFor = (sPattern.charAt(0) == 'a') ? 'b' : 'a';
            indBStart = sPattern.indexOf(letToLookFor);
        }

        for(int i = 1 ; i <= maxSizeA ; i++) {
            sizeForBs = value.length - numA * i;
            if((numB == 0) && (sizeForBs == 0)) {
                if(matchesPatternImproved(pattern, value, i, 0, 0)) {
                    return true;
                }
            } else if((numB != 0) && (sizeForBs != 0) && ((sizeForBs % numB) == 0)) {
                if (matchesPatternImproved(pattern, value, i,i * indBStart, sizeForBs / numB)) {
                    return true;
                }
            }
        }
        return false;
    }
}
