package 啊哈算法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ahaochan on 2017/7/11.
 * 现在小哼有n根火柴, 希望拼出形如A+B=C的等式
 * 问有多少种情形
 */
public class _4_1_火柴棍等式 {

    private static int[] box = new int[9];
    private static boolean[] book = new boolean[10];

    public static void main(String[] args) {
        dfs(0);
    }

    public static void dfs(int step){
        if(step==9){
            int num1 = box[0]*100+box[1]*10+box[2];
            int num2 = box[3]*100+box[4]*10+box[5];
            int num3 = box[6]*100+box[7]*10+box[8];
            if(num1+num2==num3) {
                System.out.println(Arrays.toString(box));
            }
            return;
        }
        for(int i = 1; i <= 9; i++){
            if(!book[i]){
                box[step] = i;
                book[i] = true;
                dfs(step+1);
                book[i] = false;
            }
        }
    }
}
