package array;
public class findMinRange {
    public int findMinimumRange(int[] A, int[] B, int[] C) {
        int minRange = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < A.length && j < B.length && k < C.length) {
            //minRange = Math.min(minRange, max(A[i], B[j], C[k]) - min(A[i], B[j], c[K]))
            minRange = Math.min(minRange, Math.max(A[i], Math.max(B[j], C[k])) - Math.min(A[i], Math.min(B[j], C[k])));
            //谁小移谁
            if (A[i] <= B[j] && A[i] <= C[k]) {
                i++;
            } else if (B[j] <= A[i] && B[j] <= C[k]) {
                j++;
            } else {
                k++;
            }
        }
        return minRange;
    }

    public static void main(String[] args) {
        findMinRange ob = new findMinRange();
        int[] A = new int[]{1, 5, 9};
        int[] B = new int[]{2, 4};
        int[] C = new int[]{3, 20, 21};
        int minRange = ob.findMinimumRange(A, B, C);
        System.out.println(minRange);
    }
}



