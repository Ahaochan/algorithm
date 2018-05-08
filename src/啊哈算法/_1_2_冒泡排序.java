package 啊哈算法;

import java.util.*;

/**
 *
 * Created by Ahaochan on 2017/7/10.
 * 将 12 35 99 18 76 这 5个数进行从大到小的排序。
 */
public class _1_2_冒泡排序 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = in.nextInt();
		}
		
		for(int i = 0; i < n-1; i++){
			for(int j = 0; j < n-i-1; j++){
				if(arr[j+1]<arr[j]){
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		
		
	}
}
