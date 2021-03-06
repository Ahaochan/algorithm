package 蓝桥杯.第八届蓝桥杯javaB组;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class _07_日期问题 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] dateStr = in.next().split("/");/** 用/分割字符串  */
		int[] date = new int[dateStr.length];
		for(int i = 0; i < date.length; i++){/** 转化为int数组  */
			date[i] = Integer.parseInt(dateStr[i]);
		}
		
		check(date[0] ,date[1],date[2]);
		check(date[2] ,date[0],date[1]);
		check(date[2] ,date[1],date[0]);
	}
	
	private static void check(int year, int month, int date){
		try{
			Calendar c = Calendar.getInstance();
			c.setLenient(false);
			
			if(year>=60) year += 1900;
			else year += 2000;
		
			c.set(year, month-1, date);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(sdf.format(c.getTime()));
		} catch(Exception e){
			
		}
	}
}
/**
 * 小明正在整理一批历史文献。这些历史文献中出现了很多日期。小明知道这些日期都在1960年1月1日至2059年12月31日。令小明头疼的是，这些日期采用的格式非常不统一，有采用年/月/日的，有采用月/日/年的，还有采用日/月/年的。更加麻烦的是，年份也都省略了前两位，使得文献上的一个日期，存在很多可能的日期与其对应。
比如02/03/04，可能是2002年03月04日、2004年02月03日或2004年03月02日。
给出一个文献上的日期，你能帮助小明判断有哪些可能的日期对其对应吗？

输入
一个日期，格式是”AA/BB/CC”。 (0 <= A, B, C <= 9)

输出
输出若干个不相同的日期，每个日期一行，格式是”yyyy-MM-dd”。多个日期按从早到晚排列

输入
02/03/04

样例输出
2002-03-04
2004-02-03
2004-03-02
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗 < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入…” 的多余内容。
*/
