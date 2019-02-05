package 剑指offer.举例让抽象具体化;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106
 * 题目描述
 * 输入两个整数序列，
 * 第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 *
 * 解题思路：
 * 模拟入栈出栈即可,
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 栈的压入弹出序列 {
    public static void main(String[] args) {
        栈的压入弹出序列 main = new 栈的压入弹出序列();
        System.out.println(main.IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(main.IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
        System.out.println(main.IsPopOrder(new int[]{1,2,3,4,5}, new int[]{3,5,4,2,1}));
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || pushA.length <= 0) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        for(int pushIdx = 0, popIdx = 0; pushIdx < pushA.length;) {
            // 1. 入栈
            stack.push(pushA[pushIdx]);
            pushIdx++;

            // 2. 出栈, 可能会连续出栈
            while(popIdx < popA.length && stack.peek() == popA[popIdx]) {
                stack.pop();
                popIdx++;
            }
        }

        return stack.isEmpty();
    }
}
