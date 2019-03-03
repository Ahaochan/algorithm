package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 题目描述:
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * 解题思路
 * 当 q.val < node.val < p.val 时, 则 node 为公共祖先.
 */
public class _0235_二叉搜索树的最近公共祖先 {

    @Test
    public void test1() {
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8); node6.left = node2; node6.right = node8;
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4); node2.left = node0; node2.right = node4;
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5); node4.left = node3; node4.right = node5;
        TreeNode node7 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5); node8.left = node7; node8.right = node9;

        Assert.assertEquals(node6, lowestCommonAncestor(node6, node2, node8));
        Assert.assertEquals(node2, lowestCommonAncestor(node6, node2, node4));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
