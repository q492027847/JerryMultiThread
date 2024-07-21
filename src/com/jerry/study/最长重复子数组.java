package com.jerry.study;

public class 最长重复子数组 {


    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4}));
    }

    public static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ret = 0;

        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxLen = getMaxLen(nums1, nums2, i, 0, len);
            ret = Math.max(ret, maxLen);
        }

        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxLen = getMaxLen(nums1, nums2, 0, i, len);
            ret = Math.max(ret, maxLen);
        }

        return ret;

    }

    public static int getMaxLen(int[] nums1, int[] nums2, int num1, int num2, int len) {
        int res = 0;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[num1 + i] == nums2[num2 + i]) {
                k++;
            } else {
                k = 0;
            }
            res = Math.max(res, k);
        }
        return res;
    }

}
