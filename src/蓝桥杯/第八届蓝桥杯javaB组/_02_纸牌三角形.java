package 蓝桥杯.第八届蓝桥杯javaB组;

import java.util.*;

//144
public class _02_纸牌三角形 {
	public static void main(String[] args) {
		long sum = 0;
		for(int a1 = 1; a1 <= 9; a1++){
		for(int a2 = 1; a2 <= 9; a2++){if(equals(a1,a2)) continue;
		for(int a3 = 1; a3 <= 9; a3++){if(equals(a1,a2,a3)) continue;
		for(int a4 = 1; a4 <= 9; a4++){if(equals(a1,a2,a3,a4)) continue;
			int num = a1+a2+a3+a4;
		for(int a5 = 1; a5 <= 9; a5++){if(equals(a1,a2,a3,a4,a5)) continue;
		for(int a6 = 1; a6 <= 9; a6++){
			int a7 = num-a1-a5-a6;
			if(a7<=0 || a7>9 || equals(a1,a2,a3,a4,a5,a6,a7)) continue;
		for(int a8 = 1; a8 <= 9; a8++){
			int a9 = num-a4-a8-a7;
			if(a9<=0 || a9>9 || equals(a1,a2,a3,a4,a5,a6,a7,a8,a9)) continue;
//			System.out.println(a1+","+a2+","+a3+","+a4+","+a5+","+a6+","+a7+","+a8+","+a9);
			if(equals((a1+a2+a3+a4),(a1+a5+a6+a7),(a4+a8+a9+a7))){
				sum++;
			}
		}}}}}}}
		System.out.println(sum/2/3);
	}
	
	private static boolean equals(int... arr){
		boolean flag = false;
		for(int i = 0; i < arr.length&&!flag; i++){
			for(int j = i+1; j < arr.length&&!flag; j++){
				if(arr[i]==arr[j]) flag = true;
			}
		}
		return flag;
	}
}
/**
 * A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
        下图就是一种排法（如有对齐问题，参看p1.png）。

               A
             9   6
            4      8
           3  7 5  2

 
        这样的排法可能会有很多。

        如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？

        请你计算并提交该数字。

        注意：需要提交的是一个整数，不要提交任何多余内容。
 */