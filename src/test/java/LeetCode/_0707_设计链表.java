package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/design-linked-list/submissions/
 * 题目描述:
 * 设计链表的实现。您可以选择使用单链表或双链表。
 * 单链表中的节点应该具有两个属性：val 和 next。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 解题思路
 * 主要问题是处理dirty case
 * 维护头尾指针会比较快
 */
public class _0707_设计链表 {
    @Test
    public void test1() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2); // 1->2->3->null
        Assert.assertEquals(2, linkedList.get(1));
        linkedList.deleteAtIndex(1);  // 1->3->null
        Assert.assertEquals(3, linkedList.get(1));
    }

    @Test
    public void test2() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtIndex(1,2);   // 1->2->null
        Assert.assertEquals(2, linkedList.get(1));
        Assert.assertEquals(1, linkedList.get(0));
        Assert.assertEquals(-1, linkedList.get(2));
    }

    @Test
    public void test3() {
        MyLinkedList linkedList = new MyLinkedList();
        Assert.assertEquals(-1, linkedList.get(0));
        linkedList.addAtIndex(1,2);
        Assert.assertEquals(-1, linkedList.get(0));
        Assert.assertEquals(-1, linkedList.get(1));
        linkedList.addAtIndex(0,1); // 1->null
        Assert.assertEquals(1, linkedList.get(0));
        Assert.assertEquals(-1, linkedList.get(1));
    }

    @Test
    public void test4() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2); // 1->2->3->null
        Assert.assertEquals(2, linkedList.get(1));
        linkedList.deleteAtIndex(0);  // 2->3->null
        Assert.assertEquals(2, linkedList.get(0));
    }

    @Test
    public void test5() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(0,10);
        linkedList.addAtIndex(0,20);
        linkedList.addAtIndex(1,30); // 20->30->10->null
        Assert.assertEquals(20, linkedList.get(0));
    }

    @Test
    public void test6() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2); // 1->2->3->null
        Assert.assertEquals(-1, linkedList.get(-1));
        linkedList.deleteAtIndex(1);  // 1->3->null
        Assert.assertEquals(-1, linkedList.get(-3));
    }

    @Test
    public void test7() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(-1,0);
        Assert.assertEquals(0, linkedList.get(0));
        linkedList.deleteAtIndex(-11);
    }

    @Test
    public void test8() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(4,2); // 1->3->null
        Assert.assertEquals(3, linkedList.get(1));
        linkedList.deleteAtIndex(-1);  // 1->3->null
        Assert.assertEquals(3, linkedList.get(1));
    }

    @Test
    public void test9() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(8); // 8->null
        Assert.assertEquals(-1, linkedList.get(1));
        linkedList.addAtTail(81);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(26);
        linkedList.deleteAtIndex(2); // 26->8->null
        Assert.assertEquals(8, linkedList.get(1));
        linkedList.addAtTail(24);
        linkedList.addAtHead(15);
        linkedList.addAtTail(0);
        linkedList.addAtTail(13);
        linkedList.addAtTail(1); // 15->26->8->24->0->13->1->null
        linkedList.addAtIndex(6,33); // 15->26->8->24->0->13->33->1->null
        Assert.assertEquals(33, linkedList.get(6));
        linkedList.addAtIndex(2,91);
        linkedList.addAtHead(82);
        linkedList.deleteAtIndex(6);
        linkedList.addAtIndex(4,11);
        linkedList.addAtHead(3);
        linkedList.addAtIndex(7,14);
        linkedList.deleteAtIndex(1);
        linkedList.get(6);
        linkedList.addAtTail(99);
        linkedList.deleteAtIndex(11);
        linkedList.deleteAtIndex(7);
        linkedList.addAtTail(5);
        linkedList.addAtTail(92);
        linkedList.addAtIndex(7,92);
        linkedList.addAtHead(57);
        linkedList.get(2);
        linkedList.get(6);
        linkedList.addAtTail(39);
        linkedList.addAtTail(51);
        linkedList.addAtTail(3);
        linkedList.addAtTail(22);
        linkedList.addAtIndex(5,26);
        linkedList.addAtIndex(9,52);
        linkedList.addAtHead(69);
        linkedList.addAtIndex(5,58);
        linkedList.addAtTail(79);
        linkedList.addAtHead(7);
        linkedList.addAtHead(41);
        linkedList.addAtHead(33);
        linkedList.addAtHead(88);
        linkedList.addAtHead(44);
        linkedList.addAtHead(8);
        linkedList.addAtTail(72);
        linkedList.addAtHead(93);
        linkedList.deleteAtIndex(18);
        linkedList.addAtHead(1);
        linkedList.get(9);
        linkedList.addAtHead(46);
        linkedList.get(9);
        linkedList.addAtHead(92);
        linkedList.addAtHead(71);
        linkedList.addAtHead(69);
        linkedList.addAtIndex(11,54);
        linkedList.deleteAtIndex(27);
        linkedList.addAtTail(83);
        linkedList.deleteAtIndex(12);
        linkedList.get(20);
        linkedList.addAtIndex(19,97);
        linkedList.addAtHead(77);
        linkedList.addAtTail(36);
        linkedList.deleteAtIndex(3);
        linkedList.addAtHead(35);
        linkedList.addAtIndex(16,68);
        linkedList.deleteAtIndex(22);
        linkedList.deleteAtIndex(36);
        linkedList.deleteAtIndex(17);
        linkedList.addAtHead(62);
        linkedList.addAtTail(89);
        linkedList.addAtTail(61);
        linkedList.addAtHead(6);
        linkedList.addAtTail(92);
        linkedList.addAtIndex(28,69);
        linkedList.deleteAtIndex(23);
        linkedList.deleteAtIndex(28);
        linkedList.addAtIndex(7,4);
        linkedList.addAtHead(0);
        linkedList.addAtHead(24);
        linkedList.addAtTail(52);
        linkedList.get(1);
        linkedList.addAtIndex(23,3);
        linkedList.get(7);
        linkedList.addAtHead(6);
        linkedList.addAtHead(68);
        linkedList.addAtHead(79);
        linkedList.addAtIndex(45,90);
        linkedList.addAtIndex(41,52);
        linkedList.get(28);
        linkedList.addAtHead(25);
        linkedList.get(9);
        linkedList.get(32);
        linkedList.addAtTail(11);
        linkedList.addAtHead(90);
        linkedList.addAtHead(24);
        linkedList.addAtTail(98);
        linkedList.addAtTail(36);
        linkedList.get(34);
        linkedList.addAtTail(26);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23321301/
     * 执行用时 :122 ms, 在所有 Java 提交中击败了53.59%的用户
     * 内存消耗 :48.3 MB, 在所有 Java 提交中击败了56.50%的用户
     */
    class MyLinkedList {
        class Node {
            int val;
            Node next;
            Node(int val, Node next) { this.val = val; this.next = next; }
            public String toString() { return val + "->" + String.valueOf(next); }
        }

        Node head;
        Node tail;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = new Node(0, null); // 头指针保存列表长度
            tail = head;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index < 0 || index >= head.val) {
                return -1;
            }
            return getPred(index).next.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            if(head.val == 0) {
                addAtTail(val);
            } else {
                addAfter(head, val);
            }
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            addAfter(tail, val);
            tail = tail.next;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index < 0) {
                addAtHead(val);
            } else if (index == head.val) {
                addAtTail(val);
            } else if(index < head.val){
                addAfter(getPred(index), val);
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index < 0 || index >= head.val) {
                return;
            }
            Node pred = getPred(index);
            if(index == head.val - 1) {
                tail = pred;
            }
            pred.next = pred.next.next;
            head.val--;
        }

        private Node getPred(int index) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        private void addAfter(Node pred, int val) {
            pred.next = new Node(val, pred.next);
            head.val++;
        }

        @Override
        public String toString() {
            return String.valueOf(head);
        }
    }


    /**
     * https://leetcode-cn.com/submissions/detail/23315619/
     * 执行用时 :136 ms, 在所有 Java 提交中击败了8.60%的用户
     * 内存消耗 :47.2 MB, 在所有 Java 提交中击败了75.53%的用户
     */
    class MyLinkedList_My {
        class Node {
            int val;
            Node next;
            Node(int val, Node next) { this.val = val; this.next = next; }
            public String toString() { return val + "->" + String.valueOf(next); }
        }

        Node head;

        /** Initialize your data structure here. */
        public MyLinkedList_My() {

        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index < 0) {
                return -1;
            }

            Node node = head;
            for (int i = 0; i < index && node != null; i++) {
                node = node.next;
            }
            return node == null ? -1 : node.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            if(head == null) {
                head = new Node(val, null);
            } else {
                Node tail = head;
                head = new Node(val, tail);
            }
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            if(head == null) {
                head = new Node(val, null);
            } else {
                Node node = head;
                while (node.next != null) {
                    node = node.next;
                }
                node.next = new Node(val, null);
            }
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(head == null && index > 0) {
                return;
            } else if(head == null || index <= 0) {
//            } else if(head == null || index == 0) {
                head = new Node(val, head);
                return;
            }

            Node node = head;
            for (int i = 1; i < index; i++) {
                node = node.next;
                if(node == null) {
                    return;
                }
            }
            Node tail = node.next;
            node.next = new Node(val, tail);
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(head == null || index < 0) {
                return;
            }
            if(index == 0) {
                head = head.next;
                return;
            }

            Node node = head;
            for (int i = 1; i < index; i++) {
                node = node.next;
                if(node == null) {
                    return;
                }
            }
            if(node.next != null) {
                node.next = node.next.next;
            }
        }

        @Override
        public String toString() {
            return String.valueOf(head);
        }
    }
}
