package array;
import java.util.*;

public class negativeShortestSubarray {
    public int shortestSubarray(int[] nums, int target) {
        int glbShortest = Integer.MAX_VALUE;

        //preSum preparation
        int sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>(); //preSum ds <preSum, rightMost idx>
        preSum.put(0, -1);

        //BF + memo
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];  //sum calculate preSum[]
            Integer rightMostIdx = preSum.get(sum - target);
            if (rightMostIdx != null) {
                glbShortest = Math.min(glbShortest, j - rightMostIdx);
            }
            preSum.put(sum, j);
        }
        return glbShortest;
    }

    public static void main(String[] args) {
        negativeShortestSubarray ob = new negativeShortestSubarray();
        int[] nums = new int[]{3, 0, -1, -3, 4};
        int target = 0;
        int res = ob.shortestSubarray(nums, target);
        System.out.println(res);
    }
}




