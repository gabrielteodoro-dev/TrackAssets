package com.idealctvm.trackassets.controller;

import com.idealctvm.trackassets.model.Asset;
import com.idealctvm.trackassets.service.AssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/asset")
public class AssetController {
    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping("/{symbol}")
    public Asset getPrice(@PathVariable String symbol) throws IOException, InterruptedException {
        return assetService.getPrice(symbol);
    }
}
