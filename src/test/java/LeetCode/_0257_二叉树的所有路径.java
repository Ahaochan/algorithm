package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 题目描述:
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 解题思路
 * 递归做
 */
public class _0257_二叉树的所有路径 {

    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3); node1.left = node2; node1.right = node3;
        TreeNode node5 = new TreeNode(5); node2.right = node5;

        List<String> actual = binaryTreePaths(node1);

        String[] expect = {"1->2->5", "1->3"};
        for (int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], actual.get(i));
        }
    }


    List<String> result = new ArrayList<>();
    List<Integer> route = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }

        dfs(root);
        return result;
    }

    public void dfs(TreeNode node) {
        route.add(node.val);

        if(node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            if(route.size() > 0) {
                sb.append(route.get(0));
                for(int i = 1, len = route.size(); i < len; i++) {
                    sb.append("->").append(route.get(i));
                }
            }
            result.add(sb.toString());
            // 使用 stream 超级超级超级慢!!!
//            result.add(route.stream().map(String::valueOf).collect(Collectors.joining("->")));
            return;
        }

        if(node.left != null) {
            dfs(node.left);
            route.remove(route.size() - 1);
        }
        if(node.right != null) {
            dfs(node.right);
            route.remove(route.size() - 1);
        }
    }
}
