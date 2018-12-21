package 剑指offer.代码的鲁棒性;


/**
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 *
 * 解题思路：
 * 头插法
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 反转链表 {
    public static void main(String[] args) {
        反转链表 main = new 反转链表();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(node1.toString());
        ListNode reverse = main.ReverseList(node1);
        System.out.println(reverse.toString());

    }

    public ListNode ReverseList(ListNode head) {
        ListNode reverse = new ListNode(-1);

        while (head != null) {
            ListNode tail = head.next;
            head.next = reverse.next;
            reverse.next = head;
            head = tail;
        }

        return reverse.next;
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
