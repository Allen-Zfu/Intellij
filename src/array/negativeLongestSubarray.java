package array;
import java.util.*;

public class negativeLongestSubarray {
    public int longestSubarray(int[] nums, int target) {
        int glbLongest = Integer.MIN_VALUE;

        //preSum preparation
        int sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>(); //preSum ds <preSum, rightMost idx>
        preSum.put(0, -1);

        //BF + memo
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];  //sum calculate preSum[]
            Integer leftMostIdx = preSum.get(sum - target);
            if (leftMostIdx != null) {
                glbLongest = Math.max(glbLongest, j - leftMostIdx);
            }
            preSum.putIfAbsent(sum, j);
        }
        return glbLongest;
    }

    public static void main(String[] args) {
        negativeLongestSubarray ob = new negativeLongestSubarray();
        int[] nums = new int[]{3, 0, -1, -3, 4};
        int target = 0;
        int res = ob.longestSubarray(nums, target);
        System.out.println(res);
    }
}
