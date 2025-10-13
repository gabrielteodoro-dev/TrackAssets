package com.idealctvm.trackassets.service;

import com.idealctvm.trackassets.client.AlphaVantageClient;
import com.idealctvm.trackassets.model.Asset;
import com.idealctvm.trackassets.model.Portfolio;
import com.idealctvm.trackassets.repository.AssetRepository;
import com.idealctvm.trackassets.repository.PortfolioRepository;
import com.idealctvm.trackassets.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PortfolioService {
    private PortfolioRepository portfolioRepository;
    private AssetRepository assetRepository;
    private AlphaVantageClient alphaVantageClient;
    private UserRepository userRepository;

    public PortfolioService(PortfolioRepository portfolioRepository, AssetRepository assetRepository, AlphaVantageClient alphaVantageClient) {
        this.portfolioRepository = portfolioRepository;
        this.assetRepository = assetRepository;
        this.alphaVantageClient = alphaVantageClient;
    }

    public Asset addAsset(Long userId, String symbol) {
        Double price = alphaVantageClient.getPrice(symbol);
        Asset asset = new Asset(symbol.toUpperCase(), price);
        if(price == null) {
            throw new RuntimeException("Asset not found or invalid symbol: " + symbol);
        }
        assetRepository.save(asset);

        portfolioRepository.save(new Portfolio(userId,asset));
        return asset;
    }

    public List<Map<String, Object>> getPortfolio(Long userId) {
        List<Portfolio> listPortfolio = portfolioRepository.findByUserId(userId);

        List<Map<String,Object>> resp = new ArrayList<>();

        for (Portfolio item : listPortfolio){
            String symbol = item.getAsset().getSymbol();
            Double price = alphaVantageClient.getPrice(symbol);

            Map<String,Object> assets = new HashMap<>();

            assets.put("Symbol",symbol);
            assets.put("Price",price);

            resp.add(assets);
        }
        return resp;
    }

    public void removeAsset(Long userId, String symbol) {
        List<Portfolio> portfolio = portfolioRepository.findByUserId(userId);

        Portfolio portfolioItem = portfolio.stream()
                .filter(p -> p.getAsset().getSymbol().equalsIgnoreCase(symbol))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Asset not found in portfolio: " + symbol));

        portfolioRepository.delete((portfolioItem));
    }
}
