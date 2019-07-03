package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/long-pressed-name/
 * 题目描述:
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 * 解题思路
 * 语法题, 有时候需要为了性能, 降低代码可读性, 实际开发这点性能可以忽略不计
 */
public class _0925_长按键入 {
    @Test
    public void test1() {
        Assert.assertTrue(isLongPressedName("alex", "aaleex"));
        Assert.assertFalse(isLongPressedName("saeed", "ssaaedd"));
        Assert.assertTrue(isLongPressedName("leelee", "lleeelee"));
        Assert.assertTrue(isLongPressedName("laiden", "laiden"));
        Assert.assertFalse(isLongPressedName("pyplrz", "ppyypllr"));
        Assert.assertTrue(isLongPressedName("vtkgn", "vttkgnn"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21932150/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :34.8 MB, 在所有 Java 提交中击败了87.43%的用户
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;

        // 1. 判断第一个字符是否相等
        if(name.charAt(i) != typed.charAt(j)) {
            return false;
        }
        i++;j++;

        // 2. 判断后续字符
        int len1 = name.length(), len2 = typed.length();
        while (i < len1 && j < len2) {
            char c1 = name.charAt(i), c2 = typed.charAt(j);

            if(c1 == c2) {
                i++;
                j++;
            } else if(name.charAt(i-1) == c2){
                j++;
            } else {
                return false;
            }
        }

        // 3. 如果还有字符
        if(i == len1) {
            char c1 = name.charAt(len1 - 1);
            while (j < len2) {
                char c2 = typed.charAt(j);
                if(c1 == c2) {
                    j++;
                } else {
                    return false;
                }
            }
        }

        return i == len1 && j == len2;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21931203/
     * 执行用时 :2 ms, 在所有 Java 提交中击败了67.80%的用户
     * 内存消耗 :34.4 MB, 在所有 Java 提交中击败了87.43%的用户
     */
    public boolean isLongPressedName_slow(String name, String typed) {
        int i = 0, j = 0, len1 = name.length(), len2 = typed.length();
        while (j < len2) {
            char c1 = i < len1 ? name.charAt(i) : ' ', c2 = typed.charAt(j);

            if(c1 == c2) {
                i++;
                j++;
            } else if(i > 0 && name.charAt(i-1) == c2){
                j++;
            } else {
                return false;
            }
        }
        return i == len1 && j == len2;
    }
}
