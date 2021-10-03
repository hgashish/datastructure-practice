package com.ahg.stack;

import com.ahg.stack.common.SingleListStack;
import com.ahg.stack.common.Stack;
import com.ahg.stack.common.StackEmptyException;
import com.ahg.stack.common.StackFullException;

/**
 * Discuss how stacks can be used for checking balancing of symbols.
 */
public class MatchingBrackets {

    public static boolean hasMatchingBrackets(String array) throws StackEmptyException {
        if(array == null || array.length() == 0) {
            return true;
        }

        SingleListStack<Character> stack = new SingleListStack<>();
        char[] chars = array.toCharArray();
        for(char c: chars) {
            if (isClosingBracket(c)) {
                if(!isMatchingBracket(stack.top(), c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private static boolean isClosingBracket(char c1) {
        return c1 == '}' || c1 == ')' || c1 == ']';
    }

    private static boolean isMatchingBracket(char openingBracket, char closingBracket) {
        switch (openingBracket) {
            case '{': return closingBracket == '}';
            case '(': return closingBracket == ')';
            case '[': return closingBracket == ']';
        }
        return false;
    }

    public static void main(String[] args) throws StackEmptyException {
        String in = "{()}[()]";
        System.out.println("input=" + in + ", hasMatchingBracket=" + hasMatchingBrackets(in));

        in = "{{()}[()]}";
        System.out.println("input=" + in + ", hasMatchingBracket=" + hasMatchingBrackets(in));

        in = "{{()}[()])}";
        System.out.println("input=" + in + ", hasMatchingBracket=" + hasMatchingBrackets(in));
    }
}
