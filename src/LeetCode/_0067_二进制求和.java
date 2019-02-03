package LeetCode;

/**
 * https://leetcode-cn.com/problems/plus-one/
 * 题目描述:
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 解题思路
 * 模拟加法运算
 */
public class _0067_二进制求和 {
    public static void main(String[] args) {
        _0067_二进制求和 main = new _0067_二进制求和();
        System.out.println(main.addBinary("10", "1")); // 11
        System.out.println(main.addBinary("1010", "1011")); // 10101
        System.out.println(main.addBinary("11", "11")); // 110
        System.out.println(main.addBinary("11", "1")); // 100
        System.out.println(main.addBinary("0", "0")); // 0
    }

    public String addBinary(String a, String b) {
        // 1. 申请一个存储 和 的数组
        int[] sum = new int[Math.max(a.length(), b.length()) + 1];
        boolean plus = false; // 是否进位的标识

        // 2. 从后往前遍历两个字符串, 做加法
        for (int ai = a.length() - 1, bi = b.length() - 1, k = sum.length - 1; ai >= 0 || bi >= 0; ai--, bi--, k--) {
            int av = ai >= 0 && a.charAt(ai) == '1' ? 1 : 0;
            int bv = bi >= 0 && b.charAt(bi) == '1' ? 1 : 0;

            // 2.1. 异或运算是不进位加法
            sum[k] = av ^ bv;

            // 2.2. 判断是否有进位
            if (plus) {
                // 判断是否需要再进位
                plus = (sum[k] == 1);
                // 不进位加法
                sum[k] ^= 1;
            }
            // 2.3. 判断是否为全1, 全1则进位
            if ((av & bv) == 1) plus = true;
        }
        // 3. 判断最后是否还要进位
        if (plus) sum[0] = 1;

        // 4. 生成字符串
        StringBuilder sb = new StringBuilder(sum.length);
        for (int i = 0, len = sum.length, first = 0; i < len; i++) {
            if (first == 0) first = (sum[i] == 0 ? 0 : 1);
            if (first == 1) sb.append(sum[i]);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
