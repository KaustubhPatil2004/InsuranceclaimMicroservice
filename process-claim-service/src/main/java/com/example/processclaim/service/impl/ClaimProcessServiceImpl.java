package com.example.processclaim.service.impl;

import com.example.processclaim.service.ClaimProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class ClaimProcessServiceImpl implements ClaimProcessService {

    @Value("${database.service.url}")
    private String dbServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object processClaim(Long claimId, boolean approve) {
        Map claim = restTemplate.getForObject(dbServiceUrl + "/claims/" + claimId, Map.class);
        if (claim == null) return null;

        BigDecimal amount = new BigDecimal(claim.get("claimAmount").toString());
        String status = claim.get("status").toString();

        if (amount.compareTo(new BigDecimal("50000000")) < 0) {
            claim.put("status", "Approved");
        } else if ("Pending".equals(status)) {
            claim.put("status", "Reviewed");
        } else {
            claim.put("status", approve ? "Approved" : "Rejected");
        }

        restTemplate.put(dbServiceUrl + "/claims/" + claimId, claim);
        return claim;
    }
}
