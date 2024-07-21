package com.jerry.study;

public class 删除排序数组中的重复项2 {

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,1,2,2,3});
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null){
            return 0;
        }
        int n = nums.length;

        if (nums.length <=2 ){
            return nums.length;
        }

        int fast = 2;
        int slow = 2;

        while (fast < n){
            if (nums[fast] != nums[slow-2]){
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }

        return slow;
    }
}
