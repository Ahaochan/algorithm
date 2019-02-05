package 剑指offer.时间效率;

/**
 * https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * 解题思路：
 * 下策 暴力破解
 *
 * 找规律, 有公式 a(n) = (10^len + a(n-1)*9), 思路是有, 但是我写了下, 没实现
 * a1 = 1            : 1
 * a2 = (10 +a1)+a1*8: 10-19 21 31 41 51 61 71 81 91
 * a3 = (100+a2)+a2*8: 100-199 201 210-219 ...
 *
 * 网上看了别人代码
 * 看注释
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 整数中1出现的次数 {
    public static void main(String[] args) {
        整数中1出现的次数 main = new 整数中1出现的次数();
        long start = System.currentTimeMillis();

        System.out.println(main.NumberOf1Between1AndN_Solution(10)); // 2
        System.out.println(main.NumberOf1Between1AndN_Solution(13)); // 6
        System.out.println(main.NumberOf1Between1AndN_Solution(20)); // 12
        System.out.println(main.NumberOf1Between1AndN_Solution(55)); // 16

        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int special = 1;

        int count = 0;
        // 30142 = 30000 + 100 + 40 + 2
        for(int i = 1; i <= n; i*=10) {
            // 1. 根据设定的整数位置，对n进行分割，分为两部分，高位n/i，低位n%i
            int high = n / i, low = n % i;
//            count += (high + 8) / 10 * i + (high % 10 == 1 ? low + 1 : 0); // 简化, 8 只适用于 special = 1

            // 2. 当i表示百位，且百位对应的数>=2,如n=31456,i=100，则a=314,b=56，此时百位为1的次数有a/10+1=32（最高两位0~31），每一次都包含100个连续的点，即共有(a/10+1)*100个点的百位为1
            if(high % 10 > special) {
                count += (high / 10 + 1) * i; // 00156 01156 ... 30156 31156
            }
            // 3. 当i表示百位，且百位对应的数为1,如n=31156,i=100，则a=311,b=56，此时百位对应的就是1，则共有a/10(最高两位0-30)次是包含100个连续点，当最高两位为31（即a=311），本次只对应局部点00~56，共b+1次，所有点加起来共有（a/10*100）+(b+1)，这些点百位对应为1
            else if (high % 10 == special) {
                count += (high / 10 ) * i + (low + 1);
            }
            // 4. 当i表示百位，且百位对应的数为0,如n=31056,i=100，则a=310,b=56，此时百位为1的次数有a/10=31（最高两位0~30）
            else if(high % 10 < special) {
                count += (high / 10) * i;
            }
        }

        return count;
    }
}
