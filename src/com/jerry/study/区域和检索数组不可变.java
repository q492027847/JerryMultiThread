package com.jerry.study;

public class 区域和检索数组不可变 {

    public static void main(String[] args) {

        NumArray numArray = new NumArray(new int[]{-2,0,3,-5,2,-1});
        System.out.println(numArray.sumRange(1, 2));
    }

}

class NumArray {

    int[] res;

    public NumArray(int[] nums) {
        res = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            res[i] = res[i - 1] + nums[i -1];
        }
    }

    public int sumRange(int left, int right) {
        return res[right+1] - res[left];
    }
}
