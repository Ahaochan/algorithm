package 剑指offer.查找和排序;

/**
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 解题思路：
 * 有序数组的查找, 一般都是用二分法.
 * 但是这个不是一个纯粹的有序数组, 所以需要稍微改动.
 *
 * 比如{3,4,5,1,2}, 可以得到一个规律, array[0] >= array[array.length-1], 开头必定不小于末尾, 这个很重要
 * 如果按照一般二分法, 中间的值是5.
 * 会出现3种情况
 * 1. array[start] < array[mid] && array[mid] > array[end]
 * 说明中间的值落在了左边的有序子序列中
 * 已知左边的有序子序列最小值必定不小于右边子序列的最大值, 所以二分搜索右边的部分, 将 start 赋值为 mid + 1
 *
 * 2. array[start] > array[mid] && array[mid] < array[end]
 * 说明中间的值落在了右边的有序子序列中, 将 end 赋值为 mid
 *
 * 第三种特殊情况
 * 如果出现{1,1,1,0,1}这种情况, array[start] = array[mid] = array[end]
 * 不能判断最小值在左边有序子序列还是右边有序子序列中, 那就缩小数组范围, start++;end--;
 * 然后又可以套用上面的两种情况
 *
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 */
public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        旋转数组的最小数字 main = new 旋转数组的最小数字();

        int[] a1 = {3,4,5,1,2,3,3};
        System.out.println(main.minNumberInRotateArray(a1) == 1);

        int[] a2 = {3,3,4,5,6,1,2,3};
        System.out.println(main.minNumberInRotateArray(a2) == 1);

        int[] a3 = {4,4,5,6,1,2,2};
        System.out.println(main.minNumberInRotateArray(a3) == 1);

        int[] a4 = {1,1,1,0,1};
        System.out.println(main.minNumberInRotateArray(a4) == 0);

    }

    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length <= 0) {
            return 0;
        }
        int start = 0, end = array.length - 1;
        while(start < end) {
            int mid = (start + end) / 2;

            // 3. array[start] = array[mid] = array[end] 无法判断最小值在哪个区间的情况, 缩小数组范围
            if(array[start] == array[mid] && array[mid] == array[end]) {
                start++;
                end--;
            }

            // 2. 中间的值落在了右边的有序子序列
            if(array[mid] <= array[end]) {
                end = mid;
            }
            // 1. 中间的值落在了左边的有序子序列中
            else {
                start = mid + 1;
            }
        }
        return array[start];
    }
}
