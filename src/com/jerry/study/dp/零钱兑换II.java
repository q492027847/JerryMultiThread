package com.jerry.study.dp;

public class 零钱兑换II {

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }

    public static  int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[n][amount];
    }
}
