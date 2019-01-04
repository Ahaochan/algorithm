package 剑指offer.分解让复杂问题简单;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * 解题思路：
 * 简单的排列组合题, 可以用递归做, 也可以用 next_permutation 做.
 *
 * 递归法: abc
 *                                            abc
 *         a bc(交换a和a)                      b ac(交换a和b)                      c ba(交换a和c)
 * ab c(交换b和b)   ac b(交换b和c)   ba c(交换a和a)   bc a(交换a和c)       cb a(交换b和b)   ca b(交换b和c)
 * 共有6个叶子节点, 所以有6种排列方法, 每次都固定住前 n 个字符, 对后面的字符进行一个个交换位置, 记得交换回来.
 *
 * next_permutation: abc
 * 先看 83286 这个数, 比它大一点的数是 83628, 这个数怎么来的.
 * 首先从后往前扫, 找到一个 a[i]>a[i+1] 的组合, 这里是 83[28]6, i为2
 * 然后从后往前扫, 找到一个大于 a[i] 的数a[j],  这里是 8328[6], j为4
 * 调换位置, 得到 83[6]8[2]
 * 可以看到, 后面的 836[82], 82是一个逆字典序, 所以颠倒一下, 变成 83628.
 * 运用这个方法, 先把输入的字符序列按字典序排序, 然后用 next_permutation 进行输出即可.
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 字符串的排列 {
    public static void main(String[] args) {
        字符串的排列 main = new 字符串的排列();

        long start = System.currentTimeMillis();
        System.out.println(main.Permutation(""));
        System.out.println(main.Permutation("aa"));
        System.out.println(main.Permutation("a"));
        System.out.println(main.Permutation("abc"));
        System.out.println(main.Permutation("abcd"));
        System.out.println(main.Permutation("baa"));
        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start));
    }

    ArrayList<String> result;
    HashSet<String> set;      // 去重Set
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() <= 0) {
            return new ArrayList<>(0);
        }
        set = new HashSet<>(str.length() * str.length());
        char[] chars = str.toCharArray();

//        // 1. 递归方法
//        recursive(chars, 0);

        // 1. 先按 字典序 排序
        Arrays.sort(chars);
        set.add(new String(chars));

        while(true) {
            int start = chars.length - 2;
            // 2. 找到最后一组 a[i]<a[i+1] 的下标i, 找不到则说明没有字典序更大的排序了
            while(start >= 0 && chars[start] >= chars[start+1]) --start;
            if(start < 0) {
                break;
            }

            // 3. 找到 start 后 最后一个大于 chars[start] 的元素
            int min = chars.length - 1;
            while(min > start && chars[min] <= chars[start]) min--;

            // 4. 交换位置
            char tmp1 = chars[min];
            chars[min] = chars[start];
            chars[start] = tmp1;

            // 5. 翻转 start 后的元素
            for(int i = start + 1; i <= (start + chars.length) / 2; i++) {
                char tmp2 = chars[i];
                chars[i] = chars[chars.length + start - i];
                chars[chars.length + start - i] = tmp2;
            }

            set.add(new String(chars));
        }


        // 6. 去重Set 转为 ArrayList 并排序
        result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    public void recursive(char[] chars, int start) {
        // 2. 到末尾, 不能交换了, 则输出字符串
        if(start >= chars.length) {
            set.add(new String(chars));
            return;
        }

        // 1. 对 start 后的所有相邻两个元素进行交换,
        for(int pos = start; pos < chars.length; pos++) {
            if(pos == start || chars[pos] != chars[start]) {
                char tmp = chars[pos];
                chars[pos] = chars[start];
                chars[start] = tmp;

                recursive(chars, start+1);

                tmp = chars[pos];
                chars[pos] = chars[start];
                chars[start] = tmp;
            }
        }
    }
}
