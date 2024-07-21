package com.jerry.study.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        LinkedList<Character> list = new LinkedList<>();
        int req = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
                req = Math.max(req, list.size());
            } else {
                while (list.contains(s.charAt(i))) {
                    list.removeFirst();
                }
                list.add(s.charAt(i));
            }
        }
        return req;
    }
}
