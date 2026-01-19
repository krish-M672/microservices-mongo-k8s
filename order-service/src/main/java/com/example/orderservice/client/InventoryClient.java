package com.example.orderservice.client;

import com.example.orderservice.api.InventoryCheckResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class InventoryClient {

    private final WebClient webClient;

    public InventoryClient (@Value("${inventory.base-url}") String inventoryServiceUrl){
        this.webClient = WebClient.builder().baseUrl(inventoryServiceUrl).build();
    }

    public Mono<InventoryCheckResponse> check(String sku, int qty){

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/inventory/check")
                        .queryParam("sku",sku)
                        .queryParam("qty", qty)
                        .build())
                .retrieve()
                .bodyToMono(InventoryCheckResponse.class)
                .timeout(Duration.ofSeconds(5));
    }

}
