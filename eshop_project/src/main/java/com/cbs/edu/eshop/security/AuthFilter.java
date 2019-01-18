package com.cbs.edu.eshop.security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean isStartPageRequest = httpServletRequest.getRequestURI().equals("/");
        boolean isLoginPageRequest = httpServletRequest.getRequestURI().equals("/login");
        boolean isRegistrationRequest = httpServletRequest.getRequestURI().equals("/registration");

        if (loggedIn || isStartPageRequest || isRegistrationRequest || isLoginPageRequest) {
            chain.doFilter(request, response);
        } else {
            httpServletResponse.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {}
}
