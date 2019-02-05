package 剑指offer.时间效率;

/**
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * 解题思路：
 * 自己的思路是用动态规划, 空间换时间, 比下面的方法略逊一筹
 *
 * 看了下讨论区, 用博弈思维做
 * 对于一个数A，若是A的左边累计数非负，那么加上A能使得值不小于A，认为累计值对整体和是有贡献的。
 * 如果前几项累计值负数，则认为有害于总和，total记录当前值。
 * 若和大于maxSum 则用maxSum记录下来
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 连续子数组的最大和 {

    public static void main(String[] args) {
        连续子数组的最大和 main = new 连续子数组的最大和();
        long start = System.currentTimeMillis();

        System.out.println(main.FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2}));
        System.out.println(main.FindGreatestSumOfSubArray(new int[]{2,8,1,5,9}));

        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start));
    }

    public int 动态规划(int[] array) {
        if(array == null || array.length <= 0) {
            return 0;
        }

        int[][] sum = new int[array.length][array.length]; // sum[i][j] 表示从 array[i] 到 array[j] 的和
        // 这里可以优化一下空间, 因为实际上只使用了 sum[][] 右上角的部分
        // 6	3	1	8	-7	-6	-4	-2
        // 0	-3	-5	2	-13	-12	-10	-8
        // 0	0	-2	5	-10	-9	-7	-5
        // 0	0	0	7	-8	-7	-5	-3
        // 0	0	0	0	-15	-14	-12	-10
        // 0	0	0	0	0	1	3	5
        // 0	0	0	0	0	0	2	4
        // 0	0	0	0	0	0	0	2


        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            for(int j = i; j < array.length; j++) {
                // 1. 如果子序列只有一个元素, 则填充自己
                if(i == j) {
                    sum[i][j] = array[i];
                }
                // 2. 如果子序列有多个元素
                // 则有公式 sum[i][j] = sum[i][j-1] + array[j] = array[i]到array[j-1]的和 加上 array[j]
                else {
                    sum[i][j] = sum[i][j-1] + array[j];
                }
                // 3. 记录最大值
                if(max < sum[i][j]) {
                    max = sum[i][j];
                }

            }
        }
        return max;
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length <= 0) {
            return 0;
        }

        int total = array[0], max = array[0];
        for(int i = 1; i < array.length; i++) {
            if(total >= 0) {
                total += array[i];
            } else {
                total = array[i];
            }

            if(total > max) {
                max = total;
            }
        }
        return max;
    }
}
