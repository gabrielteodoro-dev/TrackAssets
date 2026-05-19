package com.gabrielteodoro.trackassets.controller;

import com.gabrielteodoro.trackassets.model.Asset;
import com.gabrielteodoro.trackassets.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;

    // Add asset to portfolio
    @PostMapping("/users/{userId}/assets")
    public Asset addAsset(@PathVariable Long userId, @RequestBody Asset asset){
        return portfolioService.addAsset(userId,asset.getSymbol());
    }

    // List portfolio
    @GetMapping("/users/{userId}/assets")
    public List<Map<String, Object>> getPortfolio(@PathVariable Long userId){
        return portfolioService.getPortfolio(userId);
    }

    // Delete an asset from the user's portfolio
    @DeleteMapping("/users/{userId}/assets/{symbol}")
    public String removeAsset(@PathVariable Long userId, @PathVariable String symbol){
        portfolioService.removeAsset(userId,symbol);
        return "Asset removed successfully";
    }
}
