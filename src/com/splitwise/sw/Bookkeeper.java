package com.splitwise.sw;

public interface Bookkeeper {
    /**
     * 
     * @param fromUser
     * @param toUser
     * @param amount
     */
    void tx(int fromUser, int toUser, double amount);

    double[] getBalance(int account);

    double[][] getAllBalance();
}
