package com.netcracker.fapi.service;

import com.netcracker.fapi.entity.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class TransactionService {

    @Value("${backend.url}")
    private String backendUrl;

    private final RestTemplate restTemplate;

    public TransactionService (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public List<Transaction> findTransactionsBySenderAndReceiver(Long walletId) {
        ResponseEntity<List> transactions = restTemplate.getForEntity(backendUrl + "/user/wallets/" + walletId, List.class);
        return transactions.getBody();
    }
}
