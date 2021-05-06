package com.github.fendansas.onlinestore.smoketest;

import com.github.fendansas.onlinestore.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerSmokeTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HomeController homeController;

    // тест на наличие контекста
    @Test
    public void contextLoads() throws Exception {
        assertThat(homeController).isNotNull();
    }
}
