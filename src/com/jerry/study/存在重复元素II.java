package com.jerry.study;

import java.util.HashSet;
import java.util.Set;

public class 存在重复元素II {

    public static void main(String[] args) {

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
