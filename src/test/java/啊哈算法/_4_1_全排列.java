package 啊哈算法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ahaochan on 2017/7/11.
 * 有长度为n的字符数组, 输出全排列
 */
public class _4_1_全排列 {

    private static int n;
    private static char[] chars;
    private static char[] box;
    private static boolean[] book;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        book = new boolean[n];
        box = new char[n];
        chars = in.next().toCharArray();

        dfs(0);
    }

    public static void dfs(int step){
        if(step==n){
            System.out.println(Arrays.toString(box));
            return;
        }

        for(int i = 0, len = chars.length; i < len; i++){
            if(!book[i]){
                box[step] = chars[i];
                book[i] = true;
                dfs(step+1);
                book[i] = false;
            }
        }
    }
}
