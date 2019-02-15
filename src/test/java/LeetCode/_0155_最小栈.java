package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * 题目描述:
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 解题思路
 * 每次push都放入两个元素, 当前值和最小值
 */
public class _0155_最小栈 {

    @Test
    public void test1() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.top());
        Assert.assertEquals(-2, minStack.getMin());
    }

    class MinStack {
        Stack<Integer> stack = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int x) {
            Integer top = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
            stack.push(x);
            stack.push(x < top ? x : top);
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            return stack.get(stack.size() - 2);
        }

        public int getMin() {
            return stack.peek();
        }
    }
}
