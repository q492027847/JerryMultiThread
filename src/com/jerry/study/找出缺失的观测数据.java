package com.jerry.study;

public class 找出缺失的观测数据 {

    public static void main(String[] args) {
        int[] ints = missingRolls(new int[]{3,5,3}, 5, 3);
        System.out.println("1");
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int length = rolls.length;
        int sum = 0;
        for (int roll : rolls) {
            sum+= roll;
        }
        int count = (mean * (length + n)) - sum;

        if (n*6 <count || count<n){
            return new int[0];
        }

        int avg = count/n;

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = avg;
        }
        int yu = count - (avg*n);
        for (int i = 0; i < yu; i++) {
            res[i] = res[i]+1;
        }
        return res;
    }
}
