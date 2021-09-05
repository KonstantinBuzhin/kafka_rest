package com.company.model.dto;

import com.company.model.Status;
import com.company.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Status status;

    public void applyChanges(User user) {
        user.setStatus(status);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
    }
}
