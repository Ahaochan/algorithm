package 剑指offer.时间效率;

/**
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 解题思路：
 * 攻守阵地的方法
 * 先让第一个数站上擂台, count = 1,
 * 如果下一个数等于第一个数, 那擂台上就有两个相同的数字, count++
 * 如果下一个数不等于台上的数字, 那么擂台上的数字就和攻擂的数字同归于尽, count--
 * 如果count为0则守擂失败, 换下一个数字上台守擂
 *
 * 这次for循环后, count不是正确的数字出现次数
 * 还需要再for一次, 判断count大小
 * 时间复杂度是O(2n)
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 数组中出现次数超过一半的数字 {

    public static void main(String[] args) {
        数组中出现次数超过一半的数字 main = new 数组中出现次数超过一半的数字();
        long start = System.currentTimeMillis();

        System.out.println(main.MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
        System.out.println(main.MoreThanHalfNum_Solution(new int[]{1,2,3,2,4,2,5,2,3}));
        System.out.println(main.MoreThanHalfNum_Solution(new int[]{1,3,4,5,2,2,2,2,2}));

        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start));
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length <= 0) {
            return 0;
        }
        // 1. 守擂, 相同则count+1, count为0则换人
        int num = array[0], count = 1;
        for(int i = 1; i < array.length; i++) {
            count += (num == array[i] ? 1 : -1);
            if(count == 0) {
                num = array[i];
                count = 1;
            }
        }
        // 2. 验证count大小是否超过数组一半
        count = 0;
        for (int i : array) {
            count += (num == i ? 1 : 0);
        }
        return count > array.length / 2 ? num : 0;
    }
}
