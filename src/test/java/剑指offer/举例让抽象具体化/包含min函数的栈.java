package 剑指offer.举例让抽象具体化;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 *
 * 解题思路：
 * 用一个辅助栈来存储最小值, 但是这个辅助栈不需要进行排序(这是重点)
 * 如: 存入 4 5 2 1
 *
 * push 4
 * stack: 4
 * min:   4
 *
 * push 5
 * stack: 4 5
 * min:   4 4 (这里不存5, 而是存4, 因为最小值是4, 就算pop, 也会回到上面的状态)
 *
 * push 2
 * stack: 4 5 2
 * min:   4 4 2
 *
 * push 1
 * stack: 4 5 2 1
 * min:   4 4 2 1
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 包含min函数的栈 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
        stack.push(node);
        min.push(min.isEmpty() ? node : Math.min(node, min.peek()));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
