package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reorder-log-files/
 * 题目描述:
 * 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
 * 对于每条日志，其第一个字为字母数字标识符。然后，要么：
 *      标识符后面的每个字将仅由小写字母组成，或；
 *      标识符后面的每个字将仅由数字组成。
 * 我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
 * 将日志重新排序，使得所有字母日志都排在数字日志之前。字母日志按内容字母顺序排序，忽略标识符；在内容相同时，按标识符排序。数字日志应该按原来的顺序排列。
 * 返回日志的最终顺序。
 *
 * 解题思路
 * 考API熟练度
 */
public class _0937_重新排列日志文件 {
    @Test
    public void test1() {
        String[] expect = {"g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};
        Assert.assertArrayEquals(expect, reorderLogFiles("a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"));
    }

    @Test
    public void test2() {
        String[] expect = {"a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};
        Assert.assertArrayEquals(expect, reorderLogFiles("a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20948107/
     * 执行用时 :7 ms, 在所有 Java 提交中击败了90.29%的用户
     * 内存消耗 :42.4 MB, 在所有 Java 提交中击败了72.81%的用户
     */
    public String[] reorderLogFiles(String... logs) {
        // 1. 分离出 纯数字 和 纯字母 字符串
        List<String> numList = new ArrayList<>();
        List<String> letterList = new ArrayList<>();
        for (String log : logs) {
            int spaceIdx = log.indexOf(' ');
            if(Character.isDigit(log.charAt(spaceIdx+1))) {
                numList.add(log);
            } else {
                letterList.add(log);
            }
        }

        // 2. 对纯字母字符串集合进行排序
        letterList.sort((str1, str2) -> {
            int space1Idx = str1.indexOf(' '), space2Idx = str2.indexOf(' ');
            int compareRight = str1.substring(space1Idx+1).compareTo(str2.substring(space2Idx+1));
            if(compareRight != 0) {
                return compareRight;
            } else {
                return str1.substring(0, space1Idx).compareTo(str2.substring(0, space2Idx));
            }
        });

        // 3. 合并字符串集合
        letterList.addAll(numList);
        return letterList.toArray(new String[0]);
    }
}
