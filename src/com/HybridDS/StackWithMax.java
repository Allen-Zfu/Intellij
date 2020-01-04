//package com.HybridDS;
//import java.util.*;
//
////init DDL node class
//class ListNode {
//    int value;
//    ListNode prev;
//    ListNode next;
//    public ListNode(int value) {  //constructor
//        this.value = value;
//    }
//}
//
//public class StackWithMax {
//    public static void main(String[] args) {
//        StackWithMax ob = new StackWithMax();
//        ob.push(1);
//        ob.push(3);
//        ob.push(2);
//        ob.push(3);
//        Integer r1 = ob.max();
//        Integer r2 = ob.popMax();
//        Integer r3 = ob.popMax();
//        Integer r4 = ob.max();
//        System.out.println(r1);
//        System.out.println(r2);
//        System.out.println(r3);
//        System.out.println(r4);
//    }
//
//    //init TreeMap
//    TreeMap<Integer, List<ListNode>> map;
//    ListNode head;
//    ListNode tail;
//    StackWithMax() {     //constructor
//        this.map = new TreeMap<>();
//
//       //ddl : dummy head + dummy tail , init empty ddl
//        this.head = new ListNode(-1);
//        this.tail = new ListNode(-1);
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    public ListNode push(int value) {
//        //add into dll
//        ListNode newNode = insertTail(value);
//        ///add into map
//        if (!map.containsKey(value)) {
//            List<ListNode> newList = new ArrayList<>();
//            newList.add(newNode);
//            map.put(value, newList);
//        } else {
//            List<ListNode> newList = map.get(value);
//            newList.add(newNode);
//            map.put(value, newList);
//        }
//        return newNode;
//    }
//
//    //pop 'value' from stack
//    public Integer pop(int value) {
//        List<ListNode> list = map.get(value);
//        ListNode popNode = list.get(list.size() - 1);
//        list.remove(list.size() - 1);
//        deleteNode(popNode);
//        return popNode.value;
//    }
//
//    //pop cur max value from stack
//    public Integer popMax() {
//        int max = map.lastKey();
//        List<ListNode> list = map.get(max);
//        ListNode popNode = list.remove(list.size() - 1);
//        deleteNode(popNode);
//        if (list.isEmpty()) {
//            map.remove(max);
//        }
//        return popNode.value;
//    }
//
//    ///find cur max value in stack
//    public Integer max() {
//        //System.out.println(map.size());
//        return map.lastKey();
//    }
//
//    //return newHead
//    private ListNode insertTail(int value) {    //保证head和tail始终在两端,默认insert在head端
//        ListNode newNode = new ListNode(value);
//        newNode.prev = tail.prev;
//        tail.prev = newNode;
//        return newNode;
//    }
//
//    private void deleteNode(ListNode node) {
//        if (tail.prev == head) {
//            throw new NoSuchElementException();
//        }
//        node.next.prev = node.prev;
//        node.prev.next = node.next;
//    }
//}
//
//
//
//
//
//
//
