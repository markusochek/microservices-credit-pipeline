package com.example.coursework.authentication;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String login;
    @Column(unique = true)
    private String name;
    private String password;
    private String token;

    public User(String login, String name, String password, String token) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.token = token;
    }
}