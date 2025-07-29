# Java MCP Server

This example demonstrates a minimal MCP server written in Java. The server uses the JDK's built-in HTTP server and exposes a simple `/hello` endpoint.

## Building and Running

```bash
mvn package
java -cp target/java-mcp-server-0.1.0.jar com.mcp.server.McpServer
```

The server listens on port `8080`. You can test it by opening `http://localhost:8080/hello` in your browser or using `curl`.

## Importing into IntelliJ IDEA

1. Open IntelliJ IDEA and choose **Open**.
2. Select the `java-intellij-server` directory. IntelliJ will automatically detect the Maven project.
3. Once the project loads, you can run `McpServer` directly from the IDE using the run icon next to the `main` method.

This setup allows you to modify and debug the server inside IntelliJ, making it easy to extend its functionality.
