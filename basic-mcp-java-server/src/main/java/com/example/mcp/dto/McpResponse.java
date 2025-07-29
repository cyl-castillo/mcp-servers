package com.example.mcp.dto;

import java.time.Instant;
import java.util.Map;

/**
 * Response sent back for MCP requests.
 */
public class McpResponse {
    private String status;
    private Map<String, Object> receivedContext;
    private Instant date;

    public McpResponse(String status, Map<String, Object> receivedContext) {
        this.status = status;
        this.receivedContext = receivedContext;
        this.date = Instant.now();
    }

    public String getStatus() {
        return status;
    }

    public Map<String, Object> getReceivedContext() {
        return receivedContext;
    }

    public Instant getDate() {
        return date;
    }
}
