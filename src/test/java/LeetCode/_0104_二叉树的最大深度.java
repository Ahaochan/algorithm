package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 题目描述:
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 解题思路
 * 递归算法, 遍历左右子树, Math.max( deep(left), deep(right) ) + 1
 *
 * 迭代算法, 利用队列, 存储每层的节点数, 遍历完毕则层数+1
 *
 */
public class _0104_二叉树的最大深度 {

    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20); node1.left = node2; node1.right = node3;
        TreeNode node4 = new TreeNode(15); node3.left = node4;
        TreeNode node5 = new TreeNode(7); node3.right = node5;
        Assert.assertEquals(3, maxDepth(node1));
    }

    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int deep = 0;

        // 1. 队列, 进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 2. 上一层的节点数 和 当前层的节点数
        int preCount = 1;
        int nowCount = 0;
        while (queue.size() > 0) {
            // 2.1. 弹出节点, 上一层的节点数-1
            TreeNode node = queue.poll();
            preCount--;

            // 2.2. 将左右子节点加入队列
            if(node.left != null) {
                queue.add(node.left);
                nowCount++;
            }
            if(node.right != null) {
                queue.add(node.right);
                nowCount++;
            }

            // 2.3. 上一层遍历完毕, 深度+1
            if(preCount == 0) {
                preCount = nowCount;
                nowCount = 0;
                deep++;
            }
        }
        return deep;
    }
}
