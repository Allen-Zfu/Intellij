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
//public class StackUsingLinkedList {
//    private ListNode head;
//    public StackUsingLinkedList() {
//        head = null;
//    }
//
//    //delete from head
//    public Integer pop() {
//        if (head == null) {
//            return null;
//        }
//        ListNode prev = head;
//        head = head.next;
//        prev.next = null;
//        return prev.value;
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
//    //push from head
//    public void push(Integer ele) {
//        ListNode node = new ListNode(ele);
//        node.next = head;
//        head = node;
//    }
//}
