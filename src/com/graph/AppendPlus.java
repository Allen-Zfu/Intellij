package com.graph;
import java.util.*;

public class AppendPlus {
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
        StringBuilder sb = new StringBuilder();
	    sb.append(input.charAt(0));
	    backTracking(input, target, sb, 1);
	    return res;
    }

    private void backTracking(String input, int target, StringBuilder sb, int index) {
        //base case…..(calculate sum at leaf node)
        if (index == input.length()) {
            String s = sb.toString();
            int sum = 0;
            int subSum = 0;
            int i = 0;
            while (i < s.length()) {
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    subSum = subSum * 10 + s.charAt(i) - '0';
                    i++;
                }
                sum = sum + subSum;
                if (sum == target) {
                    res = s.toCharArray();
                }
                subSum = 0;
                i++;
            }
            return;
        }

        //pick element branch
        sb.append('+');
        sb.append(input.charAt(index));
        backTracking(input, target, sb, index + 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        //not pick element branch
        sb.append(input.charAt(index));
        backTracking(input, target, sb, index + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}





