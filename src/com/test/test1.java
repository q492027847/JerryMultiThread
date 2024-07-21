package com.test;

import java.util.Scanner;

public class test1 {

    // 给出数字个数n和行数m
    // 高一个螺旋矩阵

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[][] test = test(n, m);
        for (String[] strings : test) {
            StringBuilder sb = new StringBuilder();
            for (String string : strings) {
                if (sb.length() >0){
                    sb.append(" ");
                }
                sb.append(string);
            }
            System.out.println(sb);
        }
    }

    public static String[][] test(int n,int m){

        // 计算出列
        int count;
        if (n%m !=0){
            count =  n/m +1;
        }else {
            count = n/m;
        }
        String[][] res = new String[m][count];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < count; j++) {
                res[i][j] = "*";
            }
        }
        int upper = 0;
        int low = m-1;
        int left = 0;
        int right = count-1;
        int num = 1;
        while (num < n){
            for (int i = left; i <= right&& num <= n ; i++) {
                res[upper][i] = String.valueOf(num++);
            }
            upper++;
            for (int i = upper; i <= low && num <= n; i++) {
                res[i][right] = String.valueOf(num++);
            }
            right--;
            for (int i = right; i >= left&& num <= n ; i--) {
                res[low][i] = String.valueOf(num++);
            }
            low--;
            for (int i = low; i >= upper && num <= n; i--) {
                res[i][left] = String.valueOf(num++);
            }
            left++;
        }
        return res;
    }
}
