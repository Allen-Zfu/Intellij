package interval;
import java.util.*;

public class coverageLen {
    public static int coverage(int[][] intervals) {
        //step 1: sort by start
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                if (i1[0] == i2[0]) {
                    return 0;
                }
                return i1[0] < i2[0] ? -1 : 1;
            }
        });

        //step 2: iterate using 'cur' & 'next'
        List<int[]> res = new ArrayList<>();
        int totalLen = 0;
        int[] cur = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            //case 1: overlap between cur & next --> expand cur using next
            if (cur[1] >= next[0]) {
                cur[1] = Math.max(cur[1], next[1]);
            } else {
                //case 2: no overlap between cur & next --> add cur into res and update pointer
                res.add(cur);
                totalLen += (cur[1] - cur[0]);
                cur = next;
            }
        }

        //step 3: add the last cur into res
        totalLen += (cur[1] - cur[0]);
        res.add(cur);
        //return res
        return totalLen;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(coverageLen.coverage(intervals));
    }
}
