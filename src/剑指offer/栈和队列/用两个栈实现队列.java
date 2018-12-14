package 剑指offer.栈和队列;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 解题思路：
 * 比如有两个栈, 一个A作为入队栈, 一个B作为出队栈
 *               :B     A:0 1 2 3 4
 * 因为栈的特性, 要取出0, 则必须把1 2 3 4都取出, 我们把其存入栈B
 * A 的栈顶, 就变成了 B 的栈底
 *      0 1 2 3 4:B     A:
 * 那么可以简化成: 每次 pop  时, 判断B是不是空的, 如果是空的, 就把A全部导出到B, 再取B的第一个数据
 *
 * 这时要 push 5 6 进队列, 等到 0 1 2 3 4 出队完毕后, 又会把 5 6 加入栈B中
 *      0 1 2 3 4:B     A:5 6
 * 那么可以简化成: 每次 push 时, 直接 push 到 A 中
 *
 */
public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        // 每次 push 时, 直接 push 到 stack1入队栈 中
        stack1.push(node);
    }

    public int pop() {
        // 如果出队栈为空, 则把入队栈全部导入出队栈
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
