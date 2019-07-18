package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * 题目描述:
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * 解题思路
 * 中序遍历即可
 */
public class _0501_二叉搜索树中的众数 {
    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2); node1.right = node2;
        TreeNode node3 = new TreeNode(2); node2.left = node3;
        Assert.assertArrayEquals(new int[]{2}, findMode(node1));
    }

    @Test
    public void test2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2); node1.right = node2;
        Assert.assertArrayEquals(new int[]{1,2}, findMode(node1));
    }


    /**
     * https://leetcode-cn.com/submissions/detail/23209690/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :41 MB, 在所有 Java 提交中击败了68.21%的用户
     */
    public int[] findMode(TreeNode root) {
        // 1. 中序遍历
        inOrder(root);

        // 2. 转为 int[]
        int len = list.size();
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    List<Integer> list = new ArrayList<>();
    TreeNode pre;
    int count = 1, max = 0;
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        // 1. 中序遍历模版 左子树
        inOrder(root.left);

        // 2. 中序遍历模版 中间节点
        // 2.1. 因为中序遍历有序, 所以只要和前一个节点判断, 即可统计当前节点出现的次数
        if(pre != null) {
            if(pre.val == root.val) {
                count++;
            } else {
                count = 1;
            }
        }

        // 2.2. 如果有多个众数, 则一起加入集合
        if(count == max) {
            list.add(root.val);
        }

        // 2.3. 如果有超过当前众数的节点, 则清空众数集合, 重新初始化
        if(count > max) {
            list.clear();
            list.add(root.val);
            max = count;
        }

        // 2.4. 保存前一个节点
        pre = root;

        // 3. 中序遍历模版 右子树
        inOrder(root.right);
    }
}
