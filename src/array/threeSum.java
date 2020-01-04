package array;
import java.util.*;

//input sorted, no duplication
public class threeSum {
    public static void main() {
        threeSum ob = new threeSum();
        List<Integer> input = new LinkedList<>();
        input.add(1);
        input.add(2);
        input.add(4);
        input.add(3);
        input.add(2);
        input.add(5);
        input.add(3);
        input.add(1);
        long target = 7;
        long count = ob.threeSum(input, target);
        System.out.println(count);
    }

//    public int threeSum(int[] input, int sum) {
//        Arrays.sort(input);
//        int count = 0;
//        int n = input.length - 2;
//        for (int i = 0; i < n - 2; i++) {
//            while (i + 1 < n - 2 && input[i] == input[i + 1]) {
//                i++;
//            }
//            for (int j = i + 1; j < n - 1; j++) {
//                while (j + 1 < n - 1 && input[j] == input[j + 1]) {
//                    j++;
//                }
//                for (int k = j + 1; k < n; k++) {
//                    if (input[i] + input[j] + input[k] < sum) {
//                        count++;
//                    }
//                }
//            }
//        }
//        return count;
//    }
//    public int threeSum(int[] array, int target) {
//        if (array == null || array.length <= 2) {
//            return 0;
//        }
//        Arrays.sort(array);
//        int slow = 1;
//        int fast = 1;
//        while (fast < array.length) {
//            if (array[fast] == array[slow - 1]) {
//                fast++;
//            } else {
//                array[slow++] = array[fast++];
//            }
//        }
//        int count = 0;
//        for (int k = 0; k < slow - 2; k++) {
//            int i = k + 1;
//            int j = slow - 1;
//            while (i < j) {
//                if (array[k] + array[i] + array[j] > target) {
//                    j--;
//                } else {
//                    count += j - i;
//                    i++;
//                }
//            }
//        }
//        return count;
//    }

    public long threeSum(List<Integer> array, long target) {
        if (array == null || array.size() <= 2) {
            return 0;
        }
        Collections.sort(array);
        int slow = 1;
        int fast = 1;
        while (fast < array.size()) {
            if (array.get(fast) == array.get(slow - 1)) {
                fast++;
            } else {
                array.set(slow, array.get(fast));
            }
        }
        long count = 0;
        for (int k = 0; k < slow - 2; k++) {
            int i = k + 1;
            int j = slow - 1;
            while (i < j) {
                if (array.get(k) + array.get(i) + array.get(j) > target) {
                    j--;
                } else {
                    count += j - i;
                    i++;
                }
            }
        }
        return count;
    }
}
