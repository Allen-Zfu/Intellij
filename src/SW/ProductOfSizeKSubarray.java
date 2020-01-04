package SW;
import java.util.*;

public class ProductOfSizeKSubarray {

    //BF method
    /*
    public List<Integer> ProOfK(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        for (int fast = k - 1; fast < nums.length; fast++) {
            res.add(product(nums, fast - k + 1, fast));
        }
        return res;
    }

    private int product(int[] nums, int left, int right) {
        int product = 1;
        for (int i = left; i <= right; i++) {
            product *= nums[i];
        }
        return product;
    }
*/

    //mthod 2: FS-SW
    private List<Integer> ProOfK(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        //representative value
        int product = 1;
        int numZero = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            //add fast
            if (nums[fast] == 0) {
                numZero++;
            } else {
                product *= nums[fast];
            }

            //remove slow
            if (fast >= k) {
                if (nums[fast - k] == 0) {
                    numZero--;
                } else {
                    product /= nums[fast - k];
                }
            }

            //check / output
            if (fast >= k - 1) {
                if (numZero == 0) {
                    res.add(product);
                } else {
                    res.add(0);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ProductOfSizeKSubarray ob = new ProductOfSizeKSubarray();
        int[] nums = new int[]{0, 2, 3, 4, 5, 0};
        int k = 3;
        List<Integer> res = ob.ProOfK(nums, k);
        System.out.println(res);
    }
}
