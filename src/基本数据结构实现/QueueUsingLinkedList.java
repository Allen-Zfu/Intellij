//package 基本数据结构实现;
//
//class ListNode {
//    int value;
//    ListNode next;
//    public ListNode(int value, ListNode next) {
//        this.value = value;
//        this.next = next;
//    }
//}
//public class QueueUsingLinkedList {
//    ListNode head;
//    ListNode tail;
//    public QueueUsingLinkedList() {
//        head = tail = null;
//    }
//
//    //delete from head
//    public Integer poll() {
//        if (head == null) {
//            return null;
//        }
//        ListNode node = head;
//        head = head.next;
//        if (head == null) {
//            tail = null;
//        }
//        node.next = null;
//        return node.value;
//    }
//
//    //peek from head
//    public Integer peek() {
//        if (head == null) {
//            return null;
//        }
//        return head.value;
//    }
//
//    //insert at head
//    public void offer(Integer ele) {
//        if (head == null) {
//            head = new ListNode(ele);
//            head = tail;
//        } else {
//            tail = new ListNode(ele);
//            tail = tail.next;
//        }
//    }
//}
