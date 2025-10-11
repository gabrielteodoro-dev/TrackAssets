package com.idealctvm.trackassets.service;

import com.idealctvm.trackassets.client.AlphaVantageClient;
import com.idealctvm.trackassets.model.Asset;
import com.idealctvm.trackassets.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class AssetService {
    private final AlphaVantageClient alphaVantageClient;

    public AssetService(AlphaVantageClient alphaVantageClient) {
        this.alphaVantageClient = alphaVantageClient;
    }

    public Asset getPrice(String symbol) throws IOException, InterruptedException {
        Double price = alphaVantageClient.getPrince(symbol);

        return new Asset(symbol,price);
    }
}
