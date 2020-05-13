package com.netcracker.fapi.service;

import com.netcracker.fapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Value("${backend.url}")
    private String backendUrl;

    private final RestTemplate restTemplate;

    public UserService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<User> findAll(int page) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(backendUrl + "/users/")
                .queryParam("page", page);
        return restTemplate.getForObject(builder.toUriString(), List.class);

    }

    public User findUserById(Long id) {
        ResponseEntity<User> user = restTemplate.getForEntity(backendUrl + "/user/" + id, User.class);
        return user.getBody();
    }

    public HttpStatus createUser(User newUser) {
        User user = new User();
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setRole((newUser.getRole()));
        ResponseEntity<HttpStatus> status = restTemplate.postForEntity(backendUrl + "/registration", user, HttpStatus.class);
        return status.getBody();
    }

    public HttpStatus login(String email, String password) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(backendUrl + "/login")
                .queryParam("email", email)
                .queryParam("password", password);
        return restTemplate.getForObject(builder.toUriString(), HttpStatus.class);

    }
}
