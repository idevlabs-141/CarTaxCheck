package com.cartaxcheck.pages;

import com.cartaxcheck.model.VehicleIdentity;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.time.Duration;

@Component
public class CarTaxCheckPage extends BasePage{

    @Value("${app.url}")
    private String appUrl;

    @FindBy(how = How.ID, using = "vrm-input")
    private WebElement regNumber;

    @FindBy(how = How.XPATH, using = "//button[text()='Free Car Check']")
    private WebElement freeCarCheckBtn;

    @FindBy(how = How.XPATH, using = "//dt[text()='Registration']/following-sibling::dd")
    private WebElement registration;

    @FindBy(how = How.XPATH, using = "//dt[text()='Make']/following-sibling::dd")
    private WebElement make;

    @FindBy(how = How.XPATH, using = "//dt[text()='Model']/following-sibling::dd")
    private WebElement model;

    @FindBy(how = How.XPATH, using = "//dt[text()='Colour']/following-sibling::dd")
    private WebElement colour;

    @FindBy(how = How.XPATH, using = "//dt[text()='Year']/following-sibling::dd")
    private WebElement year;

    public VehicleIdentity getCarDetails(final String regNumber){
        enterRegNumber(regNumber);
        clickFreeCarCheck();
        waitUntilElementsVisible();
        return new VehicleIdentity(registration.getText(),make.getText(),model.getText(),colour.getText(),year.getText());
    }

    public void enterRegNumber(final String reg){
        regNumber.clear();
        regNumber.sendKeys(reg);
    }

    public void clickFreeCarCheck(){
        freeCarCheckBtn.click();
    }

    private void waitUntilElementsVisible(){
        FluentWait wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(registration));
        wait.until(ExpectedConditions.visibilityOf(make));
        wait.until(ExpectedConditions.visibilityOf(model));
        wait.until(ExpectedConditions.visibilityOf(colour));
        wait.until(ExpectedConditions.visibilityOf(year));
    }

    public void navigateToSite(){
        navigate(appUrl);
    }

    public void closeBrowser(){ close(); }
}
