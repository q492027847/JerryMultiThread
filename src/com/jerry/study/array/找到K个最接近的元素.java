package com.jerry.study.array;

import java.util.LinkedList;
import java.util.List;

public class 找到K个最接近的元素 {

    public static void main(String[] args) {
        List<Integer> closestElements = findClosestElements(new int[]{-2,-1,1,2,3,4,5}, 7, 5);
        for (Integer closestElement : closestElements) {
            System.out.println(closestElement);
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 1.获取到最左测的X；
        int index = getIndex(arr, x);
        int left = index -1;
        int right = index;
        LinkedList<Integer> res = new LinkedList<>();
        while (right - left -1 < k){
            if (left == -1){
                res.addLast(arr[right]);
                right++;
            }else if (right == arr.length){
                res.addFirst(arr[left]);
                left--;
            }else if (x - arr[left] > arr[right] - x){
                res.addLast(arr[right]);
                right++;
            }else {
                res.addFirst(arr[left]);
                left--;
            }
        }
        return res;
    }

    public static int getIndex(int[] arr, int targer) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == targer){
                right = mid -1;
            }else if (arr[mid] < targer){
                left = mid +1;
            }else if(arr[mid] > targer){
                right = mid -1;
            }
        }
        return left;
    }
}
