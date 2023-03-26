package com.ttt.uidriverutils;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class UiDriverManager {

    private static ThreadLocal<WebDriver> tdlDriver = new ThreadLocal<>();
    private UiDriverManager(){

    }

    public static WebDriver getDriver(){
              return tdlDriver.get();
    }

    public static void setDriver(WebDriver driver){
       if (Objects.isNull(tdlDriver.get())) {
           tdlDriver.set(driver);
       }
    }

    public static void unLoadDriver(){
        if(Objects.nonNull(tdlDriver.get())){
            tdlDriver.remove();
        }
    }


}
