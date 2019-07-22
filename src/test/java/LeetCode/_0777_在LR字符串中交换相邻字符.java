package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/swap-adjacent-in-lr-string/
 * 题目描述:
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。
 * 一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。
 * 现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 *
 * 解题思路
 */
public class _0777_在LR字符串中交换相邻字符 {
    @Test
    public void test1() {
        Assert.assertFalse(canTransform("X", "L"));
        Assert.assertFalse(canTransform("RXL", "LXR"));
        Assert.assertFalse(canTransform("RLX", "XLR"));
        Assert.assertFalse(canTransform("XXRXXLXXXX", "XXXXRXXLXX"));
        Assert.assertTrue(canTransform("RXXXXXX", "XXXXXXR"));
        Assert.assertTrue(canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23563948/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了98.95%的用户
     * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了93.75%的用户
     */
    public boolean canTransform(String start, String end) {
        int r = 0, l = 0; // 统计 LR 出现的次数
        char[] chars1 = start.toCharArray(), chars2 = end.toCharArray();

        for (int i = 0, len = chars1.length; i < len; i++) {
            // 1. 统计 start 中 L 和 R 出现的次数, 如果字母换了, 则对应状态清零
            if (chars1[i] == 'R') { r++; l = 0; }
            else if (chars1[i] == 'L') { l--; r = 0; }

            // 2. 统计 end 中 L 和 R 出现的次数, 抵消掉 start 中的字母次数
            if (chars2[i] == 'R') { r--; l = 0; }
            else if (chars2[i] == 'L') { l++; r = 0; }

            // 3. 如果抵消过头了, 则失败
            if (l < 0 || r < 0) {
                return false;
            }
        }

        // 4. 刚好抵消完毕, 则成功
        return l == 0 && r == 0;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23560375/
     * 执行用时 :7 ms, 在所有 Java 提交中击败了68.42%的用户
     * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了81.25%的用户
     */
    public boolean canTransform_my(String start, String end) {
        int len1 = start.length(), len2 = end.length();

        int p1 = 0;
        int p2 = 0;
        while (p1 < len1) {

            // 1. 找到从左往右数, 每一个不是 X 的字母
            while (p1 < len1 && start.charAt(p1) == 'X') p1++;
            while (p2 < len2 && end.charAt(p2) == 'X') p2++;

            // 2. 判断是否相同
            char c1 = p1 < len1 ? start.charAt(p1) : '_', c2 = p2 < len2 ? end.charAt(p2) : '_';
            if(c1 != c2) {
                return false;
            }

            // 3. 如果是L, 且不能往左移动, 则false
            if(c1 == 'L' && p1 < p2) {
                return false;
            }
            // 4. 如果是R, 且不能往右移动, 则false
            if(c1 == 'R' && p1 > p2) {
                return false;
            }
            // 5. 继续
            p1++;
            p2++;
        }
        return true;
    }
}
