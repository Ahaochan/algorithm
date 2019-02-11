package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * 题目描述:
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 解题思路
 * 递归左右子树, 减去当前节点的值
 */
public class _0112_路径总和 {

    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);  node1.left = node2; node1.right = node3;
        TreeNode node4 = new TreeNode(11); node2.left = node4;
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);  node3.left = node5; node3.right = node6;
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);  node4.left = node7; node4.right = node8;
        TreeNode node9 = new TreeNode(1);  node6.right = node9;

        Assert.assertTrue(hasPathSum(node1, 22));
    }

    @Test
    public void test2() {
        Assert.assertFalse(hasPathSum(null, 0));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return (sum - root.val) == 0;
        }
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }
}
