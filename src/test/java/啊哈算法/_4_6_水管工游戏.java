package 啊哈算法;

import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Ahaochan on 2017/7/17.
 * 最近小哼又迷上一个叫做水管工的游戏。
 * 游戏的大致规则时这样的。
 * 一块矩形土地被分成N*M的单位正方形, 现在这块土地已经埋设有一些水管,
 * 水管将从坐标为(0,0)的矩形土地的左上角左部边缘, 延伸到坐标为(N-1, M-1)的矩形土地右下角右部边缘,
 * 水管只有两种, 直管| 和弯管 |——
 * 每种管道将占据一个单位正方形土地。现在你可以旋转这些管道, 使其构成一个管道系统, 即创造一条从(1,1)到(N,M)的连通管道。
 * 0-3为弯管, 4-5为直管, -1为树木。
 * 输出铺设路径
 *
 */
public class _4_6_水管工游戏 {
    /**
     * 5 4
     4 2 4 2
     0 4 2 -1
     1 2 4 0
     5 0 0 4
     0 4 4 3
     */
    private static final int X = 0, Y = 1;
    private static final int SIDE = 0, OTHER = 1;

    private static int n, m;
    private static int[][] pipe;
    private static boolean[][] mark;
    private static Stack stack;
    private static boolean finished = false;
    // 0左 1上, 2右, 3下
    // verDir[i][0] 表示 当进水口方向为i时, 下一步的x增量, y同理
    private static int[][] verDir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    // verDir[i][0][0] 表示 当进水口方向为i时, i-1和i+1方向的下一步的x增量, y同理
    private static int[][][] bendDir = new int[][][]{
            {{1, 0}, {-1, 0}}, {{0, -1}, {0, 1}}, {{-1, 0}, {1, 0}}, {{0, -1}, {0, 1}}
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        pipe = new int[n][m];
        mark = new boolean[n][m];
        stack = new Stack(n*m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pipe[i][j] = in.nextInt();
            }
        }

        dfs(0,0,0);

        if(!finished){
            System.out.println("impossible");
        }
    }

    // 管型: 0↑→, 1↓→, 2←↓, 3←↑, 4——, 5|
    // 进水方向: 0左 1上, 2右, 3下
    public static void dfs(int x, int y, int before) {
        if(x==n-1 && y==m){
            finished = true;
            System.out.println(stack);
            return;
        }

        if (x < 0 || x >= n || y < 0 || y >= m || mark[x][y] || pipe[x][y]==-1 || finished) {
            return;
        }
        mark[x][y] = true;
        stack.push(x,y);
        // 直管
        if (pipe[x][y] >= 4) {
//            System.out.println(x+","+y+"直管管型为:"+pipe[x][y]+",进水口为"+before);
            dfs(x + verDir[before][X], y + verDir[before][Y], before);
        }
        // 弯管
        else {
//            System.out.println(x+","+y+"弯管管型为:"+pipe[x][y]+",进水口为"+before);
            dfs(x + bendDir[before][SIDE][X], y + bendDir[before][SIDE][Y], (before + 4 + 1) % 4);
            dfs(x + bendDir[before][OTHER][X], y + bendDir[before][OTHER][Y], (before + 4 - 1) % 4);
        }
        stack.pop();
        mark[x][y] = false;
    }

    public static class Stack {
        private Node[] stack;
        private int top;

        public Stack(int size) {
            this.top = 0;
            this.stack = new Node[size];
        }

        public void push(Node node) {
            stack[top++] = node;
        }

        public void push(int x, int y) {
            stack[top++] = new Node(x, y);
        }

        public Node pop() {
            top--;
            Node node = stack[top];
            stack[top] = null;
            return node;
        }

        @Override
        public String toString() {
            return  Stream.of(stack)
                    .filter(Objects::nonNull)
                    .map(Node::toString)
                    .collect(Collectors.joining(","));
        }
    }

    public static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Node node) {
            return x == node.x && y == node.y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }
}
