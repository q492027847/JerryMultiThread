package com.jerry.study.dp;

public class 两个字符串的最小ASCII删除和 {

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("delete", "leet"));
    }

    public static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 0; i < m; i++) {
            res+= s1.codePointAt(i);
        }
        for (int i = 0; i < n; i++) {
            res += s2.codePointAt(i);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = s1.codePointAt(i-1) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return res - dp[m][n]*2;
    }
}
