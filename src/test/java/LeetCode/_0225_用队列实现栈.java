package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * 题目描述:
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 注意:
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 解题思路
 * 
 */
public class _0225_用队列实现栈 {

    @Test
    public void test() {
        MyStack stack = new MyStack();
        Assert.assertTrue(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(3, stack.top());
        Assert.assertEquals(3, stack.pop());
        Assert.assertFalse(stack.empty());
        Assert.assertEquals(2, stack.top());
        stack.push(4);
        Assert.assertEquals(4, stack.top());
        Assert.assertEquals(4, stack.pop());
    }

    private class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            Queue<Integer> queue = queue1.size() > 0 ? queue1 : queue2;
            queue.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            Queue<Integer> queue = queue1.size() > 0 ? queue1 : queue2;
            Queue<Integer> other = queue1.size() > 0 ? queue2 : queue1;

            while (queue.size() > 1) {
                other.add(queue.poll());
            }
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            Queue<Integer> queue = queue1.size() > 0 ? queue1 : queue2;
            Queue<Integer> other = queue1.size() > 0 ? queue2 : queue1;

            while (queue.size() > 1) {
                other.add(queue.poll());
            }
            Integer top = queue.peek();
            other.add(queue.poll());
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.size() + queue2.size() == 0;
        }
    }
}
