package com.jerry.study.DFS;

import java.util.LinkedList;
import java.util.List;

public class 全排列 {

    static List<List<Integer>>  res = new LinkedList<>();

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println("1");
    }

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }

    public static void backtrack(int[] nums,LinkedList<Integer> track){
        // 结束条件
        if (nums.length == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])){
                continue;
            }
            // 前序遍历
            track.add(nums[i]);
            backtrack(nums,track);
            // 后续遍历
            track.removeLast();

        }
    }

}
