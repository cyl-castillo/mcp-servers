# Basic MCP Java Server

This module contains a minimal Spring Boot application that demonstrates how to handle
Model Context Protocol (MCP) style requests. It exposes two endpoints:

- `POST /mcp` accepts a JSON payload with `context`, `history`, and `tools` fields and
  returns the received context along with a status message and the current date.
- `GET /health` returns `OK` to verify the service is running.

The project is structured to allow easy extension for tools, history management,
and user handling. A new endpoint demonstrates how to integrate with external
services like OpenAI for code analysis.

## New `/analyze` Endpoint

`POST /analyze` accepts a JSON payload with a `code` field. The server forwards
this code to the OpenAI API (if an API key is configured via the
`openai.api.key` property) and returns the assistant's response. When no API key
is provided, a placeholder message is returned.
