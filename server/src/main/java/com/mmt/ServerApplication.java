package com.mmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServerApplication {
    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(ServerApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
    }
}
