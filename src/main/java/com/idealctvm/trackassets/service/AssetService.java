package com.idealctvm.trackassets.service;

import com.idealctvm.trackassets.client.AlphaVantageClient;
import com.idealctvm.trackassets.model.Asset;
import org.springframework.stereotype.Service;

@Service
public class AssetService {
    private final AlphaVantageClient alphaVantageClient;

    public AssetService(AlphaVantageClient alphaVantageClient) {
        this.alphaVantageClient = alphaVantageClient;
    }

    public Asset getPrice(String symbol){
        Double price = alphaVantageClient.getPrice(symbol);
        if(price == null){
            throw new RuntimeException("Asset not found or invalid symbol: " + symbol);
        }
        return new Asset(symbol,price);
    }
}
