package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/binary-search/
 * 题目描述:
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 *
 * 解题思路
 * 3、4、7旋转后是一个无效数字, 所以只要包含3、4、7的都不是有效数字, 更不是一个好数
 * 0、1、8旋转后是其本身, 虽然是一个有效数字, 但不是好数
 * 2、5、6、9旋转后变成了另一个数字, 只要包含2、5、6、9, 且是一个有效数字, 就是好数
 *
 * 也就是
 * if( i have (3,4,7)) return false;
 * if( i have (2,5,6,9)) isGood = true;
 */
public class _0788_旋转数字 {

    @Test
    public void test1() {
        Assert.assertEquals(4, rotatedDigits(10));
        Assert.assertEquals(247, rotatedDigits(857));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20873491/
     * 执行用时 :7 ms, 在所有 Java 提交中击败了91.20%的用户
     * 内存消耗 :33.3 MB, 在所有 Java 提交中击败了95.58%的用户
     */
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 0; i <= N; i++) {
            if(isGood(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isGood(int num) {
        int good = 0;
        while (num > 0) {
            int i = num % 10;
            if(i == 3 || i == 4 || i == 7) {
                return false;
            }
            if(i == 2 || i == 5 || i == 6 || i == 9) {
                good++;
            }
            num /= 10;
        }
        return good > 0;
    }
}
