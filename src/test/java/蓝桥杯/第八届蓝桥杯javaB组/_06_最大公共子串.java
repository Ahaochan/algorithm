package 蓝桥杯.第八届蓝桥杯javaB组;

//a[i-1][j-1]+1
public class _06_最大公共子串 {
	static int f(String s1, String s2)  
    {  
        char[] c1 = s1.toCharArray();  
        char[] c2 = s2.toCharArray();  
        int[][] a = new int[c1.length+1][c2.length+1];  
        int max = 0;  
        for(int i=1; i<a.length; i++){  
            for(int j=1; j<a[i].length; j++){  
                if(c1[i-1]==c2[j-1]) {  
                    a[i][j] = a[i-1][j-1]+1;  //填空  
                    if(a[i][j] > max) max = a[i][j];  
                }  
            }  
        }
        
        printf(a);
        return max;  
    }  
    public static void main(String[] args){  
        int n = f("abcdkkk", "baabcdadabc");  
        System.out.println(n);  
    }  
    
    private static void printf(int[][]arr){
    	for(int i = 0; i < arr.length; i++){
    		for(int j = 0; j < arr[i].length; j++){
    			System.out.print(arr[i][j]+" ");
    		}
    		System.out.println("");
    	}
    	System.out.println("");
    }

}
/**
 * 最大公共子串长度问题就是：
求两个串的所有子串中能够匹配上的最大长度是多少。
比如："abcdkkk" 和 "baabcdadabc"，
可以找到的最长的公共子串是"abcd",所以最大公共子串长度为4。
请分析该解法的思路，并补全划线部分缺失的代码。
*/
