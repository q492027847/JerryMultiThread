package com.jerry.study.array;

public class 搜索二维矩阵 {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3}}, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int j = mid % n;
            int i = (mid - j) / n;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                right = mid - 1;
            } else if (matrix[i][j] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
