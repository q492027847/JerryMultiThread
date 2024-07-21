package com.jerry.study.math;

public class 山脉数组的峰顶索引 {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0,2,1,0}));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid+1]){
                right = mid -1;
            }else {
                left = mid +1;
            }
        }
        return left;
    }
}
