package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import 工具.Node;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * 题目描述:
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 例如，给定一个 3叉树 :
 *        1
 *   3    2    4
 *  5 6
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * 解题思路
 * 标准后序遍历题, 用递归或迭代做
 */
public class _0590_N叉树的后序遍历 {
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


        Assert.assertEquals(Arrays.asList(5, 6, 3, 2, 4, 1), postorder(node1));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21092992/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了65.94%的用户
     * 内存消耗 :54.1 MB, 在所有 Java 提交中击败了65.19%的用户
     */
    public List<Integer> postorder(Node root) {
        doPost(root);
        return result;
    }
    public List<Integer> result = new ArrayList<>();
    public void doPost(Node root) {
        if(root == null) {
            return;
        }

        if(root.children != null) {
            for (Node child : root.children) {
                doPost(child);
            }
        }
        result.add(root.val);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21093792/
     * 执行用时 :7 ms, 在所有 Java 提交中击败了43.57%的用户
     * 内存消耗 :47.9 MB, 在所有 Java 提交中击败了94.51%的用户
     */
    public List<Integer> postorder_iteration(Node root) {
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
                for (int i = 0, len = node.children.size(); i < len; i++) {
                    stack.push(node.children.get(i));
                }
            }
        }
        Collections.reverse(result);
        return result;
    }
}
