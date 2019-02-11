package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 题目描述:
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 解题思路
 * 递归找到左右子树的最大深度, 进行比较
 * 要注意 1->2 只有一个根节点一个叶子节点的情况, 深度为1
 */
public class _0111_二叉树的最小深度 {

    @Test
    public void test1() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20); node3.left = node9; node3.right = node20;
        TreeNode node15 = new TreeNode(15); node20.left = node15;
        TreeNode node7 = new TreeNode(7);   node20.right = node7;

        Assert.assertEquals(2, minDepth(node3));
    }

    @Test
    public void test2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2); node1.left = node2;

        // 只有一个根节点和叶子节点的情况
        Assert.assertEquals(2, minDepth(node1));
    }

    public int minDepth(TreeNode root) {
        // 1. 兼容 根节点为 null 的情况
        if(root == null) return 0;

        // 2. 兼容 只有一个根节点和一个叶子节点 的情况
        if(root.left == null) {
            return minDepth(root.right) + 1;
        }
        if(root.right == null) {
            return minDepth(root.left) + 1;
        }

        // 3. 通常情况
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
