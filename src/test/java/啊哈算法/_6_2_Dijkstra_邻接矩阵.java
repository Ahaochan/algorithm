package 啊哈算法;

import java.util.Scanner;

/**
 * Created by Ahaochan on 2017/7/21.
 * Dijkstra算法, 单源最短路径
 *
 */
public class _6_2_Dijkstra_邻接矩阵 {
    private static int MAX_STEP = 1000;
    /**
     * 6 9
     1 2 1
     1 3 12
     2 3 9
     2 4 3
     3 5 5
     4 3 4
     4 5 13
     4 6 15
     5 6 4
     */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//顶点数
        int m = in.nextInt();//边数
        int[][] map = new int[n+1][n+1];//存储图的邻接矩阵
        boolean[] book = new boolean[n+1];//标记某个点是否走过
        int[] dis = new int[n+1];//存储最短距离的数组
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++){
                map[i][j] = i==j?0:MAX_STEP;
            }
        }
        for(int i = 1; i <= m; i++){
            map[in.nextInt()][in.nextInt()] = in.nextInt();
        }
        System.arraycopy(map[1], 1, dis, 1, n);
        //初始化完毕

        book[1] = true;
        for(int i = 1; i <= n-1; i++){//遍历第1到n-1个点
            int min = MAX_STEP;
            int minIdx = -1;
            for(int j = 1; j <=n; j++){//找到距离第i个点最近的一个点作为中转点
                if(!book[j] && dis[j]<min){
                    min = dis[j];
                    minIdx = j;
                }
            }
            book[minIdx] = true;
            for(int j = 1; j <= n; j++){//根据中转点获得新的距离，用来更新dis
                dis[j] = Math.min(dis[j], dis[minIdx]+map[minIdx][j]);
            }
            printf(dis);
        }
    }

    private static void printf(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
}
