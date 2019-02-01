package com.briandevins.nativeimages;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.ExecutorThreadPool;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.JettyHttpHandlerAdapter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.startNettyServer();
    }

    public RouterFunction<ServerResponse> routingFunction() {
        return route(GET("/").and(accept(MediaType.TEXT_PLAIN)), r -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, Spring!")));
    }

    public void startNettyServer() throws Exception {
        RouterFunction<ServerResponse> routerFunction = routingFunction();
        HttpHandler httpHandler = toHttpHandler(routerFunction);

        JettyHttpHandlerAdapter adapter = new JettyHttpHandlerAdapter(httpHandler);
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");

        ServletHolder servletHolder = new ServletHolder();
        servletHolder.setServlet(adapter);
        servletHolder.setName("HelloWorld");

        context.addServlet(servletHolder, "/*");
        server.setHandler(context);
        server.start();
        server.join();
    }
}
