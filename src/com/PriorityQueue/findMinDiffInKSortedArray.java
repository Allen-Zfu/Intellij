//
//import java.util.*
//
//package com.PriorityQueue;
//
//
//public class findMinDiffInKSortedArray {
//    int glbMin = Integer.MAX_VALUE;
//    int max = Integer.MIN_VALUE;   //the max value in current pq
//    //step 1
//    PriorityQueue<Cell> minHeap = new PriorityQueue<>(new MyComparator());
//
//
//    class Cell {
//        int x;    //in which array
//        int y;    //at which index in cur array
//        int val;
//        public Cell(int x, int y, int val) {
//            this.x = x;
//            this.y = y;
//            this.val = val;
//        }
//    }
//
//    class MyComparator implements Comparator<Cell> {
//        @Override
//        public int compare(Cell o1, Cell o2) {
//            return o1.compareTo(o2);
//        }
//    }
//
//}
