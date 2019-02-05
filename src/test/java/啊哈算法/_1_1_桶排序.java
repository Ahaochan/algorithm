package 啊哈算法;

import java.util.Scanner;

/**
 *
 * Created by Ahaochan on 2017/7/10.
 * 期末考试完了老师要将同
 学们的分数按照从高到低排序。小哼的班上只有 5 个同学，这 5 个同学分别考了 5分、3 分、
 5 分、2 分和 8 分，哎考得真是惨不忍睹（满分是 10 分）。接下来将分数进行从大到小排序，
 排序后是 8 5 5 3 2。
 */
public class _1_1_桶排序 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[100];
		for(int i = 0; i < n; i++){
			arr[in.nextInt()]++;
		}
		
		for(int i = 0, len = arr.length; i < len; i++){
			for(int j = 0; j < arr[i]; j++){
				System.out.print(i+" ");
			}
		}

	}
}
