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
        Double price = alphaVantageClient.getPrince(symbol);

        return new Asset(symbol,price);
    }
}
