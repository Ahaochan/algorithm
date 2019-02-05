package 蓝桥杯.基础练习;

import java.util.Formatter;
import java.util.Scanner;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T59
 * @author Ahaochan
 * 问题描述
　　平面上有两个矩形，它们的边平行于直角坐标系的X轴或Y轴。对于每个矩形，我们给出它的一对相对顶点的坐标，请你编程算出两个矩形的交的面积。
输入格式
　　输入仅包含两行，每行描述一个矩形。
　　在每行中，给出矩形的一对相对顶点的坐标，每个点的坐标都用两个绝对值不超过10^7的实数表示。
输出格式
　　输出仅包含一个实数，为交的面积，保留到小数后两位。
样例输入
1 1 3 3
2 2 4 4
样例输出
1.00

 */
public class BASIC_18_矩形面积交 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Rectangle r1 = new Rectangle(in.nextDouble(),in.nextDouble(),in.nextDouble(),in.nextDouble());
		Rectangle r2 = new Rectangle(in.nextDouble(),in.nextDouble(),in.nextDouble(),in.nextDouble());
		double x = r1.getX(r2);
		double y = x!=0?r1.getY(r2):0;
		// 格式化输出
		System.out.println(x+"*"+y+"="+new Formatter().format("%.2f", x*y));
	}
	
	// 模拟
	public static class Rectangle{
		public double top,down,left,right;
		public Rectangle(double x1, double y1, double x2, double y2){
			top = Math.max(y1, y2);
			down = Math.min(y1, y2);
			left = Math.min(x1, x2);
			right = Math.max(x1, x2);
		}
		
		public double getX(Rectangle r){
			if(right<r.right && left>r.left){
				return right-left;
			}else if(right>r.right && left<r.left){
				return r.right-r.left;
			}
			
			if(right<r.left){
				return 0;
			} else if(left<r.left){
				return Math.abs(left-r.left);
			} else if(left<r.right){
				return Math.abs(left-r.right);
			} else {
				return 0;
			}
		}
		
		public double getY(Rectangle r){
			if(top<r.top && down>r.down){
				return top-down;
			}else if(top>r.top && down<r.down){
				return r.top-r.down;
			}
			
			if(down>r.top){
				return 0;
			} else if(top>r.top){
				return Math.abs(top-r.top);
			} else if(top>r.down){
				return Math.abs(top-r.down);
			} else {
				return 0;
			}
		}
	}
}
