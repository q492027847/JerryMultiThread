package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class test3 {



    static int resultInt = Integer.MAX_VALUE;
    static boolean[] used = new boolean[15];
    static int[][] res;
    static int n;
    static int m;
    static int k;


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = scanner.nextInt();
            }
        }
        dfs(0,0,new int[n]);
        System.out.println("1");
    }

    public static void dfs(int row,int col,int[] arrs){
        if(col == n){
            Arrays.sort(arrs);
            resultInt = Math.min(resultInt,arrs[n-k]);
            return;
        }
        for (int i = 0; i < m; i++) {
            if (!used[i]){
                boolean ok = true;
                for (int j = 0; j < row; j++) {
                    if (res[j][i] == arrs[j]){
                        ok =false;
                        break;
                    }
                }
                if (ok){
                    used[i] = true;
                    arrs[col] = res[row][i];
                    dfs(row+1,col+1,arrs);
                    used[i] = false;
                }
            }
        }
    }


}

