package com.netcracker.fapi.service;

import com.netcracker.fapi.entity.Wallet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WalletService {

    @Value("${backend.url}")
    private String backendUrl;

    private final RestTemplate restTemplate;

    public WalletService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<List> findWalletsByUser(Long userId, int page) {
        return restTemplate.getForEntity(backendUrl + "/byUser/" + userId, List.class, page);
    }

    public void addFunds(Long walletId, Double amount) {
        restTemplate.postForObject(backendUrl + "/wallet/" + walletId + "/addFunds/" + amount, HttpMethod.POST, Wallet.class);
    }

    public void addWallet(Wallet wallet, Long userId) {
        restTemplate.postForObject(backendUrl + "/wallet/"+userId+"/add", wallet, Wallet.class);
    }
}
