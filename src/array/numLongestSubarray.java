package array;
import java.util.*;

public class numLongestSubarray {
    public int numSubarray(int[] nums, int target) {
        int res = 0;

        //preSum preparation
        int sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>(); //preSum ds <preSum, count>
        preSum.put(0, 1);

        //BF + memo
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];  //sum calculate preSum[]
            Integer count = preSum.get(sum - target);
            //累加res
            res += preSum.getOrDefault(sum - target, 0);
            //所有j对应信息都要累加进ds
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        negativeLongestSubarray ob = new negativeLongestSubarray();
        int[] nums = new int[]{3, 0, -1, -3, 4};
        int target = 0;
        int res = ob.longestSubarray(nums, target);
        System.out.println(res);
    }
}
