package 啊哈算法;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Ahaochan on 2017/7/21.
 */
public class _6_3_Bellman_Ford {
    private static int MAX_STEP = 1000;
    /**
     * 5 5
     2 3 2
     1 2 -3
     1 5 5
     4 5 2
     3 4 3
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        // u[i] 表示 第i条边的起点编号
        // v[i] 表示 第i条边的终点编号
        // w[i] 表示 第i条边的权值
        int[] u = new int[m + 1], v = new int[m + 1], w = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            u[i] = in.nextInt();
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        int[] dis = new int[n + 1];//存储最短距离的数组
        for(int i = 1; i <= n; i++) {
            dis[i] = i == 1 ? 0 : MAX_STEP;
        }

        for (int k = 1; k <= n - 1; k++) {
            for (int i = 1; i <= m; i++) {
                dis[v[i]] = Math.min(dis[v[i]], dis[u[i]] + w[i]);
            }
        }

        // 检测负权回路, 如果还能继续松弛
        boolean flag = false;
        for (int i = 1; i <= m; i++) {
            if(dis[v[i]]>dis[u[i]] + w[i]){
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("存在负权回路");
        }

        System.out.println(Arrays.toString(dis));

    }
}
