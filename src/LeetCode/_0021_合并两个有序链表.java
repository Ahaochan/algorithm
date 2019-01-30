package LeetCode;

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
    public static void main(String[] args) {
        _0021_合并两个有序链表 main = new _0021_合并两个有序链表();
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(4);
        node11.next = node12; node12.next = node13;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22; node22.next = node23;

        System.out.println(main.mergeTwoLists(node11, node21)); // 1->1->2->3->4->4
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1. 一个新链表
        ListNode head = new ListNode(-1), node = head;

        // 2. 归并排序
        while(l1 != null && l2 != null){
            if(l1.val < l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }

        // 3. 剩下的接到新链表后面
        if(l1 == null) node.next = l2;
        else node.next = l1;
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "->" + (next != null ? next.toString() : null);
        }
    }
}
