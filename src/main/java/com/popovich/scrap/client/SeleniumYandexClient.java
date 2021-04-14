package com.popovich.scrap.client;

import com.popovich.scrap.config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class SeleniumYandexClient {

    private SeleniumConfig config;
    public static final String URL = "https://yandex.ru/";

    public SeleniumYandexClient() {
        config = new SeleniumConfig();
        config.getDriver().get(URL);
    }

//    @PostConstruct
//    void postConstruct()
//    {
//        List<WebElement> list = scrape("автомобиль");
//        list.forEach(item -> System.out.println(item.getText()));
//    }

    public List<WebElement> scrape(String word) {
        config.getDriver().get(URL + "search/?text=" + word);
        final List<WebElement> itemList = config.getDriver().findElements(By.cssSelector("a[class*='organic__url']"));
        config.getDriver().quit();
        return itemList;
    }

}
