package com.graph;
import java.util.*;

public class AppendPlusSolution2 {
    public static void main(String[] args) {
        AppendPlus ob = new AppendPlus();
        String input = "123";
        int target = 6;
        char[] res = ob.AppendPlusSign(input, target);
        System.out.println(res);
    }

    private char[] res = null;
    public char[] AppendPlusSign(String input, int target) {
        //sanity check
        if (input == null || input.length() == 0) {
            return res;
        }
        //corner case (加0个括号)
        if (target == Integer.parseInt(input)) {
            return input.toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        backTracking(input, target, sb, 0, 0);
        return res;
    }

    //index: 当前层加的是第几个加号
    private void backTracking(String curInput, int target, StringBuilder sb, int sum, int index) {
        int len = curInput.length();

        //backTracking
        for (int i = index; i < len; i++) {
            //sumOne: part in 'sum' which could be maintained for both cur and higher level
            //sumTwo: part in 'sum' which need to be recovered when go next level recursion
            //calculate cur layer path info
            String sOne = curInput.substring(0, i);
            String sTwo = curInput.substring(i + 1, len);
            int sumOne = Integer.parseInt(sOne);
            int sumTwo = Integer.parseInt(sTwo);
            StringBuilder sbOne = sb.append(sOne);
            StringBuilder sbTwo = sb.append(sTwo);
            sb.append(sTwo);
            sum = sumOne + sumTwo;
            if (sum == target) {
                res = sbTwo.toString().toCharArray();
            }
            //recursion
            String nextInput = curInput.substring(i + 1, len);
            backTracking(nextInput, target, sb, sum, i + 1);
            //recovery
            sb = sbOne;
            sum = sumOne;

        }
    }
}

