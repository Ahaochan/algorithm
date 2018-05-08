package 工具;

import java.util.Arrays;

/**
 * Created by Ahaochan on 2017/7/21.
 */
public class 队列 {
    private Node[] queue;
    int head, tail;
    public 队列(int size){
        this.head = 0;
        this.tail = 0;
        this.queue = new Node[size];
    }

    public void push(Node node){
        queue[tail++] = node;
    }

    public void push(int x, int y){
        queue[tail++] = new Node(x, y);
    }

    public Node pop(){
        Node node = queue[head];
        queue[head] = null;
        head++;
        return node;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }

    public static class Node{
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Node node) {
            return x==node.x && y==node.y;
        }

        @Override
        public String toString() {
            return "["+x+","+y+"]";
        }
    }
}
