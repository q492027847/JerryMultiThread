package com.jerry.study.dp;

public class 最大子数组和 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        // 对于任意一个位置，要不和前面的最长更大的子数组，要不自己做一个更大的数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
