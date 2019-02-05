package 啊哈算法;

import java.util.Scanner;

/**
 * Created by Ahaochan on 2017/7/21.
 * Dijkstra算法, 单源最短路径, 不能解决负权边
 */
public class _6_2_Dijkstra_邻接表 {
    private static int MAX_STEP = 1000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        // u[i] 表示 第i条边的起点编号
        // v[i] 表示 第i条边的终点编号
        // w[i] 表示 第i条边的权值
        int[] u = new int[m+1], v = new int[m+1], w = new int[m+1];
        // first[i] 表示 第i个顶点的第一条边的编号
        // next[i]  表示 第i条边的下一条边的编号
        int[] first = new int[n+1], next = new int[m+1];
        for(int i = 1; i <= n; i++){
            first[i] = -1;
        }
        for(int i = 1; i <= m; i++){
            u[i] = in.nextInt();
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            // 2. 把 第u[i]个顶点的第一条边 压入 第i条边的下一条边
            next[i] = first[u[i]];
            // 1. 把 第i条边的编号 压入 第u[i]个顶点的第一条边
            first[u[i]] = i;
        }

        boolean[] book = new boolean[n+1];//标记某个点是否走过
        int[] dis = new int[n+1];//存储最短距离的数组
        for(int i = 1; i <= n; i++){
            dis[i] = i==1?0:MAX_STEP;
        }
        // 初始化dis
        int k = first[1];
        while(k!=-1){
            dis[v[k]] = w[k];
            k = next[k];
        }

        for(int i = 1; i <= n-1; i++){
            int min = MAX_STEP;
            int minIdx = -1;
            for(int j = 1; j <=n; j++){//找到距离第i个点最近的一个点作为中转点
                if(!book[j] && dis[j]<min){
                    min = dis[j];
                    minIdx = j;
                }
            }
            book[minIdx] = true;
            // 核心算法
            k = first[minIdx];
            while(k!=-1){
                dis[v[k]] = Math.min(dis[v[k]], dis[minIdx]+w[k]);
                k = next[k];
            }
            // 核心算法

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
