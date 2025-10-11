package com.idealctvm.trackassets.controller;

import com.idealctvm.trackassets.model.Asset;
import com.idealctvm.trackassets.model.Portfolio;
import com.idealctvm.trackassets.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    private PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    // Add asset to portfolio
    @PostMapping("/users/{userId}/assets")
    public Asset addAsset(@PathVariable Long userId,@RequestBody Asset asset){
        return portfolioService.addAsset(userId,asset.getSymbol());
    }

    // List portfolio
    @GetMapping("/users/{userId}/assets")
    public List<Map<String, Object>> getPortfolio(@PathVariable Long userId){
        return portfolioService.getPortfolio(userId);
    }
}
