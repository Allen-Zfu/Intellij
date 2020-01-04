package DP;

public class ChocolateSweetness {
    public static void main(String[] args) {
        ChocolateSweetness ob = new ChocolateSweetness();
        int[] sweetness = new int[]{6, 3, 2, 8, 7, 5};
        int k = 3;
        int res = ob.splitChocolate(sweetness, k);
        System.out.println(res);
    }

    public int splitChocolate(int[] sweetness, int k) {
        int n = sweetness.length;
        //sum[]:sweetness[] prefix sum
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + sweetness[i];
        }
/*
        //init dp[][]
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 1) {
                    dp[i][j] = sum[i];
                } else {
                    dp[i][j] = Integer.MIN_VALUE;
                }
            }
        }

        //induction rule(filling the table)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int p = j; p < i; p++) {   //左大段
                    dp[i][j] = Math.max(dp[i][j], Math.min(dp[p][j - 1], sum[i] - sum[p]));
                }
            }
        }
        return dp[n][k];
    }
 */

        /**
         * 代码改进：将base case和induction rule融合起来写
         */
        //init dp[][]
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j == 1) {
                    dp[i][j] = sum[i];
                    continue;
                }
                for (int p = j; p < i; p++) {   //左大段
                    dp[i][j] = Math.max(dp[i][j], Math.min(dp[p][j - 1], sum[i] - sum[p]));
                }
            }
        }
        return dp[n][k];
    }
}
