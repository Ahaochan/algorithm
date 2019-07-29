package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/string-compression/
 * 题目描述:
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 * 解题思路
 * 用双指针滑动窗口做
 */
public class _0443_压缩字符串 {
    @Test
    public void test1() {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] expect = {'a', '2', 'b', '2', 'c', '3', 'c'};
        Assert.assertEquals(6, compress(chars));
        Assert.assertArrayEquals(expect, chars);
    }

    @Test
    public void test2() {
        char[] chars = {'a'};
        char[] expect = {'a'};
        Assert.assertEquals(1, compress(chars));
        Assert.assertArrayEquals(expect, chars);
    }


    @Test
    public void test3() {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        char[] expect = {'a', 'b', '1', '2', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        Assert.assertEquals(4, compress(chars));
        Assert.assertArrayEquals(expect, chars);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/24232572/
     * 执行用时 :3 ms, 在所有 Java 提交中击败了81.44%的用户
     * 内存消耗 :38.3 MB, 在所有 Java 提交中击败了72.24%的用户
     */
    public int compress(char... chars) {
        int len = chars.length;
        int newIdx = 0;
        for (int i = 0, j = 0; i < len; i = j) {
            // 1. 记录当前字符
            char ch = chars[i];

            // 2. 记录当前字符出现次数
            while (j < len && ch == chars[j]) { j++; }
            int count = j-i;

            // 3. 将字符和出现次数回写到数组
            chars[newIdx++] = ch;
            if(count > 1) {
                for (char a : String.valueOf(count).toCharArray()){
                    chars[newIdx++] = a;
                }
            }
        }
        return newIdx;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/24231488/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了34.33%的用户
     * 内存消耗 :38.7 MB, 在所有 Java 提交中击败了55.92%的用户
     */
    public int compress_slow(char... chars) {
        int newIdx = 0;

        for (int i = 0; i < chars.length;) {
            // 1. 记录当前字符
            char ch = chars[i];

            // 2. 记录当前字符出现次数
            int count = 1;
            for (int j = i+1; j < chars.length && chars[j] == ch; j++, count++) {
            }

            // 3. 将字符和出现次数回写到数组
            chars[newIdx++] = ch;
            if(count > 1) {
                char[] countChars = String.valueOf(count).toCharArray();
                System.arraycopy(countChars, 0, chars, newIdx, countChars.length);
                newIdx += countChars.length;
            }

            // 4. 下一个窗口
            i += count;
        }

        return newIdx;
    }
}
