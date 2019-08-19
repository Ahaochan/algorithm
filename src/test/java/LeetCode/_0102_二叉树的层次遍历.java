package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 题目描述:
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 解题思路
 */
public class _0102_二叉树的层次遍历 {
    @Test
    public void test1() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);   node3.left = node9;
        TreeNode node20 = new TreeNode(20); node3.right = node20;
        TreeNode node15 = new TreeNode(15); node20.left = node15;
        TreeNode node7 = new TreeNode(7);   node20.right = node7;

        Assert.assertEquals(Arrays.asList(Arrays.asList(3), Arrays.asList(9,20), Arrays.asList(15, 7)), levelOrder(node3));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/26425890/
     * 执行用时 :2 ms, 在所有 Java 提交中击败了91.38%的用户
     * 内存消耗 :37.4 MB, 在所有 Java 提交中击败了33.43%的用户
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }

        // 1. 使用队列存储节点
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int pre = 1, now = 0; // 标记上一层的节点数和本层的节点数

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        while (pre > 0) {
            // 2. 统计本层节点的数量
            TreeNode node = queue.poll();
            pre--;
            level.add(node.val);

            if(node.left != null) {
                now++;
                queue.add(node.left);

            }

            if(node.right != null) {
                now++;
                queue.add(node.right);
            }

            // 3. 当上层节点消耗完毕, 进入下一层
            if(pre == 0) {
                pre = now;
                now = 0;
                result.add(level);
                level = new ArrayList<>();
            }
        }

        return result;
    }
}
