//package com.Tree;
//
//public class SegmentTreeRangeMinQuery {
//    private static class SegmentTreeNode {
//        int start;
//        int end;
//        int min;
//        SegmentTreeNode left;
//        SegmentTreeNode right;
//
//        public SegmentTreeNode(int st, int en, int min) {
//            this.start = st;
//            this.end = en;
//            this.min = min;
//        }
//    }
//
//    int[] nums;
//    SegmentTreeNode root;
//
//    //class constructor
//    public SegmentTreeRangeMinQuery(int[] nums) {
//        this.nums = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            this.nums[i] = nums[i];
//        }
//        this.root = buildTree(this.nums, 0, nums.length - 1);
//    }
//
//    //step 1: build the segment tree
//    //recursion build the segmentTree between [start, end] --> pureRecursion
//    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
//        //base case
//        if (start == end) {
//            return new SegmentTreeNode(start, end, nums[start]);
//        }
//        //find mid point whithin range as the pivot point
//        int mid = start + (end - start) / 2;
//        SegmentTreeNode leftN = buildTree(nums, start, mid);
//        SegmentTreeNode rightN = buildTree(nums, mid + 1, end);
//        SegmentTreeNode root = new SegmentTreeNode(start, end, Math.min(leftN.min, rightN.min));
//        root.left = leftN;
//        root.right = rightN;
//        return root;
//    }
//
//    //step 2: achive update()
//    //update the node value using the input 'value'
//    public void update(int i, int val) {   //这道题update直接用value更方便
//        //sanity check
//        if (root.min == val) {
//            return;
//        }
//        nums[i] = val;
//        update(root, i, val);
//    }
//
//    private void update(SegmentTreeNode root, int index, int val) {
//        //index是root在原输入array中的index，即我们在tree中需要uadate的node
//        //diff是要更改的值与原node value的差值
//        //base case
//        if (root == null || index > root.end || index < root.start) {
//            return;
//        }
//        if (root.start == root.end) {
//            root.min = val;
//            return;
//        }
//        update(root.left, int index, int val);
//        update(root.right, int index, int val);
//        root.min = Math.min(root.left.min, root.right.min);
//    }
//
//    //step 3: achieve caculate minQuery()
//    public int minQuery(int i, int j) {
//        //sanity check
//        if (root == null || i > j || i < 0 || j > nums.length){
//            return -1;
//        }
//        return minQuery(root, i, j);
//    }
//
//    //recursion calculate min value within the range
//    private int minQuery(SegmentTreeNode root, int start, int end) {
//        //base case:到达左右边界或null
//        if (root == null) {
//            return 0;
//        }
//        if (root.start == start && root.end == end) {
//            return root.min;
//        }
//        int mid = root.start + (root.end - root.start) / 2;
//        if (mid >= end) {   //go left
//            return minQuery(root.left, start, end);
//        } else if (mid < start) {  //go right
//            return minQuery(root.right, start, end);
//        }
//        //start <= mid < end --> go left and right
//        return Math.min(minQuery(root.left, start, end), minQuery(root.right, start, end));
//    }
//}
