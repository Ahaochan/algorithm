package LintCode;

/**
 * https://www.lintcode.com/problem/a-b-problem
 * 1. A + B 问题
 * 描述
 * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 *
 * 你不需要从输入流读入数据，只需要根据aplusb的两个参数a和b，计算他们的和并返回就行。
 *
 * 说明
 * a和b都是 32位 整数么？
 * 是的
 *
 * 我可以使用位运算符么？
 * 当然可以
 *
 * 样例
 * 如果 a=1 并且 b=2，返回3
 *
 * 挑战
 * 显然你可以直接 return a + b，但是你是否可以挑战一下不这样做？
 */
public class _1AB问题 {
    public static void main(String[] args) {
        System.out.println(aplusb(100,-100));
    }
    public static int aplusb(int a, int b) {
//        a       + b         = (a ^ b)  + (a & b << 1)
//        4(0100) + 6(0110)   = 2(0010)  + 4(0100) << 1
//        4(0100) + 6(0110)   = 2(0010)  + 8(1000)
//        2(0010) + 8(1000)   = 10(1010) + 0(0000)
        // 0110 0100
        do {
            int xor=a^b, and=(a&b)<<1;
            a = xor;
            b = and;
        } while(b != 0);
        return a;
    }
}
