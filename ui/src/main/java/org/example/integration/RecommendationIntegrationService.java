package org.example.integration;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RecommendationIntegrationService {

    private final RestClient restClient;

    public RecommendationIntegrationService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String getRecommendations(String prompt) {
        return restClient.get()
                .uri("http://localhost:8081/v1/recommendations")
                .attribute("prompt", prompt)
                .retrieve()
                .body(String.class);
    }
}
