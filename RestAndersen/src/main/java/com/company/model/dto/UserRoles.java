package com.company.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRoles {

    private String username;

    private List<String> roles;
}
