package 啊哈算法;

import java.util.Scanner;

/**
 * Created by Ahaochan on 2017/7/21.
 * floyd最短路径, 不能解决负权回路问题
 */
public class _6_1_Floyd_Warshall {
    /**
     * 4 8
     * 1 2 2
     * 1 3 6
     * 1 4 4
     * 2 3 3
     * 3 1 7
     * 3 4 1
     * 4 1 5
     * 4 3 12
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = i == j ? 0 : 999;
            }
        }
        for (int i = 0; i < m; i++) {
            matrix[in.nextInt()][in.nextInt()] = in.nextInt();
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
