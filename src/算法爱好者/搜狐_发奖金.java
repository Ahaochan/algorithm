package 算法爱好者;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ahaochan on 2017/7/31.
 * 题目：公司进行了一次黑客马拉松大赛，
 * 全公司一共分为了N个组，每组一个房间排成一排开始比赛，比赛结束后没有公布成绩，
 * 但是每个组能够看到自己相邻的两个组里比自己成绩低的组的成绩，
 * 比赛结束之后要发奖金，以1w为单位，每个组都至少会发1w的奖金，
 * 另外，如果一个组发现自己的奖金没有高于比自己成绩低的组发的奖金，就会不满意，
 * 作为比赛的组织方，根据成绩计算出至少需要发多少奖金才能让所有的组满意。
 * <p>
 * 输入描述：
 * 每组数据先输入N，然后N行输入N个正整数，每个数表示每个组的比赛成绩。
 * <p>
 * 输出描述：
 * 输出至少需要多少w的奖金
 * <p>
 * 输入
 * 10
 * 20 32 12 32 45 11 21 31 41 33
 * <p>
 * 输出
 * 20
 */
public class 搜狐_发奖金 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = in.nextInt();
            money[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (score[i] > score[i - 1]) {
                money[i] = money[i - 1] + 1;
            } else {
                money[i] = 1;
                int idx = i - 1;
                // 回溯, 防止如分数为10 9 8 7 6 5 4 3 2 1的情况
                while (idx >= 0 && money[idx] <= money[idx + 1]) {
                    money[idx--]++;
                }
            }
        }
        System.out.println(Arrays.toString(money));
    }
}
