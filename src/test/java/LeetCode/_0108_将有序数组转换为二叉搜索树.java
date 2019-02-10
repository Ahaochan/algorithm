package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 题目描述:
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 解题思路
 * 分治
 */
public class _0108_将有序数组转换为二叉搜索树 {

    @Test
    public void test1() {
        TreeNode tree = sortedArrayToBST(-10,-3,0,5,9);

        Assert.assertEquals(0, tree.val);
        Assert.assertEquals(-10, tree.left.val);
        Assert.assertEquals(5, tree.right.val);
        Assert.assertEquals(null, tree.left.left);
        Assert.assertEquals(-3, tree.left.right.val);
        Assert.assertEquals(null, tree.right.left);
        Assert.assertEquals(9, tree.right.right.val);

    }
    public TreeNode sortedArrayToBST(int... nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if(left > right)   return null;
        else if(left == right) return new TreeNode(nums[left]);

        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid+1, right);

        return root;
    }
}
