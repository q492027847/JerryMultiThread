package com.jerry.study;

public class 螺旋矩阵II {

    public static void main(String[] args) {
        int[][] ints = generateMatrix(100);
        System.out.println(ints);
    }

    public static int[][] generateMatrix(int n) {
        int left = 0;
        int right = n -1;
        int upper = 0;
        int low = n -1;

        int[][] result = new int[n][n];
        int num = 1;
        while (num <= n*n){
            // 从左向右
            if (upper <= low){
                for (int i = left; i <= right; i++) {
                    result[upper][i] = num;
                    num++;
                }
                upper++;
            }
            // 从上到下
            if (left <= right){
                for (int i = upper; i <= low; i++) {
                    result[i][right] = num;
                    num++;
                }
                right--;
            }
            // 从右到左
            if (left <= right){
                for (int i = right; i >= left; i--) {
                    result[low][i] = num;
                    num++;
                }
                low--;
            }
            // 从下到上
            if (left <= right){
                for (int i = low; i >= upper; i--) {
                    result[i][left] = num;
                    num++;
                }
                left++;
            }
        }
        return result;
    }
}
