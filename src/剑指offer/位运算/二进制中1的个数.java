package 剑指offer.位运算;

/**
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 *
 * 解题思路：
 * 题目提示用位运算. Java存储的都是补码
 * 自己的思路
 * 用 1 去与每一位的数字, 然后统计不为 0 的有多少个, 比如
 * 0101     0101    0101    0101
 * 1       10     100    1000     用 <<1 进行左移位
 * 0001     0000    0100    0000
 * 不为0的有2个, 所以0101的1有2个
 * 但是这有个缺点, 如果有很多个0, 比如10000000, 那么就要判断很多次
 *
 * n & (n-1)的办法
 * n      101000
 * n-1      100111
 * n&(n-1)  100000
 * n&(n-1) 将 n 最右边的 1 变为0, 只要一直 & 下去, 直到所有 1 变为0, 计算完毕, 循环多少次就有多少个1
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 */
public class 二进制中1的个数 {
    public static void main(String[] args) {
        二进制中1的个数 main = new 二进制中1的个数();

        for (int i = -10; i < 10; i++) {
            System.out.println(Integer.toBinaryString(i) + ":" + main.NumberOf1(i));
        }
    }

    public int NumberOf1(int n) {
        int pow = 1, num = 0;
//        while (pow != 0) {
//            if ((pow & n) != 0) {
//                num++;
//            }
//            pow <<= 1;
//        }
        while (n != 0) {
            num++;
            n = n & (n - 1);
        }
        return num;
    }
}
