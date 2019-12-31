package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * 题目描述:
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * 解题思路
 * 位运算即可
 */
public class _1290_二进制链表转整数 {
    @Test
    public void test1() {
        Assert.assertEquals(5, getDecimalValue(ListNode.createLink(1, 0, 1)));
        Assert.assertEquals(0, getDecimalValue(ListNode.createLink(0)));
        Assert.assertEquals(1, getDecimalValue(ListNode.createLink(1)));
        Assert.assertEquals(18880, getDecimalValue(ListNode.createLink(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0)));
        Assert.assertEquals(0, getDecimalValue(ListNode.createLink(0, 0)));

    }

    /**
     * https://leetcode-cn.com/submissions/detail/41812412/
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :34 MB, 在所有 java 提交中击败了100.00%的用户
     */
    public int getDecimalValue(ListNode head) {
        if(head == null) {
            return 0;
        }
        int num = head.val;
        head = head.next;
        while (head != null) {
            num <<= 1;
            num += head.val;
            head = head.next;
        }
        return num;
    }
}
