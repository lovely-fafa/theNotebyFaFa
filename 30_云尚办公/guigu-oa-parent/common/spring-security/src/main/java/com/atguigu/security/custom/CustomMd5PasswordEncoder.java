package com.atguigu.security.custom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomMd5PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        log.info("密码加密 | pwd={}", rawPassword);
        return rawPassword.toString();
        // return MD5Encoder.encode(rawPassword.toString().getBytes());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        log.info("密码校验 | rawPassword={} encodedPassword={}", rawPassword, encodedPassword);
        return encodedPassword.equals(encode(encodedPassword));
    }
}
