package LintCode;

/**
 * https://www.lintcode.com/problem/binary-tree-maximum-node
 * 632. 二叉树的最大节点
 * 描述
 * 在二叉树中寻找值最大的节点并返回。
 * 样例
 * 给出如下一棵二叉树：
 * 1
 * /   \
 * -5     2
 * / \   /  \
 * 0   3 -4  -5
 * 返回值为 3 的节点。
 */
public class _632二叉树的最大节点 {

    public TreeNode maxNode(TreeNode root) {
        TreeNode max = root;
        if(root == null){
            return null;
        }

        if(root.left!=null){
            TreeNode leftMax = maxNode(root.left);
            if(leftMax.val > max.val){
                max = leftMax;
            }
        }
        if(root.right!=null){
            TreeNode rightMax = maxNode(root.right);
            if(rightMax.val > max.val){
                max = rightMax;
            }
        }
        return max;
    }


    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

}
