package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.ListNode;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * 题目描述:
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 解题思路
 * 快慢指针找到中点, 然后左右子树递归
 */
public class _0109_有序链表转换二叉搜索树 {

    @Test
    public void test() {
        TreeNode node0 = new TreeNode(0);
        TreeNode node_3 = new TreeNode(-3);
        TreeNode node9 = new TreeNode(9);       node0.left = node_3; node0.right = node9;
        TreeNode node_10 = new TreeNode(-10);   node_3.left = node_10;
        TreeNode node5 = new TreeNode(5);       node9.left = node5;

        Assert.assertEquals(node0, sortedListToBST(ListNode.createLink(-10, -3, 0, 5, 9)));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.7 MB, 在所有 Java 提交中击败了83.79%的用户
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }

        // 1. 快慢指针找出中点
        ListNode pre = head, slow = pre.next, fast = slow.next;
        while (fast != null && fast.next != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        // 2. 递归左右子树
        ListNode mid = slow;
        ListNode left = head;
        ListNode right = mid.next;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(left);
        root.right = sortedListToBST(right);
        return root;
    }
}
