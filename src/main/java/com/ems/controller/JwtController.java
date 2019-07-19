package com.ems.controller;

import com.ems.bean.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class JwtController {

    @Autowired

    private Jwt jwt;

    private AtomicInteger atomicInteger = new AtomicInteger();

    @GetMapping("/jwt")
    public String jwt(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("abc", "bcd");
        cookie.setMaxAge(3000);
        response.addCookie(cookie);
        return "jwt";
    }

    @GetMapping("/auth")
    public String auth(HttpServletRequest request,@CookieValue(value = "abc",required = true,defaultValue = "efd") String cookie) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        System.out.println(cookie);
        return jwt.authtication("abc");
    }
}
