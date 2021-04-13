package com.popovich.scrap;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScraperService
{
    private static final String URL = "https://yandex.ru/";

    private final ChromeDriver driver;

    public void scrape (final String value) {
        driver.get(URL + "search/?text=" + value);
        final WebElement words = driver.findElementByClassName("")

    }
}
