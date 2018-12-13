package 剑指offer.字符串;

/**
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 解题思路：
 * 从前往后扫, 找到空格则后面的字符串后移2位, 然后替换原来的空格为%20
 *
 * 看了网上的解法
 * 先判断有多少个空格, 然后扩容字符串
 * 比如[We Are Happy]有3个空格, 字符串长度为12, 扩容为[We Are Happy....], 字符串长度为14, n个空格就追加2n个点.
 *
 * 然后从后往前扫, 两个指针分别指向原字符串尾和新字符串尾
 * [We Are Happy....]
 *             ^   ^
 * 这样就可以一次就把字符串复制到位
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 */
public class 替换空格 {
    public static String replaceSpace(StringBuffer str) {
        // 1. 先判断有多少个空格, 然后扩容字符串
        int oldEnd = str.length() - 1;
        for(int i = 0, len = str.length(); i < len; i++) {
            if(str.charAt(i) == ' ') {
                str.append("..");
            }
        }

        // 2. 从后往前扫, 两个指针分别指向原字符串尾和新字符串尾
        int newEnd = str.length() - 1;
        while(oldEnd >= 0) {
            char ch = str.charAt(oldEnd);
            oldEnd--;
            // 2.1. 如果不是空格, 则复制原字符到末尾
            if(ch != ' '){
                str.setCharAt(newEnd--, ch);
            }
            // 2.2. 如果是空格, 则加入 %20
            else {
                str.setCharAt(newEnd--, '0');
                str.setCharAt(newEnd--, '2');
                str.setCharAt(newEnd--, '%');
            }
        }
        return str.toString();
    }
}
