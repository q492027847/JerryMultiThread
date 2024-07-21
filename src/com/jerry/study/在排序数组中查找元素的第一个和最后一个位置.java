package com.jerry.study;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{2,2}, 3);
        System.out.println(ints[0]+""+ ints[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length<=0){
            return new int[]{-1,-1};
        }
        int left = getLeft(nums,target);
        int right = getRight(nums,target);
        return new int[]{left,right};
    }

    public static int getLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = left + (right -left)/2;
            if (nums[mid] == target){
                right = mid -1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid -1;
            }
        }
        // 检查边界
        if (left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }


    public static int getRight(int[] nums,int targer){
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = left + (right -left)/2;
            if (nums[mid] == targer){
                left = mid +1;
            }else if (nums[mid] < targer){
                left = mid +1;
            }else if (nums[mid] > targer){
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != targer){
            return -1;
        }
        return right;
    }
}
