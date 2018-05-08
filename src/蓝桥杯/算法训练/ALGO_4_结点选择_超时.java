package 蓝桥杯.算法训练;

import java.util.*;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T14
 * @author Ahaochan
 * 问题描述
有一棵 n 个节点的树，树上每个节点都有一个正整数权值。如果一个点被选择了，那么在树上和它相邻的点都不能被选择。求选出的点的权值和最大是多少？
输入格式
第一行包含一个整数 n 。
接下来的一行包含 n 个正整数，第 i 个正整数代表点 i 的权值。
接下来一共 n-1 行，每行描述树上的一条边。
输出格式
输出一个整数，代表选出的点的权值和的最大值。
样例输入
5
1 2 3 4 5
1 2
1 3
2 4
2 5
样例输出
12
样例说明
选择3、4、5号点，权值和为 3+4+5 = 12 。
数据规模与约定
对于20%的数据， n <= 20。
对于50%的数据， n <= 1000。
对于100%的数据， n <= 100000。
权值均为不超过1000的正整数。
 */
public class ALGO_4_结点选择_超时 {
	private static final int FALSE = 0;
	private static final int TRUE = 1;
	private static final int INVALID = 0;
	
	private static int n;
	// dp[i][0]表示不选择i点时，i点及其子树能选出的最大权值
	// dp[i][1]表示选择i点时，i点及其子树的最大权值。
	private static int[][] dp;
	// tree[i][j] = k表示第i个节点的第j个孩子节点为第k个节点
	private static int[][] tree;
	// childs[i] = j表示第i个节点有j个孩子
	private static int[] childs;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		dp = new int[n+1][2];
		tree = new int[n+1][n+1];
		childs = new int[n+1];
		for(int i = 1; i <= n; i++){
			dp[i][TRUE] = in.nextInt();
		}
		for(int i = 0; i < n-1; i++){
			int a = in.nextInt(), b = in.nextInt();
			tree[a][childs[a]++] = b;
			tree[b][childs[b]++] = a;
		}
		
		dfs(1, INVALID);
		int max = Math.max(dp[1][TRUE], dp[1][FALSE]);
		System.out.println(max);
	}
	
	private static void dfs(int now, int parent){
		int i = 0, child = INVALID;
		while((child = tree[now][i++]) != INVALID){
			if(child != parent){
				dfs(child, now);
				dp[now][TRUE] += dp[child][FALSE];
				dp[now][FALSE] += Math.max(dp[child][TRUE], dp[child][FALSE]);
			}
		}
	}
}
