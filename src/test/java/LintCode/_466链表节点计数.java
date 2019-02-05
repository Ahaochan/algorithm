package LintCode;

/**
 * https://www.lintcode.com/problem/count-linked-list-nodes/
 * 466. 链表节点计数
 * 描述
 * 计算链表中有多少个节点.
 * 样例
 * 给出 1->3->5, 返回 3.
 */
public class _466链表节点计数 {
    public int countNodes(ListNode head) {
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
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
