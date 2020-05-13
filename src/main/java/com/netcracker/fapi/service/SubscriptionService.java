package com.netcracker.fapi.service;

import com.netcracker.fapi.entity.Subscription;
import com.netcracker.fapi.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;
import java.util.List;

@Service
public class SubscriptionService {

    @Value("${backend.url}")
    private String backendUrl;

    private final RestTemplate restTemplate;

    public SubscriptionService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Subscription> findSubscriptionByUser(Long userId, int page) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(backendUrl + "/subscriptions/" + userId)
                .queryParam("page", page);
        return restTemplate.getForObject(builder.toUriString(), List.class);
    }

    public String subscribe(Long userId, Long serviceId, Long walletId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(backendUrl + "/subscriptions/" + userId)
                .queryParam("userId", userId).
                        queryParam("serviceId", serviceId).
                        queryParam("walletId", walletId);
        return restTemplate.postForObject(builder.toUriString(), HttpMethod.POST, String.class);
    }

     public void unsubscribe(Long subscriptionId) {
          restTemplate.postForEntity(backendUrl + "/subscriptions/" + subscriptionId, HttpMethod.POST,Subscription.class);
     }

      public BigInteger countBySubuService(Long serviceId) {
          ResponseEntity<BigInteger> count = restTemplate.getForEntity(backendUrl + "/subscriptions/" + serviceId + "/count", BigInteger.class);
          return count.getBody();
      }
}
