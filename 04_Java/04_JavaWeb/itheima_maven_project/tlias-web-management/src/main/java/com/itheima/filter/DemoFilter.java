package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    // 初始化方法 只调用一次 几乎不用
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("init 初始化方法执行了");
    }

    // 拦截到了请求后调用 调用多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截前的逻辑");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("拦截后的逻辑");
    }

    // 销毁方法 只调用一次 几乎不用
    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("destroy 销毁方法执行了");
    }
}
