package com.example.brew.backend.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController     // rest controller class for http requests
public class PlacesController {
    
    @Value("${geoapify.api.key}")
    private String apiKey;

    // webclient to do http requests
    private final WebClient webClient = WebClient.create();

    @GetMapping("/places/nearby")
    public Mono<String> getNearbyCafes(
        @RequestParam double lat,   // requests lat coords
        @RequestParam double lon,   // long coords
        @RequestParam(defaultValue = "10") int limit) { // max places to return

        // cirlce filter instead of rect
        String url = String.format(
                "https://api.geoapify.com/v2/places?categories=catering.cafe&filter=circle:%f,%f,3000&limit=%d&apiKey=%s",
                lon, lat,limit, apiKey
        );

        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);

        }
    
    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
    
}

