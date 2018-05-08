package LintCode;

/**
 * https://www.lintcode.com/problem/hex-conversion/
 * 763. Hex Conversion
 * 描述
 * Given a decimal number n and an integer k, Convert decimal number n to base-k.
 * 给定一个十进制数n和一个整数k，将十进制数n转换为base-k。
 * 1.0<=n<=2^31-1, 2<=k<=16
 * 2.Each letter over 9 is indicated in uppercase
 *
 * 样例
 * Example 1:
 * Given n = 5, k = 2
 * return "101"
 *
 * Example 2:
 * Given n = 30, k = 16
 * return "1E"
 */
public class _763HexConversion {

    public static void main(String[] args) {
        System.out.println(hexConversion(5, 2));
    }
    public static String hexConversion(int n, int k) {
        char[] chars = new char[50];
        // 1. 数据字典
        char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                        'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                        'X', 'Y', 'Z'};

        // 2. 从后往前填充, 短除法
        int index = chars.length - 1;
        while (n >= k) {
            // 2.1. 填充
            chars[index--] = table[n % k];
            n /= k;

            // 2.2. 如果数组不够大, 则扩容
            if(index < 0){
                index = chars.length-1;
                char[] newChars = new char[chars.length*2];
                System.arraycopy(chars, 0, newChars, chars.length, chars.length);
                chars = newChars;
            }
        }
        // 3. 剩下得余数
        chars[index] = table[n];
        // 4. 删除多余空白字符
        return new String(chars).trim();
    }
}
