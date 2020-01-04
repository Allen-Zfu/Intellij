package com.graph;
import java.util.*;

public class FactorCombination {
    public static void main(String[] args) {
        FactorCombination ob = new FactorCombination();
        int target = 12;
        List<List<Integer>> res = ob.combinations(target);
//        for (int i = 0; i < res.size(); i++) {
//            List<Integer> list = res.get(i);
//            for (int j = 0; j < list.size(); j++) {
//
//            }
//        }
        for (List<Integer> i : res) {
            System.out.println(i);
        }
    }

    public List<List<Integer>> combinations(int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        backTracking(res, path, target, 2);
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> path, int curTarget, int lastChosen) {
        //base case
        if (curTarget == 1) {
            res.add(new LinkedList<>(path));
            return;
        }
        //multiple branch:
        //add cur Vertex influence into path
        for (int i = 2; i <= Math.min(lastChosen, curTarget); i++) {
            if (curTarget % i == 0) {  //说明i是一个有效因子，加入path
                path.add(i);
            }
            //recursion
            curTarget = curTarget / i;
            lastChosen = i;
            backTracking(res, path, curTarget, lastChosen);
            //recovery
            //path.remove(path.size() - 1);
        }
    }
}
