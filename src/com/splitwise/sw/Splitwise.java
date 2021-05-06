package com.splitwise.sw;

import com.splitwise.sw.model.User;

import java.util.Arrays;
import java.util.List;

public class Splitwise {
    private final Bookkeeper bk;

    public Splitwise(List<User> users) {
        bk = new SimpleBookkeeper(users.size());
    }

    /**
     * this function is supposed to split the expense depending on policy
     */
    public void split(int spender,
                      int expense,
                      int[] beneficiaries,
                      SplitPolicy policy,
                      double... args) {
        // this function is supposed to adjust the difference between 2 parties
        switch (policy) {
            case EQUAL:
                args = new double[beneficiaries.length];
                Arrays.fill(args, 1.0 / beneficiaries.length);
                calculateExact(spender, expense, beneficiaries, args);
                break;

            case EXACT:
                splitExact(spender, beneficiaries, args);
                break;
                
            case PERCENT:
                for (int i = 0; i < args.length; i++) {
                    args[i] = args[i] / 100;
                }
                calculateExact(spender, expense, beneficiaries, args);
            default:
                throw new RuntimeException("Not implemented");
        }
    }

    /**
     * show balances for user1 against every user
     *
     * @param user
     * @return double[]
     */
    public double[] balance(int user) {
        return bk.getBalance(user);
    }

    public double[][] balance() {
        return bk.getAllBalance();
    }

    private void calculateExact(int spender,
                                int expense,
                                int[] beneficiaries,
                                double[] weight) {
        var cost = new double[beneficiaries.length];

        for (int i = 0; i < cost.length; i++) {
            cost[i] = expense * weight[i];
        }

        splitExact(spender, beneficiaries, cost);
    }

    private void splitExact(int spender,
                            int[] beneficiaries,
                            double[] cost) {
        for (int i = 0; i < beneficiaries.length; i++) {
            var fromUser = beneficiaries[i];
            bk.tx(fromUser, spender, cost[i]);
        }
    }
}
