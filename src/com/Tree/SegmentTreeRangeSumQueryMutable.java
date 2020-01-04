//package com.Tree;
//
//public class SegmentTreeRangeSumQueryMutable {
//    private static class SegmentTreeNode {
//        int start;
//        int end;
//        int sum;
//        SegmentTreeNode left;
//        SegmentTreeNode right;
//
//        public SegmentTreeNode(int st, int en, int sum) {
//            this.start = st;
//            this.end = en;
//            this.sum = sum;
//        }
//    }
//
//    int[] nums;
//    SegmentTreeNode root;
//
//    //class constructor
//    public SegmentTreeRangeSumQueryMutable(int[] nums) {
//        this.nums = new int[nums.length];
//        this.root = buildTree(this.nums, 0, this.nums.length - 1);
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
//        SegmentTreeNode root = new SegmentTreeNode(start, end, leftN.sum + rightN.sum);
//        root.left = leftN;
//        root.right = rightN;
//        return root;
//    }
//
//    //step 2: achive update()
//    //update the node value using the input 'value'
//    public void update(int i, int val) {
//        int diff = nums[i] - val;
//        //sanity check
//        if (diff == 0) {
//            return;
//        }
//        nums[i] = val;
//        update(root, i, diff);
//    }
//
//    private void update(SegmentTreeNode root, int index, int diff) {
//        //index是root在原输入array中的index，即我们在tree中需要uadate的node
//        //diff是要更改的值与原node value的差值
//        if (root == null || index > root.end || index < root.start) {
//            return;
//        }
//        root.sum += diff;
//        update(root.left, int index, int diff);
//        update(root.right, int index, int diff);
//    }
//
//    //step 3: achieve caculate sumRange()
//    public int sumRange(int i, int j) {
//        //sanity check
//        if (root == null || i > j){
//            return 0;
//        }
//        return sumRange(root, i, j);
//    }
//
//    //recursion calculate sum range
//    private int sumRange(SegmentTreeNode root, int start, int end) {
//        //base case:到达左右边界或null
//        if (root == null) {
//            return 0;
//        }
//        if (root.start == start && root.end == end) {
//            return root.sum;
//        }
//        int mid = root.start + (root.end - root.start) / 2;
//        if (mid >= end) {   //go left
//            return sumRange(root.left, start, end);
//        } else if (mid < start) {  //go right
//            return sumRange(root.right, start, end);
//        }
//        //start <= mid < end --> go left and right
//        return sumRange(root.left, start, end) + sumRange(root.right, start, end);
//    }
//}
//
//
//
//
//
//
