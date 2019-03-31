package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * 题目描述:
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 解题思路
 * dfs, 做好if判断即可
 */
public class _0606_根据二叉树创建字符串 {


    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3); node1.left = node2; node1.right = node3;
        TreeNode node4 = new TreeNode(4); node2.left = node4;

        Assert.assertEquals("1(2(4))(3)", tree2str(node1));
    }

    @Test
    public void test2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3); node1.left = node2; node1.right = node3;
        TreeNode node4 = new TreeNode(4); node2.right = node4;

        Assert.assertEquals("1(2()(4))(3)", tree2str(node1));
    }

    /**
     * 执行用时 : 20 ms, 在Construct String from Binary Tree的Java提交中击败了74.94% 的用户
     * 内存消耗 : 41.3 MB, 在Construct String from Binary Tree的Java提交中击败了53.33% 的用户
     */
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (right.length() == 0) {
            return t.val + (left.length() == 0 ? "" : "(" + left + ")");
        }
        return t.val + "(" + left + ")(" + right + ")";
    }
}
