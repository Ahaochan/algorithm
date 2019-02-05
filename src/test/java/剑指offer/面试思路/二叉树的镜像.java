package 剑指offer.面试思路;

/**
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 *
 * 解题思路：
 * 简单题, 考的是对引用的理解.
 * 递归循环调换每个节点的左孩子和右孩子即可.
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 二叉树的镜像 {

    //二叉树的镜像定义：源二叉树
    //    	    8
    //    	   /  \
    //    	  6   10
    //    	 / \  / \
    //    	5  7 9 11
    //    	镜像二叉树
    //    	    8
    //    	   /  \
    //    	  10   6
    //    	 / \  / \
    //    	11 9 7  5
    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }

        // 1. 调换左孩子和右孩子
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 2. 递归每个节点
        Mirror(root.left);
        Mirror(root.right);
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
