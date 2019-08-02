package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 * 题目描述:
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 解题思路
 * 用递归比较简单, 但是有很多重复运算
 * // TODO 优化方法 https://leetcode-cn.com/problems/path-sum-iii/comments/9351
 */
public class _0437_路径总和III {
    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);  node1.left  = node2;
        TreeNode node3 = new TreeNode(-3); node1.right = node3;
        TreeNode node4 = new TreeNode(3);  node2.left  = node4;
        TreeNode node5 = new TreeNode(2);  node2.right = node5;
        TreeNode node6 = new TreeNode(11); node3.right = node6;
        TreeNode node7 = new TreeNode(3);  node4.left  = node7;
        TreeNode node8 = new TreeNode(-2); node4.right = node8;
        TreeNode node9 = new TreeNode(1);  node5.right = node9;

        Assert.assertEquals(3, pathSum(node1, 8));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, pathSum(null, 1));
    }

    @Test
    public void test3() {
        //       1
        //    -2      -3
        //   1  3   -2
        // -1
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(-2);  node1.left  = node2;
        TreeNode node3 = new TreeNode(-3); node1.right = node3;
        TreeNode node4 = new TreeNode(1);  node2.left  = node4;
        TreeNode node5 = new TreeNode(3);  node2.right = node5;
        TreeNode node6 = new TreeNode(-2); node3.left = node6;
        TreeNode node7 = new TreeNode(-1);  node4.left  = node7;

        Assert.assertEquals(4, pathSum(node1, -1));
    }

    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        sumCountMap.put(0, 1);
        return dfs1(root, sum, 0);
    }

    Map<Integer, Integer> sumCountMap = new HashMap<>(); // sum 为 key, count 为 value 的 Map
    public int dfs1(TreeNode node, int sum, int curSum) {
        if(node == null) {
            return 0;
        }

        curSum += node.val;
        int count = sumCountMap.getOrDefault(curSum, 0);
        sumCountMap.put(curSum, count + 1);

        int cur = sumCountMap.getOrDefault(curSum - sum, 0);
        cur += dfs1(node.left, sum, curSum) + dfs1(node.right, sum, curSum);

        sumCountMap.put(curSum, count);
        return cur;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/24646945/
     * 执行用时 :20 ms, 在所有 Java 提交中击败了36.54%的用户
     * 内存消耗 :39 MB, 在所有 Java 提交中击败了75.07%的用户
     */
    public int pathSum_slow(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (deque.size() > 0) {
            TreeNode node = deque.pop();
            dfs(node, sum);
            if(node.left != null) {
                deque.push(node.left);
            }
            if(node.right != null) {
                deque.push(node.right);
            }
        }
        return count;
    }

    private int count = 0;
    public void dfs(TreeNode node, int sum) {
        if(node == null) {
            return;
        }

        if(sum - node.val == 0) {
            count++;
        }
        dfs(node.left, sum - node.val);
        dfs(node.right, sum - node.val);
    }
}
