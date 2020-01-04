package SW;
import java.util.*;

import javax.print.attribute.IntegerSyntax;

public class SumOfKSizeSubarray {
    /*method 1: BF
    public List<Integer> SumOfK(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        for (int fast = k - 1; fast < nums.length; fast++) {
            res.add(sum(nums, fast - k + 1, fast));
        }
        return res;
    }

    private int sum(int[] nums, int s, int f) {  //valid window:[s, f]
        int num = 0;
        for (int i = s; i <= f; i++) {
            num += nums[i];
        }
        return num;
    }
    */

    //method 2: fs-sw
    public List<Integer> SumOfK(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        int sum = 0; //representative variable
        int fast = 0;
        while (fast < nums.length) {
            sum += nums[fast];  //全区间做add fast


            if (fast >= k) {
                sum -= nums[fast - k]; //从区间fast>=k: 开始做remove slow
            }
            //res输出
            if (fast >= k - 1) {
                res.add(sum);
            }

            //move fast
            fast++;
        }
        return res;
    }

    public static void main(String[] args) {
        SumOfKSizeSubarray ob = new SumOfKSizeSubarray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 3;
        List<Integer> res = ob.SumOfK(nums, k);
        System.out.println(res);
    }
}
