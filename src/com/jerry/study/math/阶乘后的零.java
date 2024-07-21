package com.jerry.study.math;

public class 阶乘后的零 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(311));
    }

    public static int trailingZeroes(int n) {
        int res = 0;
        int revers = 5;
        while (revers <= n){
            res += n/revers;
            revers *= 5;
        }
        return res;
    }
}
