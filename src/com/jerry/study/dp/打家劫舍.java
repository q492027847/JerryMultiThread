package com.jerry.study.dp;

import java.util.Arrays;

public class 打家劫舍 {

    public static int[] memo;

    public static void main(String[] args) {
        System.out.println(rob(new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240}));
    }

    public static int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return revers(nums, 0);
    }

    public static int revers(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int max = Math.max(revers(nums, start + 1), nums[start] + revers(nums, start + 2));
        memo[start] = max;
        return max;
    }
}
