package com.franklinamerican.maven.plugin.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
@EnableWebFlux
@Import(MavenDockerWebHandler.class)
public class MavenDockerApplication {

    static final String ROOT_PATH = "/";

    public static void main(String[] args) {
        SpringApplication.run(MavenDockerApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(MavenDockerWebHandler handler) {
        return route(GET(ROOT_PATH), handler::ok);
    }

}
