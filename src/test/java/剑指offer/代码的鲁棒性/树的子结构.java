package 剑指offer.代码的鲁棒性;

/**
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 *
 *
 * 解题思路：
 * 苦力题, 找到 A 中和 B头节点 一样的节点, 然后递归比较
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 树的子结构 {
    //       8                8
    //    8     7            9 2
    //  9   2   # #
    // # # 4 7

    //       8                8
    //    8     7            9 2
    //  9   3   # #
    // # # 4 7
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) {
            // 我们约定空树不是任意一个树的子结构
            return false;
        }

        boolean eq = root1.val == root2.val;
        if(eq) {
            // 1. 判断当前根节点的 A 和 B 是否是完全一致的树
            eq = isSubTree(root1, root2);
        }

        return eq ||
                // 2. 判断 A的左子树 和 B 是否是完全一致的树
                HasSubtree(root1.left, root2) ||
                // 3. 判断 A的右子树 和 B 是否是完全一致的树
                isSubTree(root1.right, root2);
    }


    public boolean isSubTree(TreeNode A,TreeNode B) {
        // 1. B 遍历完毕, 说明 B 是 A 的子结构
        if(B == null) {
            return true;
        }
        // 2. A 已经遍历完毕, B还没遍历完,  说明 B 不是 A 的子结构
        if(A == null) {
            return false;
        }

        // 3. 判断当前节点、左子树、右子树 是否相等
        return A.val == B.val && isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
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
