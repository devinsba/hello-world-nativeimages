package com.briandevins.nativeimages;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;

import java.util.concurrent.CompletableFuture;

public class HelloWorld {
    public static void main(String[] args) {
        System.setProperty("com.linecorp.armeria.useEpoll", "false");
        System.setProperty("io.netty.noUnsafe", "true");

        ServerBuilder sb = new ServerBuilder();
        sb.http(8080);
        sb.service("/", (ctx, res) -> HttpResponse.of("Hello, world!"));
// TODO: Configure your server here.
        Server server = sb.build();
        CompletableFuture<Void> future = server.start();
// Wait until the server is ready.
        future.join();
    }
}
