package com.ttt.uidriverutils;

import com.ttt.enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class UiDriverLauncher {

    private UiDriverLauncher(){

    }

    public static WebDriver  launchBrowser(DriverType browserDriverType){
        WebDriver driver;
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        switch (browserDriverType){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions copts = new ChromeOptions();
                driver = new ChromeDriver(copts);
                break;
            case FIREFOX:
               WebDriverManager.firefoxdriver().setup();
               driver= new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;

            default:
                driver = null;
        }
        UiDriverManager.setDriver(driver);
        return driver;
    }

}
