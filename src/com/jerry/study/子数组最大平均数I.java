package com.jerry.study;

public class 子数组最大平均数I {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        double max = 0;
        double count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k-1) {
                count = count + nums[i] - nums[i - k];
                max = Math.max(count, max);
            } else {
                count += nums[i];
                max = count;
            }
        }
        return max/k;
    }
}
