package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 题目描述:
 * 计算给定二叉树的所有左叶子之和。
 * 示例：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 解题思路
 * 先序遍历即可
 */
public class _0404_左叶子之和 {
    @Test
    public void test1() {
        TreeNode node3  = new TreeNode(3 );
        TreeNode node9  = new TreeNode(9 ); node3.left   = node9;
        TreeNode node20 = new TreeNode(20); node3.right  = node20;
        TreeNode node15 = new TreeNode(15); node20.left  = node15;
        TreeNode node7  = new TreeNode(7 ); node20.right = node7;
        Assert.assertEquals(24, sumOfLeftLeaves(node3));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23212087/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.26%的用户
     * 内存消耗 :35.5 MB, 在所有 Java 提交中击败了79.59%的用户
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int count = 0;

        if(root.left != null && root.left.left == null && root.left.right == null) {
            count += root.left.val;
        } else {
            count += sumOfLeftLeaves(root.left);
        }

        count += sumOfLeftLeaves(root.right);
        return count;
    }
}
