package com.netcracker.fapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Wallet {

    private Long id;

    private User user;

    private double balance;

    private String currency;
}
