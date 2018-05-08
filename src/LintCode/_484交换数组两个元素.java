package LintCode;

/**
 * https://www.lintcode.com/problem/swap-two-integers-in-array/
 * 484. 交换数组两个元素
 * 描述
 * 给你一个数组和两个索引，交换下标为这两个索引的数字
 * 样例
 * 给出 [1,2,3,4] index1 = 2, index2 = 3. 交换之后变成 [1,2,4,3]
 */
public class _484交换数组两个元素 {

    public void swapIntegers(int[] A, int index1, int index2) {
        int tmp = A[index1];
        A[index1] = A[index2];
        A[index2] = tmp;
    }
}
