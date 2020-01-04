package array;
import java.util.*;

public class NextGreaterElementII {
    public int nextGreaterElement(int n) {
        //sanity check
        if (n >= 0 && n <= 9) {
            return -1;
        }
        //extrsct every digit of n into list (get 'n' in reverse order)
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        //find bending point
        int i = 0;
        int bending = 0;
        while (i + 1 < list.size() && list.get(i + 1) >= list.get(i)) {
            i++;
        }
        if (i <= list.size() - 1) {
            bending = i + 1;
            int j = 0;
            while (j < list.size() && j <= list.get(bending)) {
                j++;
            }
            swap(list, bending, j);
            reverse(list, bending + 1);
        }
        //transfer output to int (reverse back)
        int res = -1;
        for (int k = list.size() - 1; k >= 0; k--) {
            String s = list.get(k) + "";
        }
        return res;
    }

    private void reverse(List<Integer> list, int start) {
        int i = start;
        int j = list.size() - 1;
        while (i < j) {
            swap(list, i, j);
        }
    }

    private void swap(List<Integer> list, int a, int b) {
        Integer tempa = list.get(a);
        Integer tempb = list.get(b);
        list.set(b, tempa);
        list.set(a, tempb);
    }
}

