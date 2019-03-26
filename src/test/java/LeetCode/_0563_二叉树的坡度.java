package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 * 题目描述:
 * 给定一个二叉树，计算整个树的坡度。
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 解题思路
 * 后序遍历
 *
 */
public class _0563_二叉树的坡度 {
    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3); node1.left = node2; node1.right = node3;
        Assert.assertEquals(1, findTilt(node1));
    }

    @Test
    public void test2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3); node1.left = node2; node1.right = node3;
        TreeNode node4 = new TreeNode(4); node2.left = node4;
        TreeNode node5 = new TreeNode(5); node3.left = node5;
        Assert.assertEquals(11, findTilt(node1));
    }

    /**
     * 执行用时 : 7 ms, 在Binary Tree Tilt的Java提交中击败了72.27% 的用户
     * 内存消耗 : 42.3 MB, 在Binary Tree Tilt的Java提交中击败了1.82% 的用户
     */
    public int tiltSum = 0;

    public int findTilt(TreeNode root) {
        findSubTilt(root);
        return tiltSum;
    }

    public int findSubTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTilt = findSubTilt(root.left);
        int rightTilt = findSubTilt(root.right);
        tiltSum += Math.abs(leftTilt - rightTilt);
        return root.val + leftTilt + rightTilt;
    }
}
