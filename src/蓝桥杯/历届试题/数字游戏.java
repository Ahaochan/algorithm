package 蓝桥杯.历届试题;

import java.util.*;

public class 数字游戏 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextInt(), k = in.nextInt(), t = in.nextInt();
		long sum = 0, num = 1, per = 0;
		long base = (long) ((1+n)*1.0/2*n), n_2 = n*n;
		while(per<t){
			sum += num;
			num = (long) (num+base+n_2*per)%k;
			per++;
		}
		System.out.println(sum);
	}
}
