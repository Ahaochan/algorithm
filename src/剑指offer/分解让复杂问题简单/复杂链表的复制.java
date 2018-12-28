package 剑指offer.分解让复杂问题简单;

/**
 * https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 解题思路：
 * 看注释
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/剑指 offer 题解.md
 */
public class 复杂链表的复制 {
    public static void main(String[] args) {
        复杂链表的复制 main = new 复杂链表的复制();
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2); node1.next = node2;
        RandomListNode node3 = new RandomListNode(3); node2.next = node3;
        RandomListNode node4 = new RandomListNode(4); node3.next = node4;
        RandomListNode node5 = new RandomListNode(5); node4.next = node5;
        node1.random = node3;
        node2.random = node5;
        node3.random = null;
        node4.random = node2;
        node5.random = null;

        RandomListNode clone = main.Clone(node1);
        System.out.println(clone);
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }
        // 1->2->3->4->null


        // 1. 复制自身节点到next节点
        // 1->1->2->2->3->3->4->4->null
        RandomListNode node = pHead;
        while(node != null) {
            RandomListNode next = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = next;
            node = next;
        }

        // 2. 复制随机节点, next 节点的 random 节点, 必定等于当前节点的 random 节点的 next 节点
        // →   →  →  →  →
        // ↑   →  →  →  → →
        // ↑  ↑         ↓ ↓
        // 1->1->2->2->3->3->4->4->null
        node = pHead;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }

        // 3. 分割原有的链表和复制后的链表, 原有链表不恢复原状会AC失败
//        RandomListNode clone = pHead.next, tmp = clone;
//        while(tmp != null){
//            tmp.next = tmp.next == null ? null : tmp.next.next;
//            tmp = tmp.next;
//        }
        node = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(node != null) {
            RandomListNode cloneNode = node.next;

            // 3.1. 跨一个节点连接, node.next = node.next.next
            node.next = node.next.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;

            node = node.next;
        }

        return pCloneHead;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label + "(" + (random == null ? null : random.label) + ")" + "->" + String.valueOf(next);
        }
    }
}
