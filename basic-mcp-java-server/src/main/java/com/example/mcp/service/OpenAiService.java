package com.example.mcp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service that calls the OpenAI API to analyze code.
 * This is a minimal example and does not cover error handling.
 */
@Service
public class OpenAiService {

    @Value("${openai.api.key:}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String analyze(String code) {
        if (apiKey == null || apiKey.isBlank()) {
            return "OpenAI API key not configured";
        }

        String url = "https://api.openai.com/v1/chat/completions";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, Object> payload = new HashMap<>();
        payload.put("model", "gpt-3.5-turbo");
        payload.put("messages", new Object[] {
                Map.of("role", "system", "content", "You are a code analysis assistant."),
                Map.of("role", "user", "content", code)
        });

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(payload, headers);

        Map<?, ?> response = restTemplate.postForObject(url, request, Map.class);
        if (response == null) {
            return "No response from OpenAI";
        }
        Object choices = response.get("choices");
        if (choices instanceof java.util.List<?> list && !list.isEmpty()) {
            Object first = list.get(0);
            if (first instanceof Map<?, ?> choice) {
                Object message = choice.get("message");
                if (message instanceof Map<?, ?> msg) {
                    Object content = msg.get("content");
                    if (content != null) {
                        return content.toString();
                    }
                }
            }
        }
        return "Unable to parse OpenAI response";
    }
}
