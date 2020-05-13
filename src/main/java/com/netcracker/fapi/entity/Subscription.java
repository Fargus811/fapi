package com.netcracker.fapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class Subscription {

    private Long id;

    private SubuService subuService;

    private User user;

    private boolean status = true;

    private Wallet wallet;

    private Date lastPaidDate;

}
