package com.splitwise.sw.model;

import java.util.UUID;

public class Account {
    private final String uuid;
    private final String user1;
    private final String user2;
    private int balance;

    public Account(String user1, String user2) {
        this.uuid = String.valueOf(UUID.nameUUIDFromBytes(
                (user1 + "_" + user2).getBytes()
        ));
        this.user1 = user1;
        this.user2 = user2;
        balance = 0;
    }

    public String getUser1() {
        return user1;
    }

    public String getUser2() {
        return user2;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getUuid() {
        return uuid;
    }

    public static String getUuid(String user1, String user2) {
        return String.valueOf(UUID.nameUUIDFromBytes(
                (user1 + "_" + user2).getBytes()
        ));
    }
}
