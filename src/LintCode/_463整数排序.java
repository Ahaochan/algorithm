package LintCode;

/**
 * https://www.lintcode.com/problem/sort-integers
 * 463. 整数排序
 * 描述
 * 给一组整数，按照升序排序，使用选择排序，冒泡排序，插入排序或者任何 O(n2) 的排序算法。
 * 样例
 * 对于数组 [3, 2, 1, 4, 5], 排序后为：[1, 2, 3, 4, 5]。
 */
public class _463整数排序 {

    public void sortIntegers(int[] A) {
        // 1. 冒泡排序
        for(int i = 0, len = A.length; i < len-1; i++){
            for(int j = 0; j < len-i-1; j++){
                if(A[j]>A[j+1]){
                    int tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                }
            }
        }
    }
}
