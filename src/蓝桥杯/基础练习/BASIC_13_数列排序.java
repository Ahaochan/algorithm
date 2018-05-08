package 蓝桥杯.基础练习;

import java.util.*;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T52
 * @author Ahaochan
问题描述
　　给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200
输入格式
　　第一行为一个整数n。
　　第二行包含n个整数，为待排序的数，每个整数的绝对值小于10000。
输出格式
　　输出一行，按从小到大的顺序输出排序后的数列。
样例输入
5
8 3 6 4 9
样例输出
3 4 6 8 9
 */
public class BASIC_13_数列排序 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++){
			arr[i] = in.nextInt();
		}
		
		quickSort(arr, 0, arr.length-1);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	// 快速排序
	public static void quickSort(int[] arr, int left, int right){
		if(left>right)	return;
		int l = left, r = right, key = arr[left];
		while(l<r){
			while(l<r && arr[r]>=key) r--;
			while(l<r && arr[l]<=key) l++;
			if(l<r){
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
