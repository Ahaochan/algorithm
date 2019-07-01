package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 题目描述:
 * 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，
 * 对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。
 * 此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）
 *
 * 解题思路
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

    public TreeNode bstFromPreorder(int... preorder) {
        int len = preorder.length;

        TreeNode root = new TreeNode(preorder[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for(int i = 1; i < len; i++) {
            TreeNode node = queue.peek();
            if(node.val > preorder[i]) {
                node.left = new TreeNode(preorder[i]);
                queue.add(node.left);
            } else if(node.val < preorder[i]) {
                node.right = new TreeNode(preorder[i]);
                queue.add(node.right);
            }
        }
        return root;
    }
}
