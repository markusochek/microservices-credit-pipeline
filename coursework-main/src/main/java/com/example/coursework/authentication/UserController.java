package com.example.coursework.authentication;

import com.example.coursework.answer.Answer;
import com.example.coursework.authentication.enumerations.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final Answer<User> answerUser;

    @PostMapping("authorization")
    public String authorization(@RequestBody User user) throws JsonProcessingException, NoSuchAlgorithmException {
        String token = userService.authorization(user);
        if (token != null) {return answerUser.json(Status.OK, token);}
        return answerUser.json(Status.ERROR);
    }

    @PostMapping("registration")
    public String registration(@RequestBody User user) throws JsonProcessingException, NoSuchAlgorithmException {
        return answerUser.json(Status.OK, userService.registration(user));
    }
}
