package 工具;

import java.util.Arrays;

public class OutputUtils {
    public static void print(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(" ");
    }
}
