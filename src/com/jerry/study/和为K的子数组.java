package com.jerry.study;

public class 和为K的子数组 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        int[] res = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            res[i] = res[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (res[i] - res[j] == k){
                    result++;
                }
            }
        }
        return result;
    }
}
