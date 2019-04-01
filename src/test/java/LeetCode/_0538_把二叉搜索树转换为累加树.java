package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 题目描述:
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 解题思路
 * 注意是二叉搜索树, 右中左遍历即可.
 */
public class _0538_把二叉搜索树转换为累加树 {


    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(13); node1.left = node2; node1.right = node3;

        TreeNode actual = convertBST(node1);
        Assert.assertEquals(18, actual.val);
        Assert.assertEquals(20, actual.left.val);
        Assert.assertEquals(13, actual.right.val);
    }

    @Test
    public void test2() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(3); node1.left = node2; node1.right = node3;
        TreeNode node4 = new TreeNode(-4);
        TreeNode node5 = new TreeNode(1); node2.left = node4; node2.right = node5;
        //     2             5
        //   0   3         6   3
        // -4 1           2 6

        TreeNode actual = convertBST(node1);
        Assert.assertEquals(5, actual.val);
        Assert.assertEquals(6, actual.left.val);
        Assert.assertEquals(3, actual.right.val);
        Assert.assertEquals(2, actual.left.left.val);
        Assert.assertEquals(6, actual.left.right.val);
    }

    /**
     * 执行用时 : 2 ms, 在Convert BST to Greater Tree的Java提交中击败了100.00% 的用户
     * 内存消耗 : 46 MB, 在Convert BST to Greater Tree的Java提交中击败了0.00% 的用户
     */
    public TreeNode convertBST(TreeNode root) {
        sum(root);
        return root;
    }

    int add = 0;
    public void sum(TreeNode root) {
        if(root == null) {
            return;
        }
        sum(root.right);
        root.val += add;
        add = root.val;
        sum(root.left);
    }
}
