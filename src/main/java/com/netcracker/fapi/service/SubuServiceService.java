package com.netcracker.fapi.service;

import com.netcracker.fapi.entity.SubuService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class SubuServiceService {

    @Value("${backend.url}")
    private String backendUrl;

    private final RestTemplate restTemplate;

    public SubuServiceService (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public List<SubuService> findAll(int page) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(backendUrl + "/service/all")
                .queryParam("page", page);
        return restTemplate.getForObject(builder.toUriString(), List.class);
    }

    public List<SubuService> findSubuServiceByUser(Long userId, int page) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(backendUrl + "/service/"+userId)
                .queryParam("page", page);
        return restTemplate.getForObject(builder.toUriString(), List.class);
    }

    public void createSubuService(Long userId, SubuService subuService) {
        restTemplate.postForObject(backendUrl + "/"+userId+"/add", subuService, SubuService.class);
    }
}
