package com.itheima.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    // 目标资源方法运行前运行 true：放行 false：不放行
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        // 1. 获取 url
        String url = req.getRequestURI();
        log.info("请求的 url {}", url);

        // 2. 判断是否包含 login
        if (url.contains("login")) {
            log.info("登录操作，放行...");
            return true;
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
            return false;
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
            return false;
        }

        // 6. 放行
        log.info("令牌合法，放行...");
        return true;
    }

    // 目标资源方法运行后运行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle 运行了...");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // 视图渲染完毕后 最后运行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion 运行了...");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
