package 剑指offer.时间效率;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 解题思路：
 * 排序, 有字符串a和b
 * 若ab > ba 则 a > b, 那么两字符串最小值为 ba
 * 若ab < ba 则 a < b, 那么两字符串最小值为 ab
 * 若ab = ba 则 a = b; 那么两字符串最小值为 ab 或 ba
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 把数组排成最小的数 {
    public static void main(String[] args) {
        把数组排成最小的数 main = new 把数组排成最小的数();
        long start = System.currentTimeMillis();

        System.out.println(main.PrintMinNumber(new int[]{3,32,321}));

        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start));
    }

    public String PrintMinNumber(int [] numbers) {
        // 1. 转为 String[]
        String[] strs = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        // 2. 比较排序
        Arrays.sort(strs, (pre, next) -> (pre + next).compareTo(next + pre));
        // 3. join 字符串
        return Arrays.stream(strs).collect(Collectors.joining(""));
    }
}
