package com.jerry.study.array;

public class 找到一个数字的K美丽值 {

    public static void main(String[] args) {
        System.out.println(divisorSubstrings(240, 2));
    }

    public static int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int req = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            int a = Integer.parseInt(s.substring(i, i + k));
            if (a != 0 && num % a == 0) {
                req++;
            }
        }
        return req;
    }
}
