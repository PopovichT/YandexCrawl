package com.popovich.scrap.client;

import com.popovich.scrap.config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeleniumYandexClient {

    private SeleniumConfig config;
    public static final String URL = "https://yandex.ru/";
    public SeleniumYandexClient() {
        config = new SeleniumConfig();
        config.getDriver().get(URL);
    }

    public String scrapCertainLink (String word, int page, int number) throws InterruptedException {
        search(word);
        moveToPage(page);
        List<String> links = scrape();
        return links.get(number);
    }

    private List<String> scrape(){
        final List<WebElement> itemList = config.getDriver().findElements(By.cssSelector("a[class*='organic__url']"));
        List<String> links = new ArrayList<>();
        for (WebElement item : itemList) {
            links.add(item.getAttribute("href"));
        }
        return links;
        //config.getDriver().close();
    }

    private void moveToPage(int page) throws InterruptedException {

        synchronized (config.getDriver())
        {
            config.getDriver().wait(10);
        }

        JavascriptExecutor js = (JavascriptExecutor) config.getDriver();
        config.getDriver().manage().window().maximize();
        js.executeScript("window.scrollBy(0,1000)");
       config.getDriver().findElement(By.cssSelector("a[aria-label='Страница " + page + "']")).click();
    }

    private void search(String word){
        config.getDriver().get(URL + "search/?text=" + word);
    }

}
