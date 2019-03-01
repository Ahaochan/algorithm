package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 题目描述:
 * 翻转一棵二叉树。
 *
 * 解题思路
 * 递归解决
 */
public class _0226_翻转二叉树 {

    @Test
    public void test() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7); node4.left = node2; node4.right = node7;
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3); node2.left = node1; node2.right = node3;
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9); node7.left = node6; node7.right = node9;

        TreeNode actual = invertTree(node4);

        Assert.assertEquals(4, actual.val);
        Assert.assertEquals(7, actual.left.val);
        Assert.assertEquals(2, actual.right.val);
        Assert.assertEquals(9, actual.left.left.val);
        Assert.assertEquals(6, actual.left.right.val);
        Assert.assertEquals(3, actual.right.left.val);
        Assert.assertEquals(1, actual.right.right.val);

    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
