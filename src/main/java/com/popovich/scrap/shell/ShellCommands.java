package com.popovich.scrap.shell;

import com.popovich.scrap.client.SeleniumYandexClient;
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
    public String scrape(String input, int page, int number) throws InterruptedException {
        return seleniumYandexClient.scrapCertainLink(input, page, number);
    }
}
