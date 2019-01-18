package com.cbs.edu.spring.decoupled_simple;

public class HelloWorldDecoupledApp {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(args[0]);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
