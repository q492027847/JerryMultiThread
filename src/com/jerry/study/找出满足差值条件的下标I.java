package com.jerry.study;

public class 找出满足差值条件的下标I {

    public static void main(String[] args) {
        int[] indices = findIndices(new int[]{11,3,36,17,13,0,26}, 2, 33);
        System.out.println("1");
    }

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length - indexDifference; i++) {
            for (int j = i+indexDifference; j < nums.length; j++) {
                if (nums[i] - nums[j] >= valueDifference || nums[j] - nums[i] >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
