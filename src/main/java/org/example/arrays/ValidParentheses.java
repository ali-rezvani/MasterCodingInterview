package org.example.arrays;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*

Given a string s containing just the characters '(', ')', '{', '}', '[', and ']',
 determine if the input string is valid.

The string is valid if:

Open brackets must be closed by the same type of brackets.

Open brackets must be closed in the correct order.

Every closing bracket has a corresponding opening bracket of the same type.

*/

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(()[]{})[][]";
        brutalValidate(s);
        System.out.println(optimizedValidate(s));
    }

    private static void brutalValidate(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            try {

                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    stack.push(s.charAt(i));
                } else if (map.get(s.charAt(i)) != stack.pop()) {
                    System.out.println(s + " is not a valid parentheses");
                    return;
                }
            } catch (EmptyStackException e) {
                System.out.println(s + " is not a valid parentheses");
                return;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(s + " is not a valid parentheses");
        } else {
            System.out.println(s + " is a valid parentheses");
        }

    }

    public static boolean optimizedValidate(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
