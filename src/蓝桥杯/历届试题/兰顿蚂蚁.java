package 蓝桥杯.历届试题;

import java.util.*;

public class 兰顿蚂蚁 {
	//http://zodiacg.net/2011/12/the-ultimate-truth-and-langton-ant-highway/
	private static final int U = 0;
	private static final int L = 1;
	private static final int D = 2;
	private static final int R = 3;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt(), n = in.nextInt();
		boolean[][] maze = new boolean[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				maze[i][j] = in.nextInt()==1;
			}
		}
		int x = in.nextInt(), y = in.nextInt(), s = U, k;
		switch(in.next().charAt(0)){
			case 'U': s = U; break;
			case 'R': s = R; break;
			case 'D': s = D; break;
			case 'L': s = L; break;
		}
		k = in.nextInt();
		
		while(k-->0){
			s = ((maze[x][y] ? s-1:s+1) +4)%4;
			maze[x][y] = !maze[x][y];
			switch(s){
				case U: x--; break;
				case R: y++; break;
				case D: x++; break;
				case L: y--; break;
			}
		}
		System.out.println(x+" "+y);
	}
}
