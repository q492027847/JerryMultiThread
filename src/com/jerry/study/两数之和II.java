package com.jerry.study;

public class 两数之和II {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int num = numbers[left] + numbers[right];
            if (num == target) {
                return new int[]{left + 1, right + 1};
            } else if (num < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
