package 蓝桥杯.基础练习;

import java.util.Scanner;
/**
 * http://lx.lanqiao.cn/problem.page?gpid=T66
 * @author Ahaochan
 * 问题描述
　　回形取数就是沿矩阵的边取数，若当前方向上无数可取或已经取过，则左转90度。一开始位于矩阵左上角，方向向下。
输入格式
　　输入第一行是两个不超过200的正整数m, n，表示矩阵的行和列。接下来m行每行n个整数，表示这个矩阵。
输出格式
　　输出只有一行，共mn个数，为输入矩阵回形取数得到的结果。数之间用一个空格分隔，行末不要有多余的空格。
样例输入
3 3
1 2 3
4 5 6
7 8 9
样例输出
1 4 7 8 9 6 3 2 5
样例输入
3 2
1 2
3 4
5 6
样例输出
1 3 5 6 4 2
 */
public class BASIC_25_回形取数 {
	private static final int X = 0;
	private static final int Y = 1;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt(), n = in.nextInt();
		// 下右上左4个方向
		int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
		int[][] matrix = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = in.nextInt();
			}
		}
		// matrix[i][j]是否走过
		boolean[][] selected = new boolean[m][n];
		
		// 起点为(0,0)
		int x = 0, y = 0;
		selected[x][y] = true;
		System.out.print(matrix[x][y]+" ");
		int num = m*n-1;
		while(num>0){
			// 下右上左4个方向
			for(int i = 0, len = dir.length; i < len; i++){
				int[] d = dir[i];
				while(between(x+d[X], 0, m) && between(y+d[Y], 0, n) &&
						!selected[x+d[X]][y+d[Y]]){
					
					num--;	
					x += d[X];
					y += d[Y];
					selected[x][y] = true;
					System.out.print(matrix[x][y]+" ");
				}
			}
		}
	}
	
	private static boolean between(int num, int min, int max){
		if(num>=min && num<max){
			return true;
		}
		return false;
	}
}
