package 啊哈算法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ahaochan on 2017/7/11.
 *
 * 迷宫由n行m列组成，每个单元格要么是空地，要么是障碍物。
 * 你的任务是帮助小哼找到一条从迷宫的起点通往小哈所在位置的最短路径
 */
public class _4_3_解救小哈 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] map = new int[n][m];
        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = in.nextInt();
            }
        }
        Node start = new Node(in.nextInt(), in.nextInt());
        Node end = new Node(in.nextInt(), in.nextInt());
        map[start.x][start.y] = 0;

        Queue queue = new Queue(n*m);
        while(!start.equals(end)){
            for (int[] d : dir) {
                int x = start.x + d[0];
                int y = start.y + d[1];

                if (x >= 0 && x < n && y >= 0 && y < m && map[x][y]==0) {
                    map[x][y] = map[start.x][start.y]+1;
                    queue.push(x, y);
                }
            }
            start = queue.pop();
        }

        System.out.println(map[end.x][end.y]);
    }

    public static class Queue{
        private Node[] queue;
        int head, tail;
        public Queue(int size){
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
