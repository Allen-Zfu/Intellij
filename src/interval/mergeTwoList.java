package interval;
import java.util.*;

public class mergeTwoList {
    public int[][] mergeLists(int[][] i1, int[][] i2) {
        List<int[]> res = new ArrayList<>();
        //step 0: sort each list by start time
        Arrays.sort(i1, (a, b) -> a[0] - b[0]);
        Arrays.sort(i2, (a, b) -> a[0] - b[0]);
        //step 1 : 谁小移谁 模拟按start升序遍历全部interval
        int i = 0;
        int j = 0;
        while (i < i1.length && j < i2.length) {
            //res中的最后一位是cur，判断i和j谁start小，谁是next（即谁先被放走）
            if (i1[i][0] <= i2[j][0]) {
                mergeToRes(i1[i], res);
                i++;
            } else {
                mergeToRes(i2[j], res);
                j++;
            }
        }
        while (i < i1.length) {
            mergeToRes(i1[i], res);
            i++;
        }
        while (j < i2.length) {
            mergeToRes(i2[j], res);
            j++;
        }

        //return res
        return res.toArray(new int[res.size()][]);
    }

    //merge interval
    private void mergeToRes(int[] next,  List<int[]> res) {
        if (res.isEmpty()) {
            res.add(next);
            return;
        }
        int[] cur = res.get(res.size() - 1);
            //case 1: overlap between cur & next --> expand cur using next
        if (cur[1] >= next[0]) {
            cur[1] = Math.max(cur[1], next[1]);
        } else {
            //case 2: no overlap between cur & next --> next 加入res
            res.add(next);
        }
    }

    public static void main(String[] args) {
        mergeTwoList ob = new mergeTwoList();
        int[][] i1 = new int[][]{{1,2}, {3,4}};
        int[][] i2 = new int[][]{{2,3}, {5,6}};
        int[][] res = ob.mergeLists(i1, i2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}





