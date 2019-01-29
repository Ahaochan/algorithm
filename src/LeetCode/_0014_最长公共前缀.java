package LeetCode;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 题目描述:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 解题思路
 * 前缀, 生成一个二维数组, 然后暴力for循环
 */
public class _0014_最长公共前缀 {
    public static void main(String[] args) {
        _0014_最长公共前缀 main = new _0014_最长公共前缀();
        System.out.println(main.longestCommonPrefix("flower","flow","flight")); // "fl"
        System.out.println(main.longestCommonPrefix("dog","racecar","car")); // ""
        System.out.println(main.longestCommonPrefix("","")); // ""
        System.out.println(main.longestCommonPrefix("c", "c")); // "c"
        System.out.println(main.longestCommonPrefix("abab","aba","")); // ""
        System.out.println(main.longestCommonPrefix("aca","cba")); // "a"
    }

    public String longestCommonPrefix(String... strs) {
        if(strs == null || strs.length <= 0) {
            return "";
        }

        char[] result = strs[0].toCharArray();

        for(int i = 1; i < strs.length; i++) {
            String str = strs[i];
            // 1. 如果有一个空字符串, 则没有公共前缀
            if(str == null || str.length() <= 0) return "";

            // 2. 保证公共前缀小于最短的字符串
            int idx = Math.min(result.length, str.length()) - 1;
            for(int j = idx+1; j < result.length; j++) {
                result[j] = Character.MIN_VALUE;
            }

            // 3. 删除不匹配的字符后的所有字符
            for(int j = 0; j <= idx; j++) {
                if(result[j] != str.charAt(j)) {
                    for(int k = j; k < result.length; k++) {
                        result[k] = Character.MIN_VALUE;
                    }
                    break;
                }
            }
        }
        return new String(result).trim();
    }
}
