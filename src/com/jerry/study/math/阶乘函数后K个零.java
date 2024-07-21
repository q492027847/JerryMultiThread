package com.jerry.study.math;

public class 阶乘函数后K个零 {
    public static void main(String[] args) {
        System.out.println(preimageSizeFZF(5));
    }

    public static int preimageSizeFZF(int k) {
        int l = secrchLeft(k);
        int r = secrchRight(k);
        return r -l +1;

    }

    private static int secrchRight(int k) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tempK = trailingZeroes(mid);
            if (tempK == k) {
                left = mid + 1;
            } else if (tempK > k) {
                right = mid - 1;
            } else if (tempK < k) {
                left = mid + 1;
            }
        }
        return right;
    }

    private static int secrchLeft(int k) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tempK = trailingZeroes(mid);
            if (tempK == k) {
                right = mid - 1;
            } else if (tempK > k) {
                right = mid - 1;
            } else if (tempK < k) {
                left = mid + 1;
            }
        }
        return left;
    }


    public static int trailingZeroes(long n) {
        int res = 0;
        int divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }
}
