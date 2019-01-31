package com.briandevins.nativeimages;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class HelloWorld extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorld().run(args);
    }

    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
        HelloWorldEndpoints endpoints = new HelloWorldEndpoints();
        environment.jersey().register(endpoints);
    }
}
