package com.jerry.study;

public class 分糖果II {

    public static void main(String[] args) {
        int[] ints = distributeCandies(10, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] req = new int[num_people];
        int j =0;
        int num = 0;
        for (int i = 1; i <= candies; i++) {
            num += i;
            if (num > candies){
                req[j] = req[j] + candies - (num - i);
                break;
            }
            req[j] = req[j] + i;
            j++;

            if (j > num_people -1){
                j = 0;
            }
        }
        return req;
    }
}
