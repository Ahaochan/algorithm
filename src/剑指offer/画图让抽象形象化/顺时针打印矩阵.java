package 剑指offer.画图让抽象形象化;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 *
 * 则依次打印出数字
 * 1,2,3,4,
 * 8,12,16,15,
 * 14,13,9,5,
 * 6,7,11,10.
 *
 * 解题思路：
 * 迷宫题, 用一个 boolean[][]数组标记走过的路径, 到达边界或者走过的路, 就换个方向, 直到全部走过一遍
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 */
public class 顺时针打印矩阵 {

    public static void main(String[] args) {
        顺时针打印矩阵 main = new 顺时针打印矩阵();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        ArrayList<Integer> arrayList = main.printMatrix(matrix);
        System.out.println(arrayList);
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        // 标记走过的路径的 boolean[][]
        boolean[][] marked = new boolean[matrix.length][];
        int total = 0; // 总数
        for(int i = 0, len = matrix.length; i < len; i++) {
            total += matrix[i].length;
            marked[i] = new boolean[matrix[i].length];
        }

        // 当前所在位置
        int row = 0, col = 0;
        // 方向对应的坐标增量, 右下左上
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 方向
        int curDir = 0;

        // 1. 根据数量判断循环是否结束
        int num = 0;
        while (num < total) {

            // 2. 如果没走过, 就标记并输出, 这里的if是为了解决转向时仍停留在原地的问题
            if (!marked[row][col]) {
                marked[row][col] = true;
                result.add(matrix[row][col]);
                num++;
            }

            // 3. 判断下一个坐标是否走过
            int nextRow = row + dir[curDir][0], nextCol = col + dir[curDir][1];
            if (nextRow >= 0 && nextRow < marked.length && nextCol >= 0 && nextCol < marked[nextRow].length && !marked[nextRow][nextCol]) {
                row = nextRow;
                col = nextCol;
            }
            // 4. 如果走过了就转向
            else {
                curDir = (curDir + 1) % dir.length;
            }
        }
        return result;
    }
}
