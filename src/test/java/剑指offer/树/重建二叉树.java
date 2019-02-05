package 剑指offer.树;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 解题思路：
 * 用递归解决,
 * 前序遍历第一个节点1必定是根节点, 那么中序遍历中{4,7,2}必然是节点1的左子树, {5,3,8,6}必然是节点2的右子树.
 * 以此类推, 对每个前序序列中的节点, 都能在中序序列中, 找到对应的左子树序列和右子树序列
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 */
public class 重建二叉树 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }

        //  0 1 2 3 4 5 6 7
        // {1,2,4,7,3,5,6,8}
        // {4,7,2,1,5,3,8,6}
        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0, len = in.length; i < len; i++) {
            // 1. 找到当前根节点在终须序列中的下标
            if(in[i] == pre[0]){
                // 2. 获取当前根节点的 左子树和右子树 的 前序序列和中序序列
                int[] preL = Arrays.copyOfRange(pre, 1, i + 1); // from include, to exclude
                int[] preR = Arrays.copyOfRange(pre, i + 1, len);
                int[] inL  = Arrays.copyOfRange(in, 0, i);
                int[] inR  = Arrays.copyOfRange(in, i + 1, len);

                // 3. 递归
                root.left  = reConstructBinaryTree(preL, inL);
                root.right = reConstructBinaryTree(preR, inR);
            }
        }
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
