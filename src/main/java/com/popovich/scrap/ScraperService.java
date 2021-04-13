package com.popovich.scrap;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@AllArgsConstructor
public class ScraperService
{
    private static final String URL = "https://yandex.ru/";

    private final ChromeDriver driver;

    @PostConstruct
    void postConstruct()
    {
        scrape("auto");
    }

    public void scrape (final String value) {
        driver.get(URL + "search/?text=" + value);
        final WebElement item = driver.findElementByClassName("path organic_path");
        final List<WebElement> itemList = item.findElements(By.tagName("a"));
        itemList.forEach(scrapItem -> System.out.println(scrapItem.getText()));
        driver.quit();
    }
}
