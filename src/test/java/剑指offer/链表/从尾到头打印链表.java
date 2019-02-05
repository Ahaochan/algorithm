package 剑指offer.链表;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * 解题思路：
 * 将链表转为数组, 然后头尾对调
 *
 * 看了网上的解法, 比较逼格的一种解法
 * 利用链表头插法, 可以逆序生成链表
 * 比如 1->2->3
 * 先创建一个空的头结点   null
 * 把1接到头结点后面, null->1
 * 把2接到头节点后面, null->2->1
 * 把3接到头节点后面, null->3->2->1
 * 逆序成功
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 */
public class 从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 1. 构造头节点, 头插法生成逆序链表
        ListNode reverse = new ListNode(-1);
        while(listNode != null) {
            ListNode node = listNode.next;
            listNode.next = reverse.next;
            reverse.next = listNode;
            listNode = node;
        }
        reverse = reverse.next;

        // 2. 转为 ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        while(reverse != null) {
            result.add(reverse.val);
            reverse = reverse.next;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val+"->"+String.valueOf(next);
        }
    }
}
