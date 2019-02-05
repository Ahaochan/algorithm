package 啊哈算法;

import java.util.Scanner;

/**
 * Created by Ahaochan on 2017/7/11.
 * 新学期开始了，小哈是小哼的新同桌（小哈是个小美女哦~），小哼向小哈询问 QQ号，
 小哈当然不会直接告诉小哼啦，原因嘛你懂的。所以小哈给了小哼一串加密过的数字，同时
 小哈也告诉了小哼解密规则。规则是这样的：首先将第 1个数删除，紧接着将第 2 个数放到
 这串数的末尾，再将第 3 个数删除并将第 4 个数放到这串数的末尾，再将第 5 个数删除……
 直到剩下最后一个数，将最后一个数也删除。按照刚才删除的顺序，把这些删除的数连在一
 起就是小哈的 QQ啦。现在你来帮帮小哼吧。小哈给小哼加密过的一串数是“6 3 1 7 5 8 9 2 4”。
 */
public class _2_1_解密QQ号_队列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[2*n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        for(int i = 0, len = arr.length, last = n; i < len; i++){
            if(i%2==0){
                System.out.print(arr[i]+" ");
            } else {
                arr[last++] = arr[i];
            }
        }
    }
}
