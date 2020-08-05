package com.zw.algorithms.test1;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 */
public class Test6 {
    public static void main(String[] args) {
        String s = "(]";
        System.out.println("isValid: " + isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        if (s.isEmpty()) return true;
        if (s.length() % 2 != 0) return false;

        char[] chs = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chs.length; i++) {
            char ch0 = chs[i];

            if (stack.isEmpty()) {
                stack.push(ch0);
                continue;
            }

            Character ch = stack.pop();

            if (ch == null) {
                stack.push(ch0);
                continue;
            }

            if (ch0 + ch == '(' + ')' || ch0 + ch == '[' + ']' || ch0 + ch == '{' + '}') {

            } else {
                stack.push(ch);
                stack.push(ch0);
            }
        }


        return stack.isEmpty();
    }
}
