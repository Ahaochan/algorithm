package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 * 题目描述:
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。
 *
 * 这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 *
 */
public class _0013_罗马数字转整数 {

    @Test
    public void test() {
        Assert.assertEquals(500, romanToInt("D"));
        Assert.assertEquals(3, romanToInt("III"));
        Assert.assertEquals(4, romanToInt("IV"));
        Assert.assertEquals(9, romanToInt("IX"));
        Assert.assertEquals(58, romanToInt("LVIII"));     // 58, L = 50, V= 5, III = 3.
        Assert.assertEquals(1994, romanToInt("MCMXCIV")); // 1994, M = 1000, CM = 900, XC = 90, IV = 4.
        Assert.assertEquals(1695, romanToInt("MDCXCV"));  // 1695, M = 1000, D = 500, C = 100, XC = 90, V = 5.
    }



    public int romanToInt(String s) {
        int result = 0;
        // 1. 如果只有一个字符, 则直接返回
        if(s.length() == 1)  return dict(s.charAt(0));

        // 2. 成对处理
        for(int i = 1, len = s.length(); i < len; i++) {
            int pre = dict(s.charAt(i-1));
            int value = dict(s.charAt(i));

            // 2.1. 如果 s[i] >= s[i-1], 则 s[i-1] 可以被加到结果中
            if(pre >= value) {
                result += pre;
            }
            // 2.2. 如果 s[i] < s[i-1], 则 s[i]-s[i-1] 可以被加到结果中
            else {
                result += (value - pre);
                i++;
            }

            // 2.3. 注意末尾的情况
            if(i == len - 1) {
                result += dict(s.charAt(i));
            }
        }
        return result;
    }

    public int dict(char c) {
        int value = 0;
        switch (c) {
            case 'I': value = 1;    break;
            case 'V': value = 5;    break;
            case 'X': value = 10;   break;
            case 'L': value = 50;   break;
            case 'C': value = 100;  break;
            case 'D': value = 500;  break;
            case 'M': value = 1000; break;
        }
        return value;
    }

}
