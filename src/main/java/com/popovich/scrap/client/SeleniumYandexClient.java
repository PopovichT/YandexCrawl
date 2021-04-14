package com.popovich.scrap.client;

import com.popovich.scrap.config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeleniumYandexClient {

    private SeleniumConfig config;
    public static final String URL = "https://yandex.ru/";

    public SeleniumYandexClient() {
        config = new SeleniumConfig();
        config.getDriver().get(URL);
    }
//    public void search(String word) {
//        config.getDriver().get(URL + "search/?text=" + word);
//        List<WebElement> list = scrape();
//    }

    public List<WebElement> scrape(String word) {
        config.getDriver().get(URL + "search/?text=" + word);
        final WebElement item = config.getDriver().findElement(By.className("path organic_path"));
        final List<WebElement> itemList = item.findElements(By.tagName("a"));
        config.getDriver().quit();
        return itemList;
    }

}
