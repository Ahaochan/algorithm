package 蓝桥杯.基础练习;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T47
 * @author Ahaochan
 * 问题描述
　　1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
输出格式
　　按从小到大的顺序输出满足条件的四位十进制数。
 */
public class BASIC_08_回文数 {
	public static void main(String[] args) {
		for(int i = 1001; i <=9999; i++){
			int a = i/1000, b = i%1000/100, c = i%100/10, d = i%10;
			if(a==d && b==c){
				System.out.println(i);
			}
		}
	}
}
