package 剑指offer.举例让抽象具体化;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 *
 * 解题思路：
 * 用一个队列存储节点, 每次循环都把左右孩子加入队尾
 *      1
 *    2   3
 *  4  5
 * 先将 1 加入队列: 1
 * 取出 1 , 加入 1 的左右孩子 2 3: 2 3
 * 取出 2 , 加入 2 的左右孩子 4 5: 3 4 5
 * 取出 3 , 加入 3 的左右孩子, 没有左右孩子则不加入: 4 5
 * 取出 4 5, 都没有左右孩子, 队列为空, 则执行结束
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 从上往下打印二叉树 {
    public static void main(String[] args) {
        从上往下打印二叉树 main = new 从上往下打印二叉树();

        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node1; root.right = node2;
        node1.left = node3;
        node2.left = node4; node2.right = node5;

        ArrayList<Integer> list = main.PrintFromTopToBottom(root);
        System.out.println(list);
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null) {
            return new ArrayList<>(0);
        }

        ArrayList<Integer> result = new ArrayList<>();

        // 1. 用一个队列存储节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 2. 每次循环都把左右孩子加入队尾, 同时输出队头的val
        while(queue.size() > 0) {
            root = queue.poll();
            if(root == null) {
                continue;
            }
            result.add(root.val);
            queue.add(root.left);
            queue.add(root.right);
        }
        return result;
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
