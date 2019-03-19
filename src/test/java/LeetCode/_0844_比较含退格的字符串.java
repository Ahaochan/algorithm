package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 * 题目描述:
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 
 * 解题思路
 * 用栈, 模拟退格
 * 后来发现, StringBuilder操作比较高效
 */
public class _0844_比较含退格的字符串 {
    @Test
    public void test1() {
        Assert.assertTrue(backspaceCompare("ab#c", "ad#c"));
        Assert.assertTrue(backspaceCompare("ab##", "c#d#"));
        Assert.assertTrue(backspaceCompare("a##c", "#a#c"));
        Assert.assertFalse(backspaceCompare("a#c", "b"));
    }

    /**
     * 执行用时 : 12 ms, 在Backspace String Compare的Java提交中击败了56.64% 的用户
     * 内存消耗 : 36.9 MB, 在Backspace String Compare的Java提交中击败了0.79% 的用户
     */
    public boolean backspaceCompare_stack(String S, String T) {
        // 1. S 存栈
        Stack<Character> stackS = new Stack<>();
        for(int i = 0, len = S.length(); i < len; i++) {
            char ch = S.charAt(i);
            if(ch != '#') stackS.push(ch);
            else if(stackS.size() > 0) stackS.pop();
        }
        // 2. T 存栈
        Stack<Character> stackT = new Stack<>();
        for(int i = 0, len = T.length(); i < len; i++) {
            char ch = T.charAt(i);
            if(ch != '#') stackT.push(ch);
            else if(stackT.size() > 0) stackT.pop();
        }

        // 3. 比较两个栈
        if(stackS.size() != stackT.size()) {
            return false;
        }
        while (stackS.size() > 0) {
            if(stackS.pop() != stackT.pop()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 执行用时 : 7 ms, 在Backspace String Compare的Java提交中击败了94.31% 的用户
     * 内存消耗 : 37 MB, 在Backspace String Compare的Java提交中击败了0.79% 的用户
     */
    public boolean backspaceCompare(String S, String T) {
        // 1. S 存字符串
        StringBuilder s = new StringBuilder(S.length());
        for(int i = 0, len = S.length(); i < len; i++) {
            char ch = S.charAt(i);
            if(ch != '#') s.append(ch);
            else if(s.length() > 0) s.deleteCharAt(s.length() - 1);
        }
        // 2. T 存字符串
        StringBuilder t = new StringBuilder(T.length());
        for(int i = 0, len = T.length(); i < len; i++) {
            char ch = T.charAt(i);
            if(ch != '#') t.append(ch);
            else if(t.length() > 0) t.deleteCharAt(t.length() - 1);
        }

        // 3. 比较两个字符串
        int len = s.length();
        if(len != t.length()) {
            return false;
        }
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
