package com.jerry.study.array;

import java.util.Arrays;

public class 学生分数的最小差值 {

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{9,4,1,7}, 2));
    }

    public static int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int req = Integer.MAX_VALUE;
        // left要计算到下标到 n-k（含） 为止
        for (int i = 0; i <= n - k ; i++) {
            // 包含num[i] 在内的窗口长度为k,所以right应该为 i+k（k为滑窗的长度） 后再减去被num[i]占用的1；
            req = Math.min(req, nums[i + k -1] - nums[i]);
        }
        return req;
    }
}
