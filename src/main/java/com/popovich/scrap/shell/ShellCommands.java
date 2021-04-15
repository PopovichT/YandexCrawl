package com.popovich.scrap.shell;

import com.popovich.scrap.client.SeleniumYandexClient;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class ShellCommands {

    private final SeleniumYandexClient seleniumYandexClient;

    @Autowired
    public ShellCommands(SeleniumYandexClient seleniumYandexClient){
        this.seleniumYandexClient = seleniumYandexClient;
    }

    @ShellMethod("Scrap links by word")
    public List<String> scrape(String input) throws InterruptedException {
        return seleniumYandexClient.scrape(input);
    }
}
