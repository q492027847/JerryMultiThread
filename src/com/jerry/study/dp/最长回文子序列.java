package com.jerry.study.dp;

public class 最长回文子序列 {

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("cbbd"));
    }

    public static int longestPalindromeSubseq(String s) {
        int m = s.length();
        int n = m;
        String s1 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[m+1][n+1];


        for (int i = 1; i <= m; i++) {
            int code1 = s.codePointAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int code2 = s1.codePointAt(j - 1);
                if (code1 == code2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
