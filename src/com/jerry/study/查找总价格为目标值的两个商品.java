package com.jerry.study;

public class 查找总价格为目标值的两个商品 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 9, 12, 15}, 18);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] twoSum(int[] price, int target) {
        int left = 0;
        int right = price.length - 1;
        while (left < right){

            if (price[left] + price[right] == target){
                return new int[]{price[left],price[right]};
            }else if(price[left] + price[right] < target){
                left++;
            }else {
                right--;
            }
        }

        return new int[]{0};
    }
}
