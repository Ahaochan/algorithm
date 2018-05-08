package 工具;

import java.util.Arrays;

/**
 * Created by Ahaochan on 2017/7/21.
 */
public class 栈 {
    private Node[] stack;
    private int top;
    public 栈(int size){
        this.top = 0;
        this.stack = new Node[size];
    }

    public void push(Node node){
        stack[top++] = node;
    }

    public void push(int x, int y){
        stack[top++] = new Node(x, y);
    }

    public Node pop(){
        top--;
        Node node = stack[top];
        stack[top] = null;
        return node;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
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
