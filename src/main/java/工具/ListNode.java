package 工具;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode createLink(int... nums) {
        ListNode head = new ListNode(-1);

        ListNode prev = head;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            prev.next = node;
            prev = node;
        }

        return head.next;
    }

    @Override
    public String toString() {
        return val + "->" + next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
