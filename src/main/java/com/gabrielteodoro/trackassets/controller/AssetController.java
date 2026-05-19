package com.gabrielteodoro.trackassets.controller;

import com.gabrielteodoro.trackassets.model.Asset;
import com.gabrielteodoro.trackassets.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/asset")
public class AssetController {
    private final AssetService assetService;

    // Check asset price
    @GetMapping("/{symbol}")
    public Asset getPrice(@PathVariable String symbol) throws IOException, InterruptedException {
        return assetService.getPrice(symbol);
    }
}
