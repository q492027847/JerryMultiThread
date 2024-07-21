package com.jerry.study.array;

public class 在D天内送达包裹的能力 {

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 1;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            // 船的载重
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 定义：当运载能⼒为 x 时，需要 f(x) 天运完所有货物
    // f(x) 随着 x 的增加单调递减
    public static int f(int[] weights, int x) {
        int days = 1;
        int cap = x;
        for (int i = 0; i < weights.length; ) {
            if (cap < weights[i]) {
                cap = x;
                days++;
            } else {
                cap -= weights[i];
                i++;
            }
        }
        return days;
    }
}
