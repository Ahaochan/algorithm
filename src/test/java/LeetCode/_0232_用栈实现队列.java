package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 题目描述:
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * 解题思路
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
 */
public class _0232_用栈实现队列 {

    @Test
    public void test() {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        Assert.assertEquals(1, queue.peek());
        Assert.assertEquals(1, queue.pop());
        Assert.assertFalse(queue.empty());
    }

    class MyQueue {
        private Stack<Integer> push;
        private Stack<Integer> pop;

        /** Initialize your data structure here. */
        public MyQueue() {
            push = new Stack<>();
            pop = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            push.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(pop.size() == 0) {
                while (push.size() > 0) {
                    pop.push(push.pop());
                }
            }
            return pop.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(pop.size() == 0) {
                while (push.size() > 0) {
                    pop.push(push.pop());
                }
            }
            return pop.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return push.size() + pop.size() <= 0;
        }
    }
}
