package 剑指offer.举例让抽象具体化;

/**
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 解题思路：
 * 后序遍历的特点, 最后一个元素是根节点, 遍历的数组组成为 [左子树][右子树][根节点]
 * 二叉搜索树的特点, 左子树的所有元素, 都比右子树任意一个元素小.
 *
 * 那么每次都根据 根节点, for循环找到数组中的左子树, 右子树的部分, 然后递归查找即可.
 *
 * TODO 非递归的方式不太明白, 留一个TODO
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {
        二叉搜索树的后序遍历序列 main = new 二叉搜索树的后序遍历序列();
        System.out.println(main.VerifySquenceOfBST(new int[]{3, 5, 4, 7, 8, 6})); // true
        System.out.println(main.VerifySquenceOfBST(new int[]{7, 4, 6, 5}));       // false
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        // 1. 递归的方法
//        return verify(sequence, 0, sequence.length - 1);

        // 2. 非递归的方法, 左子树的所有元素, 都比右子树任意一个元素小, 所以每次都拿右子树的最后一个元素来比较
        int len = sequence.length;
        while (--len >= 0) {
            int i = 0;
            while (sequence[i] < sequence[len]) i++;
            while (sequence[i] > sequence[len]) i++;
            if (i < len) return false;
        }
        return true;
    }

    public boolean verify(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }

        // 1. 当前子树的根节点
        int root = sequence[end];

        // 2. 找到左子树和右子树的分界点
        int mid = start;
        while (mid < end && sequence[mid] < root) {
            mid++;
        }

        // 3. 判断右子树是否满足 都大于根节点 的条件
        for (int i = mid; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        // 4. 递归判断左子树和右子树
        boolean left = verify(sequence, start, mid - 1);
        boolean right = verify(sequence, mid, end - 1);
        return left && right;
    }
}
