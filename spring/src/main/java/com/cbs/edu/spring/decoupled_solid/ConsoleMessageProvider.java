package com.cbs.edu.spring.decoupled_solid;

import java.util.Scanner;

public class ConsoleMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return new Scanner(System.in).next();
    }
}
