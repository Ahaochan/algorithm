package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/student-attendance-record-i/
 * 题目描述:
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * 解题思路
 * 语法题
 */
public class _0551_学生出勤记录I {
    @Test
    public void test1() {
        Assert.assertTrue(checkRecord("PPALLP"));
        Assert.assertFalse(checkRecord("PPALLL"));
        Assert.assertTrue(checkRecord("LALL"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23213340/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.76%的用户
     * 内存消耗 :35.1 MB, 在所有 Java 提交中击败了86.35%的用户
     */
    public boolean checkRecord(String s) {
        int a = 0, l = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            char ch = s.charAt(i);
            if(ch == 'L') l++;
            else l = 0;

            if(ch == 'A') a++;

            if(a > 1 || l > 2) {
                return false;
            }
        }
        return true;
    }
}
