package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.Node;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * 题目描述:
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 例如，给定一个 3叉树 :
 *        1
 *   3    2    4
 *  5 6
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * 解题思路
 * 标准先序遍历题, 用递归或迭代做
 */
public class _0589_N叉树的前序遍历 {
    @Test
    public void test1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.children = Arrays.asList(node3, node2, node4);
        node3.children = Arrays.asList(node5, node6);


        Assert.assertEquals(Arrays.asList(1, 3, 5, 6, 2, 4), preorder(node1));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21092417/
     * 执行用时 :6 ms, 在所有 Java 提交中击败了52.85%的用户
     * 内存消耗 :47.4 MB, 在所有 Java 提交中击败了94.56%的用户
     */
    public List<Integer> preorder(Node root) {
        if(root == null) {
            return Collections.emptyList();
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        List<Integer> result = new ArrayList<>();
        while (stack.size() > 0) {
            Node node = stack.pop();
            result.add(node.val);

            if(node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21090117/
     * 执行用时 :6 ms, 在所有 Java 提交中击败了52.85%的用户
     * 内存消耗 :52.7 MB, 在所有 Java 提交中击败了74.57%的用户
     */
    public List<Integer> preorder_recursive(Node root) {
        doPre(root);
        return result;
    }
    public List<Integer> result = new ArrayList<>();
    public void doPre(Node root) {
        if(root == null) {
            return;
        }

        result.add(root.val);

        if(root.children == null) {
            return;
        }

        for (Node child : root.children) {
            doPre(child);
        }
    }



}
