package 啊哈算法;

import java.util.Scanner;

/**
 * Created by Ahaochan on 2017/7/11.
 * 现在小哼有n根火柴, 希望拼出形如A+B=C的等式
 * 问有多少种情形
 */
public class _3_3_火柴棍等式 {
    private static final int[] num = new int[]{6,2,5,5,4,5,6,3,7,6};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt()-2-2;

        int sum = 0;
        for(int i = 0; i <= 1111; i++){
            for(int j = 0; j <= 1111; j++){
                int k = i+j;
                if(getNum(i)+getNum(j)+getNum(k)==m){
                    sum++;
                    System.out.println(i+"+"+j+"="+k);
                }
            }
        }
        System.out.println(sum);
    }

    public static int getNum(int x){
        int n = 0;
        while(x/10>0){
            n += num[x%10];
            x /= 10;
        }
        n += num[x];
        return n;
    }
}
