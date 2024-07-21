package com.jerry.study.dp;

import java.util.Arrays;

public class 打家劫舍II {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp1 = new int[n];
        dp1[0] = 0;
        dp1[1] = nums[0];

        for (int i = 2; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i - 1]);
        }

        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = nums[n - 1];

        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[n - i]);
        }

        return Math.max(dp1[n - 1], dp2[n - 1]);

    }
}
