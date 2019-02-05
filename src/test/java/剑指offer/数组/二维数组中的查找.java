package 剑指offer.数组;

/**
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 解题思路：
 * 自己的思路, 从左上角开始, 做深搜走迷宫, 太复杂了.
 *
 * 看了网上的解法, 从右上角开始, 那么就有个不等式
 * array[row][col-1] < array[row][col] < array[row+1][col]
 * 化成了一个二叉查找树
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 */
public class 二维数组中的查找 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        int rowLen = array.length;
        int row = 0, col = array[0].length - 1;
        while (row < rowLen && col >= 0) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
