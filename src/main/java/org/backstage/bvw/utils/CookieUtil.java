package org.backstage.bvw.utils;

import com.mysql.fabric.xmlrpc.base.Data;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@CrossOrigin
@Controller
public class CookieUtil {

    @GetMapping("/set-cookie")
    public static void setCookies(@RequestParam("cookie") String cookieValue, HttpServletResponse response) {
        try {
            cookieValue = URLEncoder.encode(cookieValue,"utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        Cookie cookie = new Cookie("username", cookieValue);
        cookie.setMaxAge(90000);
        response.addCookie(cookie);
    }

    @GetMapping("/get-cookie")
    public static String getCookie(@RequestParam("cookie") String username, HttpServletRequest request){
        System.out.println(username);
        Cookie[] cookies = request.getCookies();
        String content = "";
        if(cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies){
                String name = cookie.getName();
                if(username.equals(name)){
                    content = cookie.getValue();
                }
            }
        }
        return content;
    }
}
