package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * 题目描述:
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。
 * 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 解题思路
 * 语法题
 */
public class _0541_反转字符串II {
    @Test
    public void test1() {
        Assert.assertEquals("bacdfeg", reverseStr("abcdefg", 2));
        Assert.assertEquals("bacdfeghjiklnm", reverseStr("abcdefghijklmn", 2));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/24221841/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了97.36%的用户
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int idx = 0, len = chars.length; idx < len; idx += (2 * k)) {
            for (int l = idx, r = Math.min(idx + k, len) - 1; l < r; l++,r--) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
            }
        }
        return new String(chars);
    }


    /**
     * https://leetcode-cn.com/submissions/detail/24222061/
     * 执行用时 :3 ms, 在所有 Java 提交中击败了56.08%的用户
     * 内存消耗 :40.7 MB, 在所有 Java 提交中击败了67.92%的用户
     */
    public String reverseStr_complex(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        int idx = 0;
        while (idx < len) {
            if(idx + 2 * k - 1 < len) {
                // 翻转前 k 个字符
                for (int l = idx, r = idx + k - 1; l < r; l++,r--) {
                    char tmp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = tmp;
                }
                idx += (2 * k-1)+1;
            } else if(idx + k- 1 < len){
                // 翻转前 k 个字符
                for (int l = idx, r = idx + k - 1; l < r; l++,r--) {
                    char tmp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = tmp;
                }
                idx += (2 * k-1)+1;
            } else {
                // 全部翻转
                for (int l = idx, r = len-1; l < r; l++,r--) {
                    char tmp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = tmp;
                }
                idx = len;
            }
        }
        return new String(chars);
    }
}
