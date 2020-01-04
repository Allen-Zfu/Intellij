package com.graph;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CombinationSumI {
    public static void main(String[] args) {
        CombinationSumI ob = new CombinationSumI();
        int[] candidates = new int[]{1, 2, 3};
        int target = 3;
        List<List<Integer>> res = ob.combinationSum(candidates, target);
        System.out.println(res);
        //JAVA可以直接打印二维list：
//        List<List<Integer>> test = new ArrayList<>();
//        List<Integer> testUnit = new ArrayList<>();
//        testUnit.add(1);
//        test.add(testUnit);
//        System.out.println(test);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curRes = new LinkedList<>();
        //sanity check
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        backTracking(0, target, candidates, curRes, res);
        return res;
    }

    private void backTracking(int index, int leftNum, int[] candidates, List<Integer> curRes, List<List<Integer>> res) {
        //base case
        if (leftNum == 0) {
            res.add(new LinkedList<>(curRes));
            return;
        }
        if (index == candidates.length || leftNum < 0) {
            return;
        }
        //travers all branches
        for (int i = index; i < candidates.length - 1; i++) {
            //add cur vertex info into path
            leftNum -= candidates[i];
            curRes.add(candidates[i]);
            backTracking(i+1, leftNum, candidates, curRes, res);
            //recovery
            leftNum += candidates[i];
            curRes.remove(curRes.size() - 1);
        }
    }
}



