package com.jerry.study;

public class 移除元素 {


    public static void main(String[] args) {
        System.out.println(removeElement1(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int n = nums.length;
        int slow = 0;
        for (int fast = 0; fast < n; fast++) {
            if (nums[fast] != val){
                if (fast == slow){
                    ++slow;
                }else {
                    int temp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = temp;
                    ++slow;
                }
            }
        }
        return slow;
    }

    public static int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while (left <= right){
        if (nums[left] != val){
            left++;
        }else {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            right--;
        }
        }
        return right+1;
    }
}
