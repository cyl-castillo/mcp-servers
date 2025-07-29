package com.example.mcp.controller;

import com.example.mcp.dto.CodeRequest;
import com.example.mcp.service.OpenAiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes an endpoint to analyze code using OpenAI.
 */
@RestController
@RequestMapping("/analyze")
public class AnalysisController {

    private final OpenAiService openAiService;

    public AnalysisController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping
    public ResponseEntity<String> analyze(@RequestBody CodeRequest request) {
        String result = openAiService.analyze(request.getCode());
        return ResponseEntity.ok(result);
    }
}
