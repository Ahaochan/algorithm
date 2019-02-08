package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/same-tree/
 * 题目描述:
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 解题思路
 * 递归算法, 遍历左右子树即可.
 *
 * 迭代算法, 利用队列, 每次将镜像位置的两个节点存入队列, 一次取出并比较
 *
 */
public class _0101_对称二叉树 {

    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2); node1.left = node2; node1.right = node3;
        TreeNode node4 = new TreeNode(3); node2.left = node4;
        TreeNode node5 = new TreeNode(4); node2.right = node5;
        TreeNode node6 = new TreeNode(4); node3.left = node6;
        TreeNode node7 = new TreeNode(3); node3.right = node7;
        Assert.assertTrue(isSymmetric(node1));
    }

    @Test
    public void test2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2); node1.left = node2; node1.right = node3;
        TreeNode node4 = new TreeNode(3); node2.right = node4;
        TreeNode node5 = new TreeNode(3); node3.right = node5;
        Assert.assertFalse(isSymmetric(node1));
    }

    @Test
    public void test3() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3); node1.left = node2; node1.right = node3;
        Assert.assertFalse(isSymmetric(node1));
    }

    public boolean isSymmetric(TreeNode root) {
        // 1. 递归算法
//        return root == null || recursive(root.left, root.right);

        // 2. 迭代算法
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while(queue.size() > 0) {
            TreeNode left  = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null) continue;
            else if(left == null || right == null || left.val != right.val) return false;
            queue.add(left.left);  queue.add(right.right);
            queue.add(left.right); queue.add(right.left);
        }
        return true;
    }
    public boolean recursive(TreeNode node1, TreeNode node2) {
        // 1. 如果都是null, 则相等
        if(node1 == null && node2 == null) return true;

        // 2. 如果只有一个是null, 则不等
        if(node1!= null && node2 != null
                // 3. 如果两个节点的值相等, 则继续递归
                && node1.val == node2.val)
            // 4. 递归左子树和右子树
            return recursive(node1.left, node2.right)
                    && recursive(node1.right, node2.left);
        return false;
//        return node1 == null && node2 == null
//                  || node1 != null && node2 != null && node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
}
