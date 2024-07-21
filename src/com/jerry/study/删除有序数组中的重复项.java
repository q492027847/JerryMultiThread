package com.jerry.study;

public class 删除有序数组中的重复项 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length<= 0){
            return 0;
        }
        int n = nums.length;
        int fast = 1;
        int slow = 0;
        while (fast < n) {
            if (nums[fast] != nums[slow]){
                ++slow;
                nums[slow] = nums[fast];
            }
            ++ fast;
        }
        return slow + 1;
    }
}
