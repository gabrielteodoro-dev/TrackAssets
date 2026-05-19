package com.gabrielteodoro.trackassets.service;

import com.gabrielteodoro.trackassets.client.AlphaVantageClient;
import com.gabrielteodoro.trackassets.model.Asset;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AssetService {
    private final AlphaVantageClient alphaVantageClient;

    public Asset getPrice(String symbol){
        BigDecimal price = alphaVantageClient.getPrice(symbol);
        if(price == null){
            throw new RuntimeException("Asset not found or invalid symbol: " + symbol);
        }
        return new Asset(symbol,price);
    }
}
