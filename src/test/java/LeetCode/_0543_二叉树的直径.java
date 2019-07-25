package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 题目描述:
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 解题思路
 * 直径其实就是求左子树和右子树深度之和, 但是这个最大直径不一定是过 root 点的, 有可能在左子树内, 也有可能在右子树内.
 */
public class _0543_二叉树的直径 {
    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2); node1.left = node2;
        TreeNode node3 = new TreeNode(3); node1.right = node3;
        TreeNode node4 = new TreeNode(4); node2.left = node4;
        TreeNode node5 = new TreeNode(5); node2.right = node5;

        Assert.assertEquals(3, diameterOfBinaryTree(node1));
    }


    /**
     * https://leetcode-cn.com/submissions/detail/23863835/
     * 执行用时 :2 ms, 在所有 Java 提交中击败了82.12%的用户
     * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了74.79%的用户
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    int max;
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
