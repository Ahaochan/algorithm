package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 * 题目描述:
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 * 解题思路
 * 遍历所有节点
 * 递归或迭代做
 */
public class _0965_单值二叉树 {
    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1); node1.left = node2;
        TreeNode node3 = new TreeNode(1); node1.right = node3;
        TreeNode node4 = new TreeNode(1); node2.left = node4;
        TreeNode node5 = new TreeNode(1); node2.right = node5;
        TreeNode node6 = new TreeNode(1); node3.right = node6;
        Assert.assertTrue(isUnivalTree(node1));
    }

    @Test
    public void test2() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2); node1.left = node2;
        TreeNode node3 = new TreeNode(2); node1.right = node3;
        TreeNode node4 = new TreeNode(5); node2.left = node4;
        TreeNode node5 = new TreeNode(2); node2.right = node5;
        Assert.assertFalse(isUnivalTree(node1));
    }

    @Test
    public void test3() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1); node1.left = node2;
        Assert.assertTrue(isUnivalTree(node1));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25141852/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了95.51%的用户
     * 内存消耗 :35.3 MB, 在所有 Java 提交中击败了76.64%的用户
     */
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(root.left != null && root.left.val != root.val) {
            return false;
        }
        if(root.right != null && root.right.val != root.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25141128/
     * 执行用时 :2 ms, 在所有 Java 提交中击败了19.94%的用户
     * 内存消耗 :35.4 MB, 在所有 Java 提交中击败了74.21%的用户
     */
    public boolean isUnivalTree_stack(TreeNode root) {
        if(root == null) {
            return true;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int val = root.val;
        while (deque.size() > 0) {
            TreeNode node = deque.pop();
            if(node.val != val) {
                return false;
            }

            if(node.left != null) {
                deque.push(node.left);
            }
            if(node.right != null) {
                deque.push(node.right);
            }
        }
        return true;
    }
}
