package 啊哈算法;

import java.util.*;

/**
 *
 * Created by Ahaochan on 2017/7/10.
 * 对“6 1 2 7 9 3 4 5 10 8”这 10个数进行排序
 */
public class _1_3_快速排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        quickSort(arr, 0, n-1);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int l = left, r = right, key = arr[left];
        while (l < r) {
            while (l < r && arr[r] >= key) r--;
            while (l < r && arr[l] <= key) l++;
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = key;
        quickSort(arr, l+1, right);
        quickSort(arr, left, l-1);
    }

}
