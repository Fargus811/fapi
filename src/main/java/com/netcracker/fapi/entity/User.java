package com.netcracker.fapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Role role;
}
