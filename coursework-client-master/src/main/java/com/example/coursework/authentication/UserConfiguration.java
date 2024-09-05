package com.example.coursework.authentication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class UserConfiguration {
    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository userRepository) {
        return args -> {
            List<User> users = List.of(
                    new User("root", "root", "58487D798AD37B94C1A27C99ED25F91F", ""));
            for (User user : users) {
                if (!userRepository.existsByLogin(user.getLogin())) {
                    userRepository.save(user);
                }
            }
        };
    }
}
