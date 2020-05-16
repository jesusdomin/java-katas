package com.katas.validbraces;

import java.util.Stack;

/**
 * +Info: https://www.codewars.com/kata/5277c8a221e209d3f6000b56/train/java
 */
public class BraceChecker {

    public boolean isValid(String braces) {
        Stack<Character> bracesStack = new Stack<>();

        for (char brace : braces.toCharArray()) {
            if (isAnOpeningBrace(brace)) {
                bracesStack.push(brace);
                continue;
            }

            if (!isBraceClosedCorrectly(brace, bracesStack)) return false;
        }

        return bracesStack.isEmpty();
    }

    private boolean isAnOpeningBrace(char brace) {
        return brace == '(' || brace == '[' || brace == '{';
    }

    private boolean isBraceClosedCorrectly(char brace, Stack<Character> bracesStack) {
        if (bracesStack.isEmpty()) return false;

        return (brace == ')' && bracesStack.pop() == '(')
                || (brace == ']' && bracesStack.pop() == '[')
                || (brace == '}' && bracesStack.pop() == '{');
    }
}
