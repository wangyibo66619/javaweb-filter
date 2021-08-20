package com.wang.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        System.out.println("CharacterEncodingFilter执行前");
        chain.doFilter(request,response);// 让我们的请求继续走，如果不写，程序到这里就会终止
        System.out.println("CharacterEncodingFilter执行后");
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter启动");
    }

    public void destroy() {
        System.out.println("CharacterEncodingFilter关闭");
    }
}
