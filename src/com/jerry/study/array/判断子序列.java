package com.jerry.study.array;

public class 判断子序列 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdd"));
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int m = s.length();
        int n = t.length();
        while (i < m && j < n){
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        return i == m;
    }
}
