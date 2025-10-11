package com.idealctvm.trackassets.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class AlphaVantageClient {
    private static final String API_KEY = "7M89TD8HTC47BV5J";
    private static final String BASE_URL = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=";

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public Double getPrince(String symbol){
        try {
            String URL = BASE_URL + symbol + "&apikey=" + API_KEY;

            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(URL))
                    .GET()
                    .build();

            String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

            JsonNode princeNode = mapper.readTree(response)
                    .path("Global Quote")
                    .path("05. price");

            return princeNode.isMissingNode() ? null : princeNode.asDouble();

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }
}
