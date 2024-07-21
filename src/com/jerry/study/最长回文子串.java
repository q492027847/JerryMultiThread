package com.jerry.study;

public class 最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }

    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = find(s, i, i);
            String s2 = find(s, i, i + 1);
            res = res.length() > s1.length()? res: s1;
            res = res.length() > s2.length()? res: s2;
        }
        return res;

    }

    public static String find(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}
