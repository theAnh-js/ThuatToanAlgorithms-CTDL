package StackQueue;

import java.util.Stack;

public class _20_ValidParentheses {

    public static boolean isValid(String s) {

        Stack<Character> myStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                myStack.push(s.charAt(i));
            } else {
                if (myStack.isEmpty()) {
                    return false;
                } else {
                    char myPeek = myStack.peek();
                    if ((myPeek == '(' && s.charAt(i) == ')') ||
                            (myPeek == '[' && s.charAt(i) == ']') ||
                            (myPeek == '{' && s.charAt(i) == '}')) {
                        myStack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return myStack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValid("[](){}"));
        System.out.println(isValid("[(](){}"));
        System.out.println(isValid("[](){}}"));
    }

}
