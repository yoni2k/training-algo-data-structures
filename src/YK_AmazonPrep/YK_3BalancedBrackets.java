package YK_AmazonPrep;

import java.util.Stack;

/*
Check if brackets are in pairs and balanced. Types of brackets {},[],()
 */

public class YK_3BalancedBrackets {

    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for(char c : arr) {
            if((c == '(') || (c == '{') || (c == '[')) {
                stack.push(c);
            } else {
                if(stack.empty()) {
                    return false;
                }
                if((c == ')') && (stack.pop() != '(')) {
                    return false;
                } else if((c == '}') && (stack.pop() != '{')) {
                    return false;
                } else if((c == ']') && (stack.pop() != '[')) {
                    return false;
                }

            }
        }
        if(stack.empty() == false) {
            return false;
        }

        return true;
    }
}
