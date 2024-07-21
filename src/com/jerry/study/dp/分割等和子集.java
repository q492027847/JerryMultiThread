package com.jerry.study.dp;

public class 分割等和子集 {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,2,3,5}));
    }

    public static boolean canPartition(int[] nums) {
        if (nums.length <= 0){
            return false;
        }
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum+= num;
        }
        if (sum%2 != 0){
            return false;
        }
        sum = sum/2;

        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] | dp[i-1][j - nums[i-1]];
                }
            }
        }
        return dp[n][sum];

    }
}
