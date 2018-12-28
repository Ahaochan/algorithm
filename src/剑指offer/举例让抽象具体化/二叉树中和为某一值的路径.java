package 剑指offer.举例让抽象具体化;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 解题思路：
 * 看注释
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 二叉树中和为某一值的路径 {

    public static void main(String[] args) {
        二叉树中和为某一值的路径 main = new 二叉树中和为某一值的路径();
        TreeNode node10 = new TreeNode(10);
        TreeNode node5  = new TreeNode(5 );
        TreeNode node12 = new TreeNode(12);
        TreeNode node4  = new TreeNode(4 );
        TreeNode node7  = new TreeNode(7 );
        node10.left = node5; node10.right = node12;
        node5.left = node4; node5.right = node7;

        System.out.println(main.FindPath(node10, 22));
    }

    //    10
    //   5  12
    //  4 7
    // {10,5,12,4,7},22
    // [[10,5,7],[10,12]]
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) {
            return result;
        }
        // 1. 减去当前节点的值, 要求的节点值的和 还剩多少可以减
        path.add(root.val);
        target = target - root.val;

        // 2. 如果到达叶子节点, 且要求的节点值的和已经达到, 则加入result, 注意new
        if(target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }

        // 3. 递归左子树和右子树
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 4. 走完当前节点的子树, 则移除在path中的当前节点
        path.remove(path.size() - 1);
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
