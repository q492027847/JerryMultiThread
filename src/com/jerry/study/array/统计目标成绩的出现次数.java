package com.jerry.study.array;

public class 统计目标成绩的出现次数 {
    public static void main(String[] args) {
        System.out.println(countTarget(new int[]{2, 2, 3, 4, 4, 4, 5, 6, 6, 8}, 4));
    }

    public static int countTarget(int[] scores, int target) {
        if (scores == null || scores.length <= 0) {
            return 0;
        }
        int leftIdex = getLeftIndex(scores, target);
        int rightIdex =getRightIndex(scores,target);
        return rightIdex - leftIdex +1;
    }

    public static int getLeftIndex(int[] scores, int target) {
        if (scores.length == 0) return -1;
        int left = 0;
        int right = scores.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (scores[mid] >= target) {
                right = mid;
            } else if (scores[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int getRightIndex(int[] scores, int target) {
        if (scores.length == 0) return -1;
        int left = 0, right = scores.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (scores[mid] <= target) {
                left = mid + 1; // 注意
            } else if (scores[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }


}
