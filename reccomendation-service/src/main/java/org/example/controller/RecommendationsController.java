package org.example.controller;

import org.example.controller.dto.RecommendedProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/recommendations")
public class RecommendationsController {

    String promptTemplate = """
            Here is a list of products available in the catalog:
            {catalog}
            
            The user is looking for: {userInput}
            
            Recommend N relevant products from the catalog that can be good for customer.
            N -> requested amount of customer, or 3 by default if amount is not specified
            """;

    private static final Logger LOG = LoggerFactory.getLogger(RecommendationsController.class);

    private ChatClient chatClient;

    public RecommendationsController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping
    public List<RecommendedProductResponse> getProductRecommendation(@RequestParam(value = "prompt") String prompt) {
//        PromptTemplate promptTemplate = new PromptTemplate();
        ChatClient.CallResponseSpec call = this.chatClient.prompt()
                .user("Recommend me any product you want with name and price")
                .call();
        List<RecommendedProductResponse> entity = call.entity(new ParameterizedTypeReference<List<RecommendedProductResponse>>() {})    ;
        return entity;
    }
}
