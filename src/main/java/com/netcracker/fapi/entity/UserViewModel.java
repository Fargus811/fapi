package com.netcracker.fapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserViewModel {

    private Long id;

    private String name;

    private String email;

    private Role role;

}
