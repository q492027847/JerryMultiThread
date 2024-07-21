package com.jerry.study;

import java.util.HashSet;
import java.util.Set;

public class 必须拿起的最小连续卡牌数 {

    public static void main(String[] args) {
//        System.out.println(minimumCardPickup(new int[]{70,37,70,41,1,62,71,49,38,50,29,76,29,41,22,66,88,18,85,53}));
        System.out.println(minimumCardPickup(new int[]{3,4,2,3,4,7}));
    }

    public static int minimumCardPickup(int[] cards) {
        int result = -1;
        if (cards == null || cards.length <= 1){
            return result;
        }
        Set<Integer> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int n = cards.length;
        while (fast < n){
            if (set.add(cards[fast])){
                fast++;
            }else {
                while (cards[slow] != cards[fast]){
                    set.remove(cards[slow]);
                    slow++;
                }
                result = result == -1? fast -slow +1: Math.min(result,fast -slow +1);
                slow++;
                fast++;
            }


        }
        return result;
    }
}
