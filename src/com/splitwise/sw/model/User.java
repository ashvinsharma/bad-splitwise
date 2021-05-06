package com.splitwise.sw.model;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger counter = new AtomicInteger(0);

    private final int id;
    private String name;
    private final String email;
    private String phone;

    public User(String email) {
        this.email = email;
        this.id = counter.getAndIncrement();
    }

    public User(String name, String email, String phone) {
        this(email);
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
