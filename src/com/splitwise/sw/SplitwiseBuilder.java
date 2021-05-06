package com.splitwise.sw;

import com.splitwise.sw.model.User;

import java.util.ArrayList;
import java.util.List;

public class SplitwiseBuilder {
    private final List<User> users;

    public SplitwiseBuilder() {
        this.users = new ArrayList<>();
    }

    public SplitwiseBuilder user(String name, String email, String phone) {
        this.users.add(new User(name, email, phone));
        return this;
    }

    public Splitwise build() {
        return new Splitwise(this.users);
    }
}
