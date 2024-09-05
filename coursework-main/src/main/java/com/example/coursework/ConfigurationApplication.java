package com.example.coursework;

import com.example.coursework.answer.Answer;
import com.example.coursework.authentication.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationApplication {
    @Bean
    Answer<String> answer() {
        return new Answer<>();
    }
    @Bean
    Answer<User> answerUser() {
        return new Answer<>();
    }
    @Bean
    Answer<Object> answerObject() {
        return new Answer<>();
    }

}
