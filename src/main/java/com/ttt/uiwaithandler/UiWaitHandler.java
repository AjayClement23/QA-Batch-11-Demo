package com.ttt.uiwaithandler;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class UiWaitHandler {

    private UiWaitHandler() {
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, Duration waitTime, By locator,
                                                 boolean assertFlag){
        WebElement expectedElement = null;

        try {
            expectedElement = new WebDriverWait(driver, waitTime)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
           return expectedElement;
        }catch (NoSuchElementException | StaleElementReferenceException ex){
            if(assertFlag) {
                throw new RuntimeException("Element not found for locator: "+locator, ex);
            }else{
                ex.printStackTrace();
            }

        }
        return expectedElement;
    }
}
