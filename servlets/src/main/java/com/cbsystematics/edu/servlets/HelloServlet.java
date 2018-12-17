package com.cbsystematics.edu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write(new String(Files.readAllBytes(Paths.get("C:\\Users\\Evgeniy\\Desktop\\Новая папка\\java-developer-2018-web-ponny\\servlets\\src\\main\\webapp\\WEB-INF\\hello.html"))));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username + " " + password);

//        resp.getWriter().write("<h1>Welcome, " + username + "!</h1>");
        String template = new String(Files.readAllBytes(Paths.get("C:\\Users\\Evgeniy\\Desktop\\Новая папка\\java-developer-2018-web-ponny\\servlets\\src\\main\\webapp\\WEB-INF\\welcome.html")));
        template = template.replaceAll("<~username~>", username);
        resp.getWriter().write(template);
    }
}
