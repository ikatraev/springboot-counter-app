package com.franklinamerican.maven.plugin.docker;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class MavenDockerWebHandler {

    private static final AtomicLong counter = new AtomicLong();

    public Mono<ServerResponse> ok(ServerRequest serverRequest) { //NOSONAR
        return ServerResponse.ok()
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .body(Mono.just(StatResponse.create().counter(counter.incrementAndGet()).build()), StatResponse.class);
    }

    @Data
    @Builder(builderMethodName = "create")
    static class StatResponse {
        private long counter;
    }

}
