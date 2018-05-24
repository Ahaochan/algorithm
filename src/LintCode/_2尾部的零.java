package LintCode;

/**
 * https://www.lintcode.com/problem/trailing-zeros
 * 2. 尾部的零
 * 描述
 * 设计一个算法，计算出n阶乘中尾部零的个数
 * 样例
 * 11! = 39916800，因此应该返回 2
 * 挑战
 * O(logN)的时间复杂度
 */
public class _2尾部的零 {
    public long trailingZeros(long n) {
        int count = 0;
        while (n != 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
