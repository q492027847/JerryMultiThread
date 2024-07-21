package com.jerry.study.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class N皇后 {

    static List<List<char[]>> res = new LinkedList<>();

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(3);
        System.out.println(1);
    }



    public static List<List<String>> solveNQueens(int n) {
        // 路径
        List<char[]> board = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char[] ch = new char[n];
            for (int i1 = 0; i1 < n; i1++) {
                ch[i1] = '.';
            }
            board.add(ch);
        }
        backtrack(board,0);

        List<List<String>> tempRes = new ArrayList<>();

        for (List<char[]> re : res) {
            List<String> temp = new ArrayList<>();
            for (char[] chars : re) {
                temp.add(Arrays.toString(chars));
            }
            tempRes.add(temp);
        }
        return tempRes;

    }

    public static void backtrack(List<char[]> board,int row){
        // 结束条件
        if (row == board.size()){
            res.add(board);
            return;
        }
        //
        int n = board.get(row).length;
        for (int col = 0; col < n; col++) {
            if (!check(row,col,board)){
                // 如果校验不通过则不放
                continue;
            }
            board.get(row)[col] = 'q';
            // 加入
            backtrack(board,row + 1);
            //移除
            board.get(row)[col] = '.';
        }


    }


    public static boolean check(int row, int col, List<char[]> board){
        int n = board.size();
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board.get(i)[col] == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board.get(i)[j] == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board.get(i)[j] == 'Q')
                return false;
        }
        return true;
    }
}
