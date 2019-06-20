package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * 题目描述:
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 解题思路
 * 用栈来做, 自己实现的栈 比 用JDK提供的栈 要快得多
 */
public class _1047_删除字符串中的所有相邻重复项 {
    @Test
    public void test1() {
        Assert.assertEquals("ca", removeDuplicates("abbaca"));
    }


    /**
     * https://leetcode-cn.com/submissions/detail/21021606/
     * 执行用时 :8 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :47.6 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public String removeDuplicates(String S) {
        char[] stack = S.toCharArray();

        int top = -1;
        for (char c : stack) {
            if(top > -1 && stack[top] == c) {
                top--;
            } else {
                stack[++top] = c;
            }
        }
        return new String(stack, 0, top + 1);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21020937/
     * 执行用时 :87 ms, 在所有 Java 提交中击败了54.95%的用户
     * 内存消耗 :48.7 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public String removeDuplicates_object(String S) {
        Stack<Character> stack = new Stack<>();

        char[] s = S.toCharArray();
        for (char c : s) {
            if (stack.size() > 0 && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder(stack.size());
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21020529/
     * 执行用时 :92 ms, 在所有 Java 提交中击败了51.58%的用户
     * 内存消耗 :49.5 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public String removeDuplicates_String(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0, len = S.length(); i < len; i++) {
            if(stack.size() > 0 && stack.peek() == S.charAt(i)) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder(stack.size());
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }


}
