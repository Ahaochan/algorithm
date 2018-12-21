package 剑指offer.代码的鲁棒性;

/**
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 *
 * 解题思路：
 * 先用一个指针, 指向头节点后第k个节点
 * 1 2 3 4 5
 * ^   ^
 * 然后同步往后移动, 直到第k个节点为null
 * 1 2 3 4 5
 *       ^   ^
 * 那么倒数第k个节点, 就是第一个指针指向的位置
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        // 1. 获取第k个节点
        ListNode afterK = head;
        for(int i = 0; i < k; i++) {
            if(afterK == null) {
                return null;
            }
            afterK = afterK.next;
        }

        // 2. 头结点和第k个节点同时往后移动
        while(afterK != null) {
            head = head.next;
            afterK = afterK.next;
        }

        // 3. 到链表尾后, head 就是倒数第k个节点
        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
