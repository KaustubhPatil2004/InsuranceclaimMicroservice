package com.example.createclaim.service.impl;

import com.example.createclaim.dto.ClaimDTO;
import com.example.createclaim.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Value("${database.service.url}")
    private String dbServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object createClaim(ClaimDTO claimDTO) {
        ResponseEntity<Object> response = restTemplate.postForEntity(
            dbServiceUrl + "/claims", claimDTO, Object.class);
        return response.getBody();
    }
}
