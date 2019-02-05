package 剑指offer.代码的完整性;

/**
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 *
 * 解题思路：
 * 这是算法题, 不是考API运用的熟练度
 * 用到快速幂的算法, 比如 2^5, 手算的话, 肯定是先算 2*2, 再算2*2*2, 一直乘4次: 2*2*2*2*2
 * 我们把 2*2*2*2*2 加点空格 2*2 * 2*2 * 2, 就变成了 4 * 4 * 2 了, 这样的话, 只用乘3次
 * 快速幂就是把一部分的幂缓存起来, 直接用, 避免重复运算.
 *
 * 当n为偶数，a^n = a^(n/2) * a^(n/2)
 * 当n为奇数，a^n = a^(n/2) * a^(n/2) * a
 *
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 */
public class 数值的整数次方 {
    public static void main(String[] args) {
        数值的整数次方 main = new 数值的整数次方();
        System.out.println(main.Power(2, -3) == 0.125d);
        System.out.println(main.Power(2, 0) == 1d);
    }

    public double Power(double base, int exponent) {
        int ex = exponent;
        // 1. 负数的预处理
        if(exponent < 0) {
            ex = -ex;
        }

        // 2. 快速幂的缓存, 只计算到 exponent/2 的快速幂, 后面的用不到
        double[] pow = new double[ex + 1]; // +1 避免 exponent=0 创建空数组
        for (int i = 0, len = ex >> 1; i <= len; i++) {

            switch (i) {
                case 0: pow[i] = 1;    break;                         // a^0 = 1
                case 1: pow[i] = base; break;                         // a^1 = a
                default: int half = i>>1;
                    pow[i] = pow[half] * pow[half] * pow[i%2];          // a^n = a^(n/2) * a^(n/2) * a
            }
        }

        int half = ex>>1;
        double result = pow[half] * pow[half] * pow[ex%2];
        // 3. 如果是负数, 则返回倒数
        if(exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }
}
