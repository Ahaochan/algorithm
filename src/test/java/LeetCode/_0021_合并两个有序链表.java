package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 题目描述:
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 解题思路
 * 归并排序
 */
public class _0021_合并两个有序链表 {
    @Test
    public void test() {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(4);
        node11.next = node12; node12.next = node13;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22; node22.next = node23;

        ListNode result = mergeTwoLists(node11, node21);
        int[] expect = {1,1,2,3,4,4};
        for(int i = 0; i < expect.length; i++, result = result.next) {
            Assert.assertEquals(expect[i], result.val);
        }
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. 一个新链表
        ListNode dummy = new ListNode(-1), node = dummy;

        // 2. 归并排序
        while(list1 != null && list2 != null){
            if(list1.val < list2.val) {
                node.next = list1;
                node = node.next;
                list1 = list1.next;
            } else {
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            }
        }

        // 3. 剩下的接到新链表后面
        if(list1 == null) node.next = list2;
        else node.next = list1;
        return dummy.next;
    }
}
