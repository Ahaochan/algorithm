package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/submissions/
 * 题目描述:
 * 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，
 * 对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。
 * 此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）
 *
 * 解题思路
 * 还是递归简单, 又快, 我超喜欢的
 */
public class _1008_先序遍历构造二叉树 {


    @Test
    public void test1() {
        TreeNode node = bstFromPreorder(8,5,1,7,10,12);
        Assert.assertEquals(8, node.val);
        Assert.assertEquals(5, node.left.val);
        Assert.assertEquals(1, node.left.left.val);
        Assert.assertEquals(7, node.left.right.val);
        Assert.assertEquals(10, node.right.val);
        Assert.assertEquals(12, node.right.right.val);
    }
    /**
     * https://leetcode-cn.com/submissions/detail/24540092/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :35.5 MB, 在所有 Java 提交中击败了59.71%的用户
     */
    public TreeNode bstFromPreorder(int... preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1, len = preorder.length; i < len; i++) {
            int value = preorder[i];
            dfs(root, value);
        }
        return root;
    }

    public void dfs(TreeNode node, int value) {
        if(node == null) {
            return;
        }

        if(node.val > value) {
            if(node.left == null) {
                node.left = new TreeNode(value);
            } else {
                dfs(node.left, value);
            }
        } else {
            if(node.right == null) {
                node.right = new TreeNode(value);
            } else {
                dfs(node.right, value);
            }
        }
    }

    /**
     * https://leetcode-cn.com/submissions/detail/24541007/
     * 执行用时 :2 ms, 在所有 Java 提交中击败了91.10%的用户
     * 内存消耗 :35.3 MB, 在所有 Java 提交中击败了59.71%的用户
     */
    public TreeNode bstFromPreorder_dfs_slow(int... preorder) {
        return dfs_slow(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int idx = 0;
    public TreeNode dfs_slow(int[] preorder, int low, int high) {
        if(idx >= preorder.length) return null;
        int value = preorder[idx];
        if(value < low || value > high) return null;

        idx++;
        TreeNode node = new TreeNode(value);
        node.left = dfs_slow(preorder, low, value);
        node.right = dfs_slow(preorder, value, high);
        return node;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/24543259/
     * 执行用时 :3 ms, 在所有 Java 提交中击败了15.75%的用户
     * 内存消耗 :36.2 MB, 在所有 Java 提交中击败了55.04%的用户
     */
    public TreeNode bstFromPreorder_queue(int... preorder) {
        int len = preorder.length;

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> deque = new ArrayDeque<>(len);
        deque.push(root);

        for (int i = 1; i < len; i++) {
            TreeNode node = deque.peek();
            TreeNode child = new TreeNode(preorder[i]);

            while (deque.size() > 0 && deque.peek().val < child.val) {
                node = deque.pop();
            }

            if(node.val < child.val) node.right = child;
            else node.left = child;

            deque.push(child);
        }
        return root;
    }
}
