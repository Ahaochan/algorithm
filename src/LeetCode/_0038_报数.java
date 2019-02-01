package LeetCode;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 * 题目描述:
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 *
 * 解题思路
 * 第1项1, 1个1, 去掉汉字, 得到第2项11
 * 第2项11, 2个1, 去掉汉字, 得到第3项21
 * 第3项21, 1个2, 1个1, 去掉汉字, 得到第4项1211
 * 语文题
 *
 */
public class _0038_报数 {
    public static void main(String[] args) {
        _0038_报数 main = new _0038_报数();
        System.out.println(main.countAndSay(1)); // 1
        System.out.println(main.countAndSay(2)); // 11
        System.out.println(main.countAndSay(3)); // 21
        System.out.println(main.countAndSay(4)); // 1211
        System.out.println(main.countAndSay(5)); // 111221
    }

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        while (--n>0) {
            StringBuilder newSb = new StringBuilder();
            for(int i = 0; i < sb.length();) {
                char c = sb.charAt(i);
                int count = 0;
                for(;i < sb.length() && c == sb.charAt(i); i++, count++);
                newSb.append(count).append(c);
            }
            sb = newSb;
        }
        return sb.toString();
    }
}
