package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 题目描述:
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 解题思路
 * 和104最大深度解法类似
 */
public class _0107_二叉树的层次遍历II {

    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20); node1.left = node2; node1.right = node3;
        TreeNode node4 = new TreeNode(15); node3.left = node4;
        TreeNode node5 = new TreeNode(7); node3.right = node5;

        List<List<Integer>> actual = levelOrderBottom(node1);

        int[][] expect = { {15, 7}, {9, 20}, {3} };
        for (int i = 0; i < expect.length; i++) {
            for (int j = 0; j < expect[i].length; j++) {
                Assert.assertEquals(expect[i][j], actual.get(i).get(j).intValue());
            }
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null ) return  Collections.emptyList();

        // 1. 队列, 进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 2. 上一层的节点数 和 当前层的节点数, 将 root 初始化到结果集
        int preCount = 1;
        LinkedList<List<Integer>> result = new LinkedList<>();
        result.add(Collections.singletonList(root.val));
        List<Integer> row = new ArrayList<>();

        while (queue.size() > 0) {
            // 2.1. 弹出节点, 上一层的节点数-1
            TreeNode node = queue.poll();
            preCount--;

            // 2.2. 将左右子节点加入队列, 值加入 row 当前行
            if(node.left != null) {
                queue.add(node.left);
                row.add(node.left.val);
            }

            if(node.right != null) {
                queue.add(node.right);
                row.add(node.right.val);
            }

            // 2.3. 上一层遍历完毕, 插入 result 结果集
            if(preCount == 0) {
                result.add(0, row);
                preCount = row.size();
                row = new ArrayList<>();
            }
        }
        // 3. 移除第一个元素, 该元素必定为 []
        result.removeFirst();
        return result;

    }
}
