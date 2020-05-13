package com.netcracker.fapi.controller;

import com.netcracker.fapi.entity.Wallet;
import com.netcracker.fapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallet/")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/{userId}")
    public ResponseEntity<List> findWalletsByUser(@PathVariable Long userId, @RequestParam(defaultValue = "0") int page) {
        return walletService.findWalletsByUser(userId,page);
    }


    @GetMapping("/{walletId}/addFunds/{amount}")
    public void addFunds(@PathVariable Long walletId, @PathVariable Double amount) {
        walletService.addFunds(walletId, amount);
    }

    @PostMapping("/{userId}/add")
    public void addWallet(@PathVariable Long userId, @RequestBody Wallet wallet) {
        walletService.addWallet(wallet, userId);
    }
}
