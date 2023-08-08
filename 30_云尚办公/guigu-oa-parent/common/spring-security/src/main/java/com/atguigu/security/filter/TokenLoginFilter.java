package com.atguigu.security.filter;

import com.alibaba.fastjson.JSON;
import com.atguigu.common.jwt.JwtHelper;
import com.atguigu.common.result.ResponseUtil;
import com.atguigu.common.result.Result;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.model.system.LoginVo;
import com.atguigu.security.custom.CustomUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Slf4j
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    private RedisTemplate redisTemplate;

    // 1 构造方法
    public TokenLoginFilter(AuthenticationManager authenticationFilter, RedisTemplate redisTemplate) {
        this.setAuthenticationManager(authenticationFilter);
        this.setPostOnly(false);
        // 指定登录接口及提交方式，可以指定任意路径
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/user/login", "POST"));
        this.redisTemplate = redisTemplate;
    }


    // 2 登录认证
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        log.info("用户登录...");
        try {
            // 获取用户的信息
            LoginVo loginVo = new ObjectMapper().readValue(request.getInputStream(), LoginVo.class);
            log.info("用户登录 | info={}", loginVo);
            // 封装对象
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginVo.getUsername(),
                    loginVo.getPassword());
            return this.getAuthenticationManager().authenticate(token);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 认证成功
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        log.info("登录校验成功");
        // 获取当前用户
        CustomUser customUser = (CustomUser) authResult.getPrincipal();

        redisTemplate.opsForValue().set(customUser.getSysUser().getUsername(),
                JSON.toJSONString(customUser.getAuthorities()));

        // 生成token
        String jwt = JwtHelper.createToken(customUser.getSysUser().getId(), customUser.getSysUser().getUsername());
        log.info("生成 jwt 令牌 | jwt={}", jwt);
        // 返回
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", jwt);

        ResponseUtil.out(response, Result.success(map));
    }

    /**
     * 认证失败
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        log.warn("登录校验失败");
        ResponseUtil.out(response, Result.build(null, ResultCodeEnum.LOGIN_ERROR));
    }
}
