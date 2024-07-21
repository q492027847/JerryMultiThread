package com.jerry.study;

public class 二维区域和检索矩阵不可变 {

    public static void main(String[] args) {

        NumMatrix numArray = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(numArray.sumRegion(2, 1, 4, 3));
    }

}

class NumMatrix {

    int[][] res;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            return;
        }
        res = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                res[i][j] = res[i][j - 1] + res[i - 1][j] + matrix[i - 1][j - 1] - res[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return res[row2+1][col2+1] - res[row2+1][col1] - res[row1][col2+1] + res[row1][col1];
    }
}
