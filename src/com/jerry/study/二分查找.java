package com.jerry.study;

public class 二分查找 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0){
            return -1;
        }
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid +1;
            }else if (nums[mid] > target){
                right = mid -1;
            }
        }
        return -1;
    }
}
