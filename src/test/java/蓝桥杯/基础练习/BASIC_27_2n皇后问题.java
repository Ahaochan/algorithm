package 蓝桥杯.基础练习;

import java.util.Scanner;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T68
 * @author Ahaochan
 * 问题描述
　　给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。现在要向棋盘中放入n个黑皇后和n个白皇后，使任意的两个黑皇后都不在同一行、同一列或同一条对角线上，任意的两个白皇后都不在同一行、同一列或同一条对角线上。问总共有多少种放法？n小于等于8。
输入格式
　　输入的第一行为一个整数n，表示棋盘的大小。
　　接下来n行，每行n个0或1的整数，如果一个整数为1，表示对应的位置可以放皇后，如果一个整数为0，表示对应的位置不可以放皇后。
输出格式
　　输出一个整数，表示总共有多少种放法。
样例输入
4
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
样例输出
2
样例输入
4
1 0 1 1
1 1 1 1
1 1 1 1
1 1 1 1
样例输出
0
 */
public class BASIC_27_2n皇后问题 {
	private static final int X = 0;
	private static final int Y = 1;
	private static final int INVALID = 0;
	private static final int NULL = 1;
	private static final int BLACK = 2;
	private static final int WHITE = 3;
	
	// 棋盘大小
	private static int n;
	// 棋盘
	private static int[][] chessboard;
	// 黑皇后位置, blackPos[i] = j , 表示第i个黑皇后(即第i行)在第j列
	private static int[] blackPos;
	// 白皇后位置, blackPos[i] = j , 表示第i个白皇后(即第i行)在第j列
	private static int[] whitePos;
	
	// 下子方案总数
	private static int count = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		chessboard = new int[n][n];
		blackPos = new int[n];
		whitePos = new int[n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				chessboard[i][j] = in.nextInt();
			}
		}
		in.close();
		
		// 必定每行有且只有一个黑皇后, 白皇后
		// 先放完黑皇后, 再放白皇后
		blackDFS(0);
		System.out.println(count);
	}
	
	/**
	 * 一行只有一个黑皇后
	 * blackDFS(n) 代表放第n个皇后
	 * @param row 第row个黑皇后, 同时也是第row行
	 */
	public static void blackDFS(int row){
		if(row==n) {
			// 下完黑皇后, 再下白皇后
			whiteDFS(0);
			return;
		}
		// 第i列
		for(int i = 0; i < n; i++){
			if(valid(row, i, BLACK)){
				chessboard[row][i] = BLACK;
				// 记录第row行第i列有黑皇后
				blackPos[row] = i;
				blackDFS(row+1);
				chessboard[row][i] = NULL;
			}
		}
	}
	
	/**
	 * 一行只有一个白皇后
	 * blackDFS(n) 代表放第n个皇后
	 * @param row 第row个白皇后, 同时也是第row行
	 */
	public static void whiteDFS(int row){
		if(row==n) {
			// 黑皇后和白皇后都下完, 则count++
			count++;
			return;
		}
		// 第i列
		for(int i = 0; i < n; i++){
			if(valid(row, i, WHITE)){
				chessboard[row][i] = WHITE;
				// 记录第row行第i列有白皇后
				whitePos[row] = i;
				whiteDFS(row+1);
				chessboard[row][i] = NULL;
			}
		}
	}

	/**
	 * 验证皇后下子的合法性
	 * @param x 第x行
	 * @param y 第y行
	 * @param chess 棋子类型
	 * @return
	 */
	private static boolean valid(int x, int y, int chess){
		// 不能放皇后, 或者没有空位放皇后
		if(chessboard[x][y]==INVALID || chessboard[x][y]!=NULL){
			return false;
		}
		for(int i = 0; i < x; i++){
			// 纵列有棋子, 或者对角线有棋子(斜率)
			if(chess==BLACK && (blackPos[i] == y || Math.abs(x-i) == Math.abs(y-blackPos[i]))){
				return false;
			}
			if(chess==WHITE && (whitePos[i] == y || Math.abs(x-i) == Math.abs(y-whitePos[i]))){
				return false;
			}
		}
		return true;
	}
}
