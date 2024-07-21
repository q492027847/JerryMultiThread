package com.jerry.study;

import java.util.LinkedList;
import java.util.List;

public class 螺旋矩阵 {
    public static void main(String[] args) {
        List<Integer> integers = spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int upper = 0;
        int low = m - 1;
        int left = 0;
        int right = n - 1;
        List<Integer> res = new LinkedList<>();
        while (res.size() < m * n) {
            // 从左到右
            if (upper <= low){
                for (int i = left; i <= right; i++) {
                    res.add(matrix[upper][i]);
                }
                upper++;
            }
            // 从上到下
            if (left <= right){
                for (int i = upper; i <= low; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            // 从右到左
            if (upper <= low){
                for (int i = right; i >= left; i--) {
                    res.add(matrix[low][i]);
                }
                low--;
            }
            
            // 从下到上
            if (left <= right){
                for (int i = low; i >= upper ; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
