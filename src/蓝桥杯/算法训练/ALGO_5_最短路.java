package 蓝桥杯.算法训练;

import java.util.*;

public class ALGO_5_最短路 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		int[][] map = new int[n+1][n+1];
		while(m-->0){
			int u = in.nextInt(), v = in.nextInt(), l = in.nextInt();
			map[u][v] = l;
		}
		
//		// floyd最短路径
//		for(int end = 2; end <= n; end++){
//			for(int mid = 2; j <= n; j++){
//				map[1][i] = Math.min(map[1][j]+map[j][i], map[1][i]);
//			}
//		}
//		
//		for
		System.out.println(Arrays.toString(map[1]));

	}
}
