package com.popovich.scrap.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SeleniumConfig {

    @PostConstruct
    void postConstruct()
    {
        System.setProperty("webdriver.chrome.driver", "/home/taras/Desktop/WebDrivers/chromedriver");
    }

    @Bean
    public ChromeDriver driver()
    {
        return new ChromeDriver();
    }
}
