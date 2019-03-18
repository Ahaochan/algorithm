package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * 题目描述:
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 *
 * 解题思路
 * 用队列进行层序遍历
 */
public class _0637_二叉树的层平均值 {
    @Test
    public void test1() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20); node3.left = node9; node3.right = node20;
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);   node20.left = node15; node20.right = node7;

        List<Double> expect = Arrays.asList(3d, 14.5d, 11d);
        List<Double> actual = averageOfLevels(node3);
        for(int i = 0; i < expect.size(); i++) {
            Assert.assertEquals(expect.get(i), actual.get(i));
        }
    }
    /**
     * 执行用时 : 10 ms, 在Average of Levels in Binary Tree的Java提交中击败了70.50% 的用户
     * 内存消耗 : 47.2 MB, 在Average of Levels in Binary Tree的Java提交中击败了3.37% 的用户
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int last = 1, now = 0;
        int LAST = 1;
        double sum = 0;
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            last--;
            sum += node.val;

            if(node.left != null) {
                queue.add(node.left);
                now++;
            }

            if(node.right != null) {
                queue.add(node.right);
                now++;
            }

            if(last == 0) {
                last = now;
                now = 0;

                result.add(sum / LAST);
                sum = 0;
                LAST = last;
            }
        }
        return result;
    }

    /**
     * 执行用时 : 11 ms, 在Average of Levels in Binary Tree的Java提交中击败了52.83% 的用户
     * 内存消耗 : 49 MB, 在Average of Levels in Binary Tree的Java提交中击败了3.37% 的用户
     * 其他人的题解看起来比较简洁, 但是慢了1ms, 可能是有两个while吧, 但是实际上执行的次数都是一样的
     */
    public List<Double> averageOfLevels_slow(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            int count = queue.size(), COUNT = count;
            double sum = 0;

            while (count-->0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null)  queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(sum / COUNT);
        }
        return result;
    }
}
