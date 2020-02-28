package com.sample.login.domain.model;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private Integer age;
    private String name;
    private String userName;
    private String password;
    private String role;
}
