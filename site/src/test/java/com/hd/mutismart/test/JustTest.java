package com.hd.mutismart.test;

public class JustTest {

    public static void main(String[] args) {
        System.getenv().keySet().forEach(item -> System.out.println(item + "=" + System.getenv().get(item)));

    }
}
