package com.jerry.study.array;

public class 搜索二维矩阵II {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while (i < m &&  j >= 0){
            if (matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] < target){
                i++;
            }else if (matrix[i][j] > target){
                j--;
            }
        }
        return false;
    }


}
