package com.netcracker.fapi.controller;


import com.netcracker.fapi.entity.Subscription;
import com.netcracker.fapi.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    public SubscriptionService subscriptionService;

    @GetMapping("/{userId}")
    public List<Subscription> findSubscriptionByUser(@PathVariable Long userId, @RequestParam(defaultValue = "0") int page) {
        return subscriptionService.findSubscriptionByUser(userId, page);
    }


    @PostMapping("/add")
    public String subscribe(@RequestParam Long userId, Long serviceId, Long walletId) {
        return subscriptionService.subscribe(userId, serviceId, walletId);

    }

    @PostMapping("/subscriptions/{subscriptionId}")
    public void unsubscribe(@PathVariable Long subscriptionId) {
        subscriptionService.unsubscribe(subscriptionId);
    }

    @GetMapping("/service/{serviceId}/count")
    public BigInteger сountAllSubscribes(@PathVariable Long serviceId) {
        return subscriptionService.countBySubuService(serviceId);
    }

}

