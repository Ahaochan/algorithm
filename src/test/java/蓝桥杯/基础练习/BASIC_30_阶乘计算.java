package 蓝桥杯.基础练习;

import java.util.Scanner;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T71
 * @author Ahaochan
 * 问题描述
　　输入一个正整数n，输出n!的值。
　　其中n!=1*2*3*…*n。
算法描述
　　n!可能很大，而计算机能表示的整数范围有限，需要使用高精度计算的方法。使用一个数组A来表示一个大整数a，A[0]表示a的个位，A[1]表示a的十位，依次类推。
　　将a乘以一个整数k变为将数组A的每一个元素都乘以k，请注意处理相应的进位。
　　首先将a设为1，然后乘2，乘3，当乘到n时，即得到了n!的值。
输入格式
　　输入包含一个正整数n，n<=1000。
输出格式
　　输出n!的准确值。
样例输入
10
样例输出
3628800
 */
public class BASIC_30_阶乘计算 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] result = new int[]{1};
		for(int i = 2; i <= n; i++){
			result = mul(result, toArray(i));
			// 每次计算完毕都要清除多余的0
			result = clearZero(result);
		}
		for(int i = 0, len = result.length; i < len; i++){
			System.out.print(result[i]);
		}
	}
	
	/**
	 * 返回num1*num2
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int[] mul(int[] num1, int[] num2){
		// 保证num1长度比num2大
		int num1Len = num1.length, num2Len = num2.length;
		int maxLen = Math.max(num1Len, num2Len);
		if(num2Len>num1Len){
			int[] temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		int[] a = copy(num1);
		int[] b = copy(num2);
		// 999*999 = 998001
		// 结果最大长度为原数组长度两倍, 前面多的0要清除
		int[] c = new int[maxLen*2];
		
		//    aaa
		//  * bbb
		// cccccc
		for(int bi = b.length-1; bi >= 0; bi--){
			for(int ai = a.length-1, ci = (c.length)-(b.length-bi); ai>=0; ai--, ci--){
				c[ci] += b[bi]*a[ai];
				// 进位
				if(c[ci]>=10){
					c[ci-1] += c[ci]/10;
					c[ci] %= 10;
				}
			}
		}
		return c;
	}
	
	/**
	 * 数字转数组
	 * @param num
	 * @return
	 */
	public static int[] toArray(int num){
		String str = num+"";
		int[] arr = new int[str.length()];
		for(int i = arr.length-1, j = str.length()-1; i >= 0 && j>=0; i--,j--){
			arr[i] = str.charAt(j)-'0';
		}
		return arr;
	}
	
	/**
	 * 清除数组前面的0
	 * @param arr
	 * @return
	 */
	public static int[] clearZero(int[] arr){
		int idx = 0;
		for(int i = 0, len = arr.length; i<len; i++){
			if(arr[i]!=0){
				idx = i;
				break;
			}
		}
		int[] result = new int[arr.length-idx];
		System.arraycopy(arr, idx, result, 0, result.length);
		return result;
	}
	
	/**
	 * 复制数组
	 * @param arr
	 * @return
	 */
	public static int[] copy(int[] arr){
		int[] newArr = new int[arr.length];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		return newArr;
	}
}
