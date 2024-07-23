package com.jerry.study.array;

import java.util.*;

public class 定长子串中元音的最大数目 {

    public static void main(String[] args) {
        System.out.println(maxVowels("tryharda", 4));
    }

    public static int maxVowels(String s, int k) {
        int left = 0;
        int right = k - 1;
        int req = 0;
        int tempReq = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                tempReq++;
            }
            req = Math.max(tempReq, req);
        }
        while (right < s.length() - 1) {
            right++;
            left++;
            // 如果右边有就+1；
            if (isVowel(s.charAt(right))) {
                tempReq++;
            }
            // 如果左边过去的有就-1；
            if (isVowel(s.charAt(left-1)) ) {
                tempReq--;
            }
            req = Math.max(tempReq, req);
        }
        return req;
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
