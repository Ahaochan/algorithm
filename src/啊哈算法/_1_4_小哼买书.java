package 啊哈算法;

import java.util.Scanner;

/**
 *
 * Created by Ahaochan on 2017/7/10.
 * 小哼的学校要建立一个图书角，老师派小哼去找一些同学做调查，看看同学们都喜欢读
 哪些书。小哼让每个同学写出一个自己最想读的书的 ISBN号。当然有一些好书会有很多同学都喜欢，
 这样就会收集到很多重复的 ISBN号。小哼需要去掉其中重复的 ISBN号，即每个 ISBN号只
 保留一个，也就说同样的书只买一本（学校真是够抠门的）。然后再把这些 ISBN 号从小到
 大排序，小哼将按照排序好的 ISBN号去书店买书。请你协助小哼完成“去重”与“排序”
 的工作。
 输入有 2 行，第 1 行为一个正整数，表示有 n 个同学参与调查（n≤100）。第 2 行有 n
 个用空格隔开的正整数，为每本图书的 ISBN号（假设图书的 ISBN号在 1~1000 之间）。
 输出也是 2 行，第 1 行为一个正整数 k，表示需要买多少本书。第 2 行为 k 个用空格隔
 开的正整数，为从小到大已排好序的需要购买的图书的 ISBN号。
 例如输入：
 10
 20 40 32 67 40 20 89 300 400 15
 则输出：
 8
 15 20 32 40 67 89 300 400
 */
public class _1_4_小哼买书 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[1001];
        for (int i = 0; i < n; i++) {
            arr[in.nextInt()]++;
        }

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = arr.length; i < len; i++) {
            if(arr[i]>0){
                sum++;
                sb.append(i+" ");
            }
        }
        System.out.println(sum);
        System.out.println(sb.toString());
    }
}
