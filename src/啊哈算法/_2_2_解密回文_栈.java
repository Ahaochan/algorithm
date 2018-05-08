package 啊哈算法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ahaochan on 2017/7/11.
 * “xyzyx”是一个回文字符串，所谓回文字符
 串就是指正读反读均相同的字符序列，如“席主席”、“记书记”、“aha”和“ahaha”均是回
 文，但“ahah”不是回文。通过栈这个数据结构我们将很容易判断一个字符串是否为回文。
 */
public class _2_2_解密回文_栈 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] stack = new char[str.length()/2];
        for(int i = 0, len = stack.length; i < len; i++){
            stack[i] = str.charAt(i);
        }

        boolean flag = true;
        for(int len = str.length(), i = len/2+1; i < len    ; i++){
            if(str.charAt(i) != stack[len-i-1]){
                flag = false;
                break;
            }
        }
        System.out.println(flag?"YES":"NO");

    }
}
