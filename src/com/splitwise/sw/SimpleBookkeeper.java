package com.splitwise.sw;

public class SimpleBookkeeper implements Bookkeeper {
    /**
     * shorter index is the reference of the account
     * if shorter index owes balance will be negative
     * if shorter index asks for money balance will be positive
     * <p>
     * Read it for [i][j] as balance of i w.r.t. j
     */
    private final double[][] book;

    public SimpleBookkeeper(int userCount) {
        this.book = new double[userCount][userCount];
    }

    @Override
    public void tx(int fromUser, int toUser, double amount) {
        var x = fromUser;
        var y = toUser;

        if (fromUser < toUser) {
            amount = -amount;
        } else if (fromUser > toUser) {
            x = toUser;
            y = fromUser;
        } else {
            // spender and beneficiary are the same person
            return;
        }

        this.book[x][y] += amount;
    }

    @Override
    public double[] getBalance(int account) {
        return book[account];
    }

    @Override
    public double[][] getAllBalance() {
        return book;
    }
}
