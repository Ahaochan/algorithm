package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 题目描述:
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 解题思路
 * 递归找到左右子树的最大深度, 进行比较
 */
public class _0110_平衡二叉树 {

    @Test
    public void test1() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20); node3.left = node9; node3.right = node20;
        TreeNode node15 = new TreeNode(15); node20.left = node15;
        TreeNode node7 = new TreeNode(7);   node20.right = node7;

        Assert.assertTrue(isBalanced(node3));
    }

    @Test
    public void test2() {
        TreeNode node1  = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2); node1.left = node21; node1.right = node22;
        TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(3); node21.left = node31; node21.right = node32;
        TreeNode node41 = new TreeNode(4);
        TreeNode node42 = new TreeNode(5); node31.left = node41; node31.right = node42;

        Assert.assertFalse(isBalanced(node1));
    }

    public boolean isBalanced(TreeNode root) {
        return maxDeep(root) > -1;
    }

    public int maxDeep(TreeNode node) {
        if(node == null) return 0;

        int leftDeep = maxDeep(node.left), rightDeep = maxDeep(node.right);
        if(leftDeep != -1 && rightDeep != -1 && Math.abs(leftDeep-rightDeep) <= 1) {
            return Math.max(leftDeep, rightDeep) + 1;
        }
        return -1;
    }
}
