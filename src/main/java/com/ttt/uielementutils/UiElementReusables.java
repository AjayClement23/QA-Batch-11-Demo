package com.ttt.uielementutils;

import com.ttt.reportutils.ExtentReportLogger;
import com.ttt.uidriverutils.UiDriverManager;
import com.ttt.uiwaithandler.UiWaitHandler;
import com.ttt.datautilities.ConfigDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public final class UiElementReusables {


    private UiElementReusables() {
       
    }

    public static void enterInput(WebDriver driver, String inputText, By locator){
        UiWaitHandler.waitForElementToBeVisible(driver,
                        Duration.ofMillis(ConfigDataManager.getGlobalWaitTime()),locator, true)
                .sendKeys(inputText);
    }

    public static void clickElement(WebDriver driver, By locator){
        UiWaitHandler.waitForElementToBeVisible(driver,
                        Duration.ofMillis(ConfigDataManager.getGlobalWaitTime()),locator, true)
                .click();

    }

    public static String getElementText(WebDriver driver, By locator){
       return UiWaitHandler.waitForElementToBeVisible(driver,
                        Duration.ofMillis(ConfigDataManager.getGlobalWaitTime()),locator, true)
                .getText().trim();

    }

}
