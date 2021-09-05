package com.company.model.dto;

import com.company.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDto {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public User toUser() {
        return User.builder()
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .password(password)
                .email(email)
                .build();
    }
}
