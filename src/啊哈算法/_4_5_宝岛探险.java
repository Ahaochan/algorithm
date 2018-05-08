package 啊哈算法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ahaochan on 2017/7/17.
 * 有一个n行m列的钓鱼岛航拍地图, 图中数字表示海拔,
 * 0表示海洋, 1~9都表示陆地, 小哼的飞机将会降落在(x,y)处,
 * 现在需要计算出小哼降落地所在的岛的面积, 即有多少个格子.
 */
public class _4_5_宝岛探险 {

    /**
     * 10 10 6 8
     1 2 1 0 0 0 0 0 2 3
     3 0 2 0 1 2 1 0 1 2
     4 0 1 0 1 2 3 2 0 1
     3 2 0 0 0 1 2 4 0 0
     0 0 0 0 0 0 1 5 3 0
     0 1 2 1 0 1 5 4 3 0
     0 1 2 3 1 3 6 2 1 0
     0 0 3 4 8 9 7 5 0 0
     0 0 0 3 7 8 6 0 1 2
     0 0 0 0 0 0 0 0 1 0
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int startX = in.nextInt(), startY = in.nextInt();
        int[][] land = new int[n][m];
        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                land[i][j] = in.nextInt();
            }
        }

        Queue queue = new Queue(n*m);
        Node start = new Node(startX, startY);
        queue.push(start);
        land[startX][startY] = -1;
        int num = 1;
        while(!queue.isEmpty()){
            for (int[] d : dir) {
                int x = start.x + d[0];
                int y = start.y + d[1];

                if (x >= 0 && x < n && y >= 0 && y < m && land[x][y]>0) {
                    land[x][y] = -1;
                    num++;
                    queue.push(x, y);
                }
            }
            start = queue.pop();
        }
//        for(int i = 0; i < land.length; i++){
//            for(int j = 0; j < land[i].length; j++){
//                System.out.print(land[i][j]+" ");
//            }
//            System.out.println("");
//        }
        System.out.println(num);

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

        public boolean isEmpty(){
            return head == tail;
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
