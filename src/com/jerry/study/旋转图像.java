package com.jerry.study;

public class 旋转图像 {

    public static void main(String[] args) {
        rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 对折
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 翻转同一行
        for (int[] ints : matrix) {
            // 使用双指针替换
            int left = 0;
            int right = n -1;
            while (left < right){
                int temp = ints[left];
                ints[left] = ints[right];
                ints[right] = temp;
                left++;
                right--;
            }
        }
    }
}
