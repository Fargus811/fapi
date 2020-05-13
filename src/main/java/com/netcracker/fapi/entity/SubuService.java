package com.netcracker.fapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubuService {

    private Long id;

    private User user;

    private String name;

    private float cost;

    private String description;

    private Wallet wallet;
}
