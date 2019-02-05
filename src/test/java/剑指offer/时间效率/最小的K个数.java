package 剑指offer.时间效率;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 解题思路：
 * 最简单的办法, 排序取前k个数
 *
 * 或者用最大堆
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 最小的K个数 {
    public static void main(String[] args) {
        最小的K个数 main = new 最小的K个数();
        long start = System.currentTimeMillis();

        System.out.println(main.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 4));
        System.out.println(main.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 0));

        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input == null || input.length <= 0 || k <= 0 || k > input.length) {
            return new ArrayList<>(0);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (o1, o2) -> (o2.compareTo(o1))); // 生成最大堆使用o2-o1,生成最小堆使用o1-o2, 并修改 e.compareTo(peek) 比较规则
        for(int i = 0; i < input.length; i++) {
            if(i < k) {
                // 1. 先填满最大堆
                minHeap.add(input[i]);
            } else {
                // 2. 每次都和堆顶最大值比较, 小于则弹出堆顶元素并重新插入, 避免最大堆的内存占用过大
                int min = minHeap.peek(); // 取出最小堆堆顶
                if(min > input[i]) {
                    minHeap.poll();
                    minHeap.add(input[i]);
                }
            }
        }
        return new ArrayList<>(minHeap);
    }
}
