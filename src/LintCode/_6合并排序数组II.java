package LintCode;

/**
 * https://www.lintcode.com/problem/merge-two-sorted-arrays
 * 6. 合并排序数组 II
 * 描述
 * 合并两个排序的整数数组A和B变成一个新的数组。
 *
 * 样例
 * 给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
 *
 * 挑战
 * 你能否优化你的算法，如果其中一个数组很大而另一个数组很小？
 */
public class _6合并排序数组II {
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] arr = new int[A.length + B.length];
        int i = 0;
        int ai = 0, bi = 0;
        // 1. 至少要有一个数组全部复制到arr数组中
        while (ai < A.length && bi < B.length) {
            int a = A[ai], b = B[bi];
            if (a <= b) {
                arr[i] = a;
                ai++;
            } else {
                arr[i] = b;
                bi++;
            }
            i++;
        }
        // 2. 将另一个数组填充到arr数组中
        if (ai == A.length) {
            System.arraycopy(B, bi, arr, i, B.length - bi);
        } else {
            System.arraycopy(A, ai, arr, i, A.length - ai);
        }
        return arr;
    }
}
