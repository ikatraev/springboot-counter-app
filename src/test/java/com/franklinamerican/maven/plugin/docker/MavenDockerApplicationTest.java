package com.franklinamerican.maven.plugin.docker;

import com.franklinamerican.maven.plugin.docker.MavenDockerWebHandler.StatResponse;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.franklinamerican.maven.plugin.docker.MavenDockerApplication.ROOT_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebFluxTest
class MavenDockerApplicationTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void test() {
        assertEquals(1L, ping().getCounter());
        assertEquals(2L, ping().getCounter());
        assertEquals(3L, ping().getCounter());
        assertEquals(4L, ping().getCounter());
    }

    private StatResponse ping() {
        return webClient.get().uri(ROOT_PATH).exchange().expectBody(StatResponse.class).returnResult().getResponseBody();
    }
}