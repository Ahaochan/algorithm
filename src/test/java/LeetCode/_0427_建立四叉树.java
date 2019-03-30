package LeetCode;

/**
 * https://leetcode-cn.com/problems/construct-quad-tree/comments/
 * 题目描述:
 * 我们想要使用一棵四叉树来储存一个 N x N 的布尔值网络。网络中每一格的值只会是真或假。树的根结点代表整个网络。
 * 对于每个结点, 它将被分等成四个孩子结点直到这个区域内的值都是相同的.
 * 每个结点还有另外两个布尔变量: isLeaf 和 val。isLeaf 当这个节点是一个叶子结点时为真。val 变量储存叶子结点所代表的区域的值。
 * 你的任务是使用一个四叉树表示给定的网络。
 *
 * 解题思路
 * 递归, 每次分割后都遍历4个小方格
 *
 */
public class _0427_建立四叉树 {

    /**
     * 执行用时 : 2 ms, 在Construct Quad Tree的Java提交中击败了100.00% 的用户
     * 内存消耗 : 63.6 MB, 在Construct Quad Tree的Java提交中击败了0.00% 的用户
     */
    public Node construct(int[][] grid) {
        return split(grid, 0, 0, grid.length);
    }
    public Node split(int[][] grid, int x, int y, int len) {
        // 1. 遍历本次的小方格区域
        for(int i = x, lenX = x + len; i < lenX; i++) {
            for(int j = y, lenY = y + len; j < lenY; j++) {
                // 2. 如果区域内的值不统一, 则继续分割
                if(grid[i][j] != grid[x][y]) {
                    return new Node(true, false,
                            split(grid, x, y, len / 2),
                            split(grid, x, y + len / 2, len / 2),
                            split(grid, x + len / 2, y, len / 2),
                            split(grid, x + len / 2, y + len / 2, len / 2));
                }
            }
        }
        // 3. 如果区域内的值统一, 则是叶子节点
        return new Node(grid[x][y] == 1, true, null, null, null, null);
    }


    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}
