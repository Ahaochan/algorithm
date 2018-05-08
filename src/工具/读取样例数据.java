package 工具;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 读取样例数据 {
	public static void main(String[] args) {
		String path = "C:\\Users\\Avalon\\Desktop\\蓝桥杯练习系统vip题目和测试数据\\蓝桥杯题目和测试数据\\基础训练\\"
				+ "报时助手";
		getInput(path);
		getOutput(path);
	}
	public static void getInput(String filePath){
		System.out.println("input:");
		File f = new File(filePath);
		File[] files = f.listFiles();
		for(int i = 0; i < files.length; i++){
			if(files[i].getName().startsWith("input")){
//				System.out.print(files[i].getName()+":");
				StringBuffer buffer = new StringBuffer();
				readToBuffer(buffer, files[i].getAbsolutePath());
				System.out.print(buffer);
			}
		}
	}
	
	public static void getOutput(String filePath){
		System.out.println("output:");
		File f = new File(filePath);
		File[] files = f.listFiles();
		for(int i = 0; i < files.length; i++){
			if(files[i].getName().startsWith("output")){
				StringBuffer buffer = new StringBuffer();
				readToBuffer(buffer, files[i].getAbsolutePath());
				System.out.print(buffer);
			}
		}
	}
	
	
	public static void readToBuffer(StringBuffer buffer, String filePath){
        try(InputStream is = new FileInputStream(filePath);
        	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                ){
        	String line; // 用来保存每行读取的内容
        	line = reader.readLine(); // 读取第一行
        	while (line != null) { // 如果 line 为空说明读完了
        		buffer.append(line); // 将读到的内容添加到 buffer 中
        		buffer.append("\n"); // 添加换行符
        		line = reader.readLine(); // 读取下一行
        	}
        } catch(Exception e){
        	e.printStackTrace();
        }
    }
}
