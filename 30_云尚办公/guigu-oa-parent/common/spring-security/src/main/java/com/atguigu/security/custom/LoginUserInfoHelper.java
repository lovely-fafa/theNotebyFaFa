package com.atguigu.security.custom;

public class LoginUserInfoHelper {

    private static final ThreadLocal<Long> userId = new ThreadLocal<Long>();
    private static final ThreadLocal<String> username = new ThreadLocal<String>();

    public static void setUsername(String _username) {
        username.set(_username);
    }
    public static void setUserId(Long _userId) {
        userId.set(_userId);
    }


    public static void removeUserId() {
        userId.remove();
    }

    public static void removeUsername() {
        username.remove();
    }

    public static Long getUserId() {
        return userId.get();
    }
    public static String getUsername() {
        return username.get();
    }
}
