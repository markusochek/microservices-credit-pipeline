package com.example.coursework.cookies;

import com.example.coursework.answer.Answer;
import com.example.coursework.authentication.enumerations.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class CookieController {
    private final Answer<String> answer;

    @PostMapping("setCookie")
    public String setCookie(@RequestBody CookieEntity cookieEntity, HttpServletResponse response)
            throws JsonProcessingException {
        Cookie cookie = new Cookie(cookieEntity.getName(), cookieEntity.getValue());
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        return answer.json(Status.OK);
    }

    @PostMapping("checkCookie")
    public String checkCookie(@RequestBody CookieEntity cookieEntity, HttpServletRequest request)
            throws JsonProcessingException {
        Cookie[] cookies = request.getCookies();
        String name = cookieEntity.getName();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return answer.json(Status.OK);
                }
            }
        }
        return answer.json(Status.ERROR);
    }

    public String checkToken(HttpServletRequest request) {
        String name = "token";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    @PostMapping("unsetCookie")
    public String unsetCookie(@RequestBody CookieEntity cookieEntity, HttpServletResponse response)
            throws JsonProcessingException {
        Cookie cookie = new Cookie(cookieEntity.getName(), "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return answer.json(Status.OK);
    }
}
