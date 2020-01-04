package SW;
import java.util.*;

public class AverageOfKSizeSubarray {
    //*method 1: BF
    /*
    public List<Integer> AveOfK(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        for (int fast = k - 1; fast < nums.length; fast++) {
            res.add(Ave(nums, fast - k + 1, fast, k));
        }
        return res;
    }

    private int Ave(int[] nums, int s, int f, int k) {  //valid window:[s, f]
        int num = 0;
        for (int i = s; i <= f; i++) {
            num += nums[i];
        }
        return num / k;
    }
    */


    //method 2: fs-sw
    public List<Integer> AveOfK(int[] nums, int k) {
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
                res.add(sum / k);
            }

            //move fast
            fast++;
        }
        return res;
    }

    public static void main(String[] args) {
        AverageOfKSizeSubarray ob = new AverageOfKSizeSubarray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 3;
        List<Integer> res = ob.AveOfK(nums, k);
        System.out.println(res);
    }
}


