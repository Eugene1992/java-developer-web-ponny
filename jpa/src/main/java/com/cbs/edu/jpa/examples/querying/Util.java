package com.cbs.edu.jpa.examples.querying;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Paths.get("C:\\Users\\Evgeniy\\Desktop\\Новая папка\\java-developer-2018-web-ponny\\jpa\\src\\main\\resources\\META-INF\\data.sql"))
                .stream()
                .map(s -> s.replaceAll("'key'", "nextval('hibernate_sequence')"))
                .forEach(System.out::println);
    }
}
