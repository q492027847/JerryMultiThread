package com.jerry.study;

public class 移动零 {

    public static void main(String[] args) {
        moveZeroes(new int[]{0});
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 0){
            return;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0){
                if (fast == slow){
                    slow++;
                }else {
                    int temp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = temp;
                    slow++;
                }
            }
        }
    }
}
