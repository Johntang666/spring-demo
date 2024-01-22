package com.tang.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
public class MainApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(MainApplication.class, args);
        ConfigurableEnvironment environment = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = environment.getProperty("server.port");
        String path = environment.getProperty("server.servlet.context-path");
        path = path == null ? "" : path;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n------------------------------------------------------\n\t");
        stringBuilder.append("Local:\thttp://localhost:"+port+path+"/\n\t");
        log.info(stringBuilder.toString());
    }
}
