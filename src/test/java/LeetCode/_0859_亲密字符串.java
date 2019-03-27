package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/buddy-strings/
 * 题目描述:
 * 给定两个由小写字母构成的字符串 A 和 B ，
 * 只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * 解题思路
 * 1. 只有1个字符, 不能交换, return false
 * 2. A和B长度不等, return false
 * 3. A和B内容相等, 且长度大于2, 则判断是否有重复的字母出现, 有则return true
 * 4. A和B内容不等, 且长度大于2, 则找出位置不同的两个字母, 判断逆序是否相等.
 *
 */
public class _0859_亲密字符串 {

    @Test
    public void test1() {
        Assert.assertTrue(buddyStrings("ab", "ba"));
        Assert.assertFalse(buddyStrings("ab", "ab"));
        Assert.assertTrue(buddyStrings("aa", "aa"));
        Assert.assertTrue(buddyStrings("aaaaaaabc", "aaaaaaacb"));
        Assert.assertFalse(buddyStrings("", "aa"));
    }

    /**
     * 执行用时 : 4 ms, 在Buddy Strings的Java提交中击败了80.44% 的用户
     * 内存消耗 : 39.2 MB, 在Buddy Strings的Java提交中击败了0.00% 的用户
     */
    public boolean buddyStrings(String A, String B) {
        int lenA = A.length(), lenB = B.length();
        // 1. A和B长度不等, 或者 只有1个字符, 不能交换
        if(lenA != lenB || lenA < 2) {
            return false;
        }

        // 2. A和B长度相等, 且长度大于2, 则判断是否有重复的字母出现, 有则return true
        if(A.equals(B)) {
            boolean flag = false;
            for(int i = 0; i < lenA && !flag; i++) {
                if(i != A.lastIndexOf(A.charAt(i))) {
                    flag =  true;
                }
            }
            return flag;
        }

        // 3. A和B内容不等, 且长度大于2, 则找出位置不同的两个字母, 判断逆序是否相等.
        int i = -1, j = -1;
        for(int idx = 0; idx < lenA; idx++) {
            boolean ne = A.charAt(idx) != B.charAt(idx);
            if(i < 0 && ne) {
                i = idx;
            } else if(j < 0 && ne) {
                j = idx;
            } else if(ne){
                // 有第三个不同的字母
                return false;
            }
        }
        return A.charAt(i) == B.charAt(j) && A.charAt(j) == B.charAt(i);
    }
}
