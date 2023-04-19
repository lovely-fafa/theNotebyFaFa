package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@WebFilter("/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 1. 获取 url
        String url = req.getRequestURI();
        log.info("请求的 url {}", url);

        // 2. 判断是否包含 login
        if (url.contains("login")) {
            log.info("登录操作，放行...");
            filterChain.doFilter(request, response);
            return;
        }

        // 3. 获取令牌
        String jwt = req.getHeader("token");

        // 4. 令牌不存在
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头为空...");
            Result error = Result.error("NOT_LOGIN");

            // 手动把 对象 转 json ：阿里巴巴的 fastJson
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        // 5. 令牌存在 校验合法性
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败 返回账号未登录...");
            Result error = Result.error("NOT_LOGIN");

            // 手动把 对象 转 json ：阿里巴巴的 fastJson
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        // 6. 放行
        log.info("令牌合法，放行...");
        filterChain.doFilter(request, response);
    }
}
