package com.idealctvm.trackassets.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class AlphaVantageClient {
    @Value("${alpha.vantage.api.key}")
    private String API_KEY;
    private static final String BASE_URL = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=";

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public Double getPrice(String symbol){
        try {
            String url = BASE_URL + symbol + "&apikey=" + API_KEY;

            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

            JsonNode priceNode = mapper.readTree(response)
                    .path("Global Quote")
                    .path("05. price");

            return priceNode.isMissingNode() ? null : priceNode.asDouble();

        } catch (Exception e) {
            throw new RuntimeException("Error fetching asset price " + symbol, e);
        }
    }
}
