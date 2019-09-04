package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * 题目描述:
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 解题思路
 */
public class _0328_奇偶链表 {
    @Test
    public void test1() {
        Assert.assertNull(oddEvenList(null));
        Assert.assertEquals(ListNode.createLink(1, 3, 5, 2, 4), oddEvenList(ListNode.createLink(1, 2, 3, 4, 5)));
        Assert.assertEquals(ListNode.createLink(1, 3, 5, 7, 2, 4, 6), oddEvenList(ListNode.createLink(1, 2, 3, 4, 5, 6, 7)));
        Assert.assertEquals(ListNode.createLink(1, 3, 5, 7, 2, 4, 6, 8), oddEvenList(ListNode.createLink(1, 2, 3, 4, 5, 6, 7, 8)));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/28476928/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了98.54%的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了33.16%的用户
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode prev = odd.next;

        while (prev != null && prev.next != null) {
            ListNode node = prev.next; // 下一个待处理的奇节点
            ListNode tail = node.next; // 下一个待处理的奇节点的尾巴

            ListNode even = odd.next; // 奇链表最后一个节点必定是偶链表的头结点
            odd.next = node;          // 将奇节点接到奇链表后
            node.next = even;         // 奇节点作为偶链表的头结点
            prev.next = tail;         // 接续奇节点消失后的断层

            odd = odd.next;           // 已处理的奇节点后移一位
            prev = tail;              // 跳过已经处理过的奇节点和偶节点
        }
        return head;
    }
}
