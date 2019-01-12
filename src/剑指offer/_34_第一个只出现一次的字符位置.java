package 剑指offer;

import java.util.HashMap;

/**
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * 解题思路：
 * 自己想了半天, 暴力破, 结果人家就是用个 Map 存储每个字符的数量...
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class _34_第一个只出现一次的字符位置 {
    public static void main(String[] args) {
        _34_第一个只出现一次的字符位置 main = new _34_第一个只出现一次的字符位置();
        long start = System.currentTimeMillis();

        System.out.println(main.FirstNotRepeatingChar("google")); // 4

        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start));
    }

    public int FirstNotRepeatingChar(String str) {
        // 1. 存储每个字符的数量
        HashMap<Character, Integer> countMap = new HashMap<>(str.length());
        for(int i = 0, len = str.length(); i < len; i++) {
            char ch = str.charAt(i);
            Integer count = countMap.getOrDefault(ch, 0);
            countMap.put(ch, count+1);
        }

        // 2. for循环找到 第一个只出现一次的字符
        for(int i = 0, len = str.length(); i < len; i++) {
            if(countMap.getOrDefault(str.charAt(i), 0) == 1) {
                return i;
            }
        }
        return -1;
    }
}
