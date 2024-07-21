package com.jerry.meiriyiti;

public class 取整购买后的账户余额 {

    public static void main(String[] args) {
        System.out.println(accountBalanceAfterPurchase(15));
    }

    public static int accountBalanceAfterPurchase(int purchaseAmount) {
        int num = (purchaseAmount + 5) / 10 * 10;
        return 100 - num;
    }
}
