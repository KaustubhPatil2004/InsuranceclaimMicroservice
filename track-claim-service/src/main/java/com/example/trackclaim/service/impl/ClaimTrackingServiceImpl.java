package com.example.trackclaim.service.impl;

import com.example.trackclaim.service.ClaimTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class ClaimTrackingServiceImpl implements ClaimTrackingService {

    @Value("${database.service.url}")
    private String dbServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Map<String, Object>> trackAllClaims() {
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
            dbServiceUrl + "/claims",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Map<String, Object>>>() {}
        );
        return response.getBody();
    }
}
