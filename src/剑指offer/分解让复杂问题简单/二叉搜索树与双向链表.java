package 剑指offer.分解让复杂问题简单;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 比如 10,6,14,4,8,12,16
 *    10
 *  6    14    转为     ←   ←   ←    ←    ←    ←
 * 4 8  12 16         4 → 6 → 8 → 10 → 12 → 14 → 16
 *
 * 解题思路：
 * 每次都将所有左孩子入栈, 然后尝试将右孩子的所有左孩子入栈, 完成中序遍历。
 * 然后修复关联关系。
 * 具体看注释和代码
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        二叉搜索树与双向链表 main = new 二叉搜索树与双向链表();
        TreeNode node4  = new TreeNode(4);
        TreeNode node6  = new TreeNode(6);
        TreeNode node8  = new TreeNode(8);
        TreeNode node10 = new TreeNode(10);
        TreeNode node12 = new TreeNode(12);
        TreeNode node14 = new TreeNode(14);
        TreeNode node16 = new TreeNode(16);
        node10.left = node6;  node10.right = node14;
        node6.left = node4;   node6.right = node8;
        node14.left = node12; node14.right = node16;

        TreeNode result = main.Convert(node10);
        System.out.println(result);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        // 1. 用栈存储所有的左孩子
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = pRootOfTree;
        TreeNode head = null, link = null; // 链表头部和中间的节点

        while(stack.size() > 0 || node != null) {
            // 2. 将每次遍历的节点的所有左孩子入栈
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            // 3. 获取当前节点的叶子左孩子
            TreeNode pop = stack.pop();

            // 4. 初始化链表头部
            if(head == null) {
                head = pop;
                link = head;
                node = pop.right;
            }
            // 5. 初始化链表中间部分
            else {
                // 5.1. 尝试将当前节点的直接右孩子的所有左孩子全部入栈
                node = pop.right;
                // 5.2. 链表关系修复
                link.right = pop;
                TreeNode left = link;
                link = link.right;
                link.left = left;
            }
        }
        return head;
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
