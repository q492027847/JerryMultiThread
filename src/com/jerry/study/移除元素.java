package com.jerry.study;

public class 移除元素 {


    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length <= 0){
            return 0;
        }
        int length = nums.length;
        int slow = 0;
        int fast = 0;
        while(fast < length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
