package com.jerry.study;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 找出峰值 {

    public static void main(String[] args) {
        List<Integer> peaks = findPeaks(new int[]{1, 4, 3, 8, 5});
        for (Integer peak : peaks) {
            System.out.println(peak);
        }
    }

    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                result.add(i);
            }
        }
        return result;
    }
}
