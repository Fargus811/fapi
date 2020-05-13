package com.netcracker.fapi.controller;

import com.netcracker.fapi.entity.Transaction;
import com.netcracker.fapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/user/wallets/transactions/{walletId}")
    public List<Transaction> findTransactionsBySenderAndReceiver(@PathVariable Long walletId) {
        return transactionService.findTransactionsBySenderAndReceiver(walletId);
    }
}
