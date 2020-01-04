package com.graph;
import java.util.*;

public class FindStringPattern {
    public static void main(String[] args) {
        FindStringPattern ob = new FindStringPattern();
         //11223344 --> 23421314 -->true
        System.out.println(ob.existPattern("11223344"));
    }

    public boolean existPattern(String input) {
        char[] array = input.toCharArray();
        boolean[] res = new boolean[1];
        Map<Character, Integer> map = new HashMap<>();
        return dfs(array, 0, res, map);
        //return res[0];
    }
    //backtracking
    //index: 表示recursion当前层正在处理到了原输入中哪个index的元素
    //当前层所做事情：判断（从index到array.length的所有元素）是否能够交换到index这个位置上来
    private boolean dfs(char[] array, int index, boolean[] res, Map<Character, Integer> map) {
        //base case
        if (index == array.length) {
            //System.out.println(new String(array));
            //res[0] = true;
            return true;
        }
        //try all branches :  cur vertex: array[i]  , cur path : HashMap, array
        // (i --> all available candidate position have chance to be swapped at cur layer)
        //i range: [index, end of the input array]
        //System.out.println("index is : " index + );
        for (int i = index; i <= array.length - 1; i++) {
            //case 1: array[i] never be used before, can be swapped to 'index' position
            if (map.get(array[i]) == null) {
                //add cur vertex influence
                map.put(array[i], 1);
                swap(array, index, i);
                //recursion
                boolean flag = dfs(array, index + 1, res, map);
                if (flag) {
                    return true;
                }
                //recovery
                swap(array, index, i);
                map.remove(array[i]);
            } else if (map.get(array[i]) == 1) {
                //case 2: map.get(array[i]) == 1,说明array[i]已经在前面出现了一次
                //现在只有index左边对于位置不越界+  (index左边对应位置不越界 == array
                int leftPos = index - ((array[i]-'0') + 1);
                if (leftPos >= 0 && (array[leftPos] - '0') == (array[i]) - '0') {
                    //add cur vertex influence
                    map.put(array[i], 2);
                    swap(array, index, i);
                    //recursion
                    boolean flag = dfs(array, index + 1, res, map);
                    if (flag) {
                        return true;
                    }
                    //recovery
                    swap(array, index, i);
                    map.put(array[i], 1);
                }
            }
        }
        return false;
    }

    private void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
