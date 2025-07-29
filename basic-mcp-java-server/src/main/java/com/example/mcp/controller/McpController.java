package com.example.mcp.controller;

import com.example.mcp.dto.McpRequest;
import com.example.mcp.dto.McpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that handles MCP requests.
 */
@RestController
@RequestMapping("/mcp")
public class McpController {

    /**
     * Accepts MCP requests and echoes the received context.
     *
     * @param request incoming MCP request
     * @return response with status and received context
     */
    @PostMapping
    public ResponseEntity<McpResponse> handleMcp(@RequestBody McpRequest request) {
        McpResponse response = new McpResponse("ok", request.getContext());
        return ResponseEntity.ok(response);
    }
}
