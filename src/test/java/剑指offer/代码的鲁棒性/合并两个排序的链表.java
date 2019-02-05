package 剑指offer.代码的鲁棒性;

/**
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 *
 * 解题思路：
 * 归并排序的思想
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 合并两个排序的链表 {
    public static void main(String[] args) {
        合并两个排序的链表 main = new 合并两个排序的链表();

        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.next = node3;
        node3.next = node5;

        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node2.next = node4;
        node4.next = node6;

        System.out.println(node1.toString());
        System.out.println(node2.toString());
        ListNode merge = main.Merge(node1, node2);
        System.out.println(merge.toString());

    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1), merge = head;

        // 1. 归并排序
        while(list1 != null && list2 != null) {
            int val1 = list1.val, val2 = list2.val;
            if(val1 > val2) {
                ListNode tail = list2.next;
                merge.next = list2;
                list2 = tail;
            } else {
                ListNode tail = list1.next;
                merge.next = list1;
                list1 = tail;
            }
            merge = merge.next;
        }

        // 2. 剩下的放到链尾
        merge.next = list1 == null ? list2 : list1;
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }
}
