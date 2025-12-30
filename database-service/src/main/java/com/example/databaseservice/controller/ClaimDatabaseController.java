package com.example.databaseservice.controller;

import com.example.databaseservice.entity.Claim;
import com.example.databaseservice.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/database")
public class ClaimDatabaseController {

    @Autowired
    private ClaimRepository claimRepository;

    @PostMapping("/claims")
    public Claim saveClaim(@RequestBody Claim claim) {
        claim.setStatus("Pending");
        return claimRepository.save(claim);
    }

    @GetMapping("/claims")
    public List<Claim> getAllClaims() {
        return claimRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @GetMapping("/claims/{id}")
    public Claim getClaimById(@PathVariable Long id) {
        return claimRepository.findById(id).orElse(null);
    }

    @PutMapping("/claims/{id}")
    public Claim updateClaim(@PathVariable Long id, @RequestBody Claim updatedClaim) {
        Claim claim = claimRepository.findById(id).orElse(null);
        if (claim != null) {
            claim.setStatus(updatedClaim.getStatus());
            return claimRepository.save(claim);
        }
        return null;
    }
}
