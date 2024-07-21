package com.jerry.study;

import java.util.Comparator;

public class 比较版本号 {
    public static void main(String[] args) {
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
    }


    public static int compareVersion(String version1, String version2) {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");
        int version1Length = version1Arr.length;
        int version2Length = version2Arr.length;
        int maxLength = Math.max(version1Length, version2Length);
        int result = 0;
        for (int i = 0; i < maxLength; i++) {
            int temp1 = version1Length > i ? Integer.parseInt(version1Arr[i]) : 0;
            int temp2 = version2Length > i ? Integer.parseInt(version2Arr[i]) : 0;
            if (temp1 > temp2) {
                return 1;
            } else if (temp1 < temp2) {
                return -1;
            }
        }
        return result;
    }

}
