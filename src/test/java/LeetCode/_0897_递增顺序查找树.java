package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * 题目描述:
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * 解题思路
 * 中序遍历解决
 */
public class _0897_递增顺序查找树 {
    @Test
    public void test1() {
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        TreeNode node14 = new TreeNode(4);
        TreeNode node15 = new TreeNode(5);
        TreeNode node16 = new TreeNode(6);
        TreeNode node17 = new TreeNode(7);
        TreeNode node18 = new TreeNode(8);
        TreeNode node19 = new TreeNode(9);
        node15.left = node13; node15.right = node16;
        node13.left = node12; node13.right = node14;
        node12.left = node11;
        node16.right = node18;
        node18.left = node17; node18.right = node19;


        TreeNode actual = increasingBST(node11);
        int i = 1;
        while (actual != null) {
            Assert.assertEquals(actual.val, i++);
            actual = actual.right;
        }
    }

    /**
     * https://leetcode-cn.com/submissions/detail/28589965/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了98.62%的用户
     * 内存消耗 :46.1 MB, 在所有 Java 提交中击败了76.00%的用户
     */
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode(0);
        cur = head;
        dfs(root);
        return head.right;
    }

    TreeNode cur;
    public void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        dfs(node.left);

        node.left = null;
        cur.right = node;
        cur = node;

        dfs(node.right);
    }
}
