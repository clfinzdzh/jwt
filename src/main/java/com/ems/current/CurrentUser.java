package com.ems.current;

import org.springframework.stereotype.Component;

@Component
public class CurrentUser {
    
    private static final ThreadLocal<String> userIdThreadLocal = ThreadLocal.withInitial(() -> "");

    public static void setCurrentUser(String userId) {
        userIdThreadLocal.set(userId);
    }

    public static String getCurrentUser() {
        return userIdThreadLocal.get();
    }

}
