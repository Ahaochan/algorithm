package LeetCode;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * 题目描述:
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 解题思路
 * 参考 string.indexOf()
 * 这题要简单就直接调用 string.indexOf(), 要难就各种模式匹配算法
 *
 */
public class _0028_实现strStr {
    public static void main(String[] args) {
        _0028_实现strStr main = new _0028_实现strStr();
        System.out.println(main.strStr("hello", "ll")); // 2
        System.out.println(main.strStr("aaaaa", "bba")); // -1
    }

    /**
     * string.indexOf() 就是暴力破解
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        char first = needle.charAt(0);
        int max = haystack.length() - needle.length();

        for (int i = 0; i <= max; i++) {
            // 1. 找到 haystack 中和 needle 首个字符相等的 每一个字符
            if (haystack.charAt(i) != first) {
                while (++i <= max && haystack.charAt(i) != first);
            }

            // 2. 对比字符串
            if (i <= max) {
                int j = i + 1;
                int end = i + needle.length();
                for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "->" + (next != null ? next.toString() : null);
        }
    }
}
