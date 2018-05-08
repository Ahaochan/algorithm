package LintCode;

/**
 * https://www.lintcode.com/problem/remove-linked-list-elements
 * 描述
 * 删除链表中等于给定值val的所有节点。
 *
 * 样例
 * 给出链表 1->2->3->3->4->5->3, 和 val = 3, 你需要返回删除3之后的链表：1->2->4->5。
 */
public class _452删除链表中的元素 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        removeElements(node1, 3);

        System.out.println(node1.toString());
    }

    /**
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public static ListNode removeElements(ListNode head, int val) {
        // 1. 排除val相同的前驱节点
        while(head!=null && head.val == val){
            head = head.next;
        }
        // 2. 记录第一个不同val的节点
        ListNode result = head;

        // 3. 往后删除相同val的节点
        while(head!=null){
            ListNode next = head.next;
            if(next != null && next.val == val){
                head.next = next.next;
            } else {
                head = head.next;
            }

        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(String.valueOf(val));
            if(next != null){
                sb.append("->").append(next.toString());
            }
            return sb.toString();
        }
    }
}
