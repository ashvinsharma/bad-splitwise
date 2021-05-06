package com.splitwise.driver;

import com.splitwise.sw.SplitPolicy;
import com.splitwise.sw.Splitwise;
import com.splitwise.sw.SplitwiseBuilder;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        Splitwise s = new SplitwiseBuilder()
                .user("name", "email", "phone")
                .user("name1", "email1", "phone1")
                .user("name2", "email2", "phone2")
                .user("name3", "email3", "phone3")
                .build();

//        s.split(0, 1000, new int[]{0, 1, 2, 3}, SplitPolicy.EQUAL);
//        System.out.println(Arrays.toString(s.balance(0)));
//        System.out.println(Arrays.deepToString(s.balance()));

//        u1 1250 2 u2 u3 EXACT 370 880
//        s.split(0, 1250, new int[]{1, 2}, SplitPolicy.EXACT, 370, 880);
//        System.out.println(Arrays.toString(s.balance(0)));
//        System.out.println(Arrays.deepToString(s.balance()));


    }
}
