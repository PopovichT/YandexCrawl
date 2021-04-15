package com.popovich.scrap.client;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SeleniumYandexClientTest {

    private SeleniumYandexClient seleniumYandexClient = new SeleniumYandexClient();

    @Test
    void testCanClientParseLinks() throws InterruptedException {
        assertNotNull(seleniumYandexClient.scrapCertainLink("car", 2, 3));
    }
}

