package com.jerry.study;

public class 移动零 {

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
                fast++;
            }
        }
    }


    //  用java完成题目 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
    //
    // 回文串 是正着读和反着读都一样的字符串。
    //

    // 示例 1：
    //
    // 输入：s = "aab"










}
