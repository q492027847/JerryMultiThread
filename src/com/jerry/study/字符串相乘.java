package com.jerry.study;

import java.util.ArrayList;
import java.util.List;

public class 字符串相乘 {

    public static void main(String[] args) {
        System.out.println(multiply("123456789", "987654321"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        // 翻转相乘
        String reverseNum1 = new StringBuilder(num1).reverse().toString();
        String reverseNum2 = new StringBuilder(num2).reverse().toString();
        List<String> list = new ArrayList<>();
        StringBuilder zero = new StringBuilder();
        String result = "0";
        for (int i = 0; i < reverseNum1.length(); i++) {
            int temp = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < reverseNum2.length(); j++) {
                int i1 = ((reverseNum1.charAt(i) - '0') * (reverseNum2.charAt(j) - '0')) + temp;
                if (i1 > 10) {
                    sb.append(i1 % 10);
                    temp = i1 / 10;
                } else {
                    sb.append(i1);
                    temp = 0;
                }

            }
            zero.append("0");

            if (temp != 0) {
                System.out.println(zero.substring(0, zero.length() - 1) + sb.append(temp));
                result = solve(result, zero.substring(0, zero.length() - 1) + sb.append(temp));
            } else {
                System.out.println(zero.substring(0, zero.length() - 1) + sb);
                result = solve(result, zero.substring(0, zero.length() - 1) + sb);
            }

        }

        // 字符串加法


        return new StringBuilder(result).reverse().toString();
    }

    public static String solve(String s, String t) {
        if (s.equals("")) {
            s = "0";
        }
        if (t.equals("")) {
            t = "0";
        }
        // write code here
        int length = Math.max(s.length(), t.length());
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        for (int i = 0; i < length; i++) {
            int count = 0;
            if (s.length() <= i) {
                count = 0 + (t.charAt(i) - '0') + temp;
            } else if (t.length() <= i) {
                count = (s.charAt(i) - '0') + 0 + temp;
            } else {
                count = (s.charAt(i) - '0') + (t.charAt(i) - '0') + temp;
            }

            if (count >= 10) {
                temp = 1;
                count -= 10;
            } else {
                temp = 0;
            }
            sb.append(count);
        }
        if (temp != 0) {
            sb.append(temp);
        }

        return sb.toString();
    }
}
