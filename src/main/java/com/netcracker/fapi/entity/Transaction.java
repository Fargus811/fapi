package com.netcracker.fapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Transaction {

    private Long id;

    private Wallet receiver;

    private Wallet sender;

    private Double amount;

    private Date date;
}
