package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        check(s);
    }

    public static void check(String str){
        String[] split = str.split(",");
        Comparator<String> c = Comparator.comparing((String x) -> x.substring(0, 2)).thenComparing(x -> Integer.parseInt(x.substring(2, 6)));
        Arrays.sort(split,c);
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (sb.length() > 0){
                sb.append(",");
            }
            sb.append(s);
        }
        System.out.println(sb);
    }
}
