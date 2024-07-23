package com.jerry.study.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        List<Integer> req = new ArrayList<>();
        int[] sArr = new int[26];
        int[] pArr = new int[26];

        for (int i = 0; i < pLen; i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArr, pArr)) {
            req.add(0);
        }
        // 开始滑动
        for (int i = 0; i < sLen - pLen; i++) {
            sArr[s.charAt(i) - 'a']--;
            sArr[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(sArr, pArr)) {
                req.add(i + 1);
            }
        }
        return req;
    }
}
