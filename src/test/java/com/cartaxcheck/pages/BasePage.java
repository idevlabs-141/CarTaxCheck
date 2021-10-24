package com.cartaxcheck.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BasePage {

    @Autowired
    public WebDriver driver;

    @PostConstruct
    public void initDriver() {
        PageFactory.initElements(driver, this);
    }

    public void close() {
        this.driver.close();
        this.driver.quit();
    }

    public void navigate(String url) {
        this.driver.navigate().to(url);
    }
}

