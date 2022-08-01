package net.sni.servletbasic.context;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class ServerContext {

    private final String url;

    private ServerContext() {
        final String resourceName = "application.properties";
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final Properties props = new Properties();

        try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            props.load(resourceStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final String serverProtocol = props.getProperty("server.protocol");
        final String serverHost = props.getProperty("server.host");
        final String serverPort = props.getProperty("server.port");
        final String serverController = props.getProperty("server.controller");

        this.url = String.format("%s://%s:%s/%s/", serverProtocol, serverHost, serverPort, serverController);
    }

    public static ServerContext getInstance() {
        return ServerContextHolder.INSTANCE;
    }

    private static class ServerContextHolder {
        private static final ServerContext INSTANCE = new ServerContext();
    }
}
