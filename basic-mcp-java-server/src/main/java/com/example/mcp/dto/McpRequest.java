package com.example.mcp.dto;

import java.util.Map;

/**
 * Represents an incoming MCP request payload.
 */
public class McpRequest {
    private Map<String, Object> context;
    private Object history;
    private Object tools;

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }

    public Object getHistory() {
        return history;
    }

    public void setHistory(Object history) {
        this.history = history;
    }

    public Object getTools() {
        return tools;
    }

    public void setTools(Object tools) {
        this.tools = tools;
    }
}
