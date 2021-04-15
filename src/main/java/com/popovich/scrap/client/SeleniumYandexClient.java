package com.popovich.scrap.client;

import com.popovich.scrap.config.SeleniumConfig;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeleniumYandexClient {

    private SeleniumConfig config;
    public static final String URL = "https://relatedwords.org/relatedto/";
  //    "search/?text="
    public SeleniumYandexClient() {
        config = new SeleniumConfig();
        config.getDriver().get(URL);
    }

    public List<String> scrape(String word) throws InterruptedException {
        config.getDriver().get(URL + word);
        Thread.sleep(5000);
        //final List<WebElement> itemList = config.getDriver().findElements(By.cssSelector("a[class*='organic__url']"));
        final WebElement words = config.getDriver().findElement(By.className("words"));
        final List<WebElement> itemList = words.findElements(By.tagName("a"));
        List<String> strings = null;
        itemList.forEach(item -> strings.add(item.getText()));
        return strings;
        //config.getDriver().close();

    }

}
