package LeetCode;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 题目描述:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 解题思路
 * 简单的入栈出栈操作
 */
public class _0020_有效的括号 {
    public static void main(String[] args) {
        _0020_有效的括号 main = new _0020_有效的括号();
        System.out.println(main.isValid("()")); // true
        System.out.println(main.isValid("()[]{}")); // true
        System.out.println(main.isValid("(]")); // false
        System.out.println(main.isValid("([)]")); // false
        System.out.println(main.isValid("{[]}")); // true

        System.out.println(main.isValid("]")); // false
        System.out.println(main.isValid("[")); // false
    }

    public boolean isValid(String s) {
        // 1. 用栈
        char[] stack = new char[s.length()];
        int top = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                // 1. 入栈
                case '(':
                case '[':
                case '{': stack[top++] = c; break;
                // 2. 出栈
                case ')': if(top <=0 || stack[--top] != '(') return false; break;
                case ']': if(top <=0 || stack[--top] != '[') return false; break;
                case '}': if(top <=0 || stack[--top] != '{') return false; break;
            }
        }
        // 3. 判断栈是否清空
        return top == 0;
    }
}
