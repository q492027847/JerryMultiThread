package com.jerry.study;

public class Test1 {
    public static void main(String[] args) {
        System.out.println( longestCommonPrefix(new String[]{"abc"}));
    }

    public static String longestCommonPrefix (String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        // write code here
        String mix = strs[0];
        for(int i = 1; i < strs.length; i++){
            int n= mix.length();
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < strs[i].length() && j < n; j++){
                if(mix.charAt(j) == strs[i].charAt(j)){
                    sb.append(strs[i].charAt(j));
                }
            }
            mix = sb.toString();

        }

        return mix;
    }
}
