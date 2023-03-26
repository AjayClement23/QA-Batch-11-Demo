package com.ttt.pages;

import com.ttt.reportutils.ExtentReportLogger;
import com.ttt.uielementutils.UiElementReusables;
import com.ttt.uidriverutils.UiDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public final class LoginPage {
   private WebDriver driver;
    By userNameLoc = By.xpath("//input[@name='username' or @placeholder='Username']");
    By passwordLoc = By.xpath("//input[@name='password' or @type='password']");
    By loginButtonLoc = By.cssSelector(".orangehrm-login-button[type='submit']");
    By loginTitleLoc = By.xpath("//*[contains(@class,'orangehrm-login-title')]");

   public LoginPage(){
        driver = UiDriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }
    public CommonPage login(String userName, String password){
        UiElementReusables.enterInput(driver,userName,userNameLoc);
        ExtentReportLogger.reportInfo("enterInput- Value Entered: "+userName);
        UiElementReusables.enterInput(driver,password,passwordLoc);
        ExtentReportLogger.reportInfo("enterInput- Value Entered: "+password);
        UiElementReusables.clickElement(driver,loginButtonLoc);
        ExtentReportLogger.reportInfo("clickElement- login button clicked");
        return  new CommonPage();
    }
    public String getLoginTitleText(){
        String actualText= UiElementReusables.getElementText(driver
                ,loginTitleLoc);
        ExtentReportLogger.reportInfo("getLoginTitleText- actual value: "+actualText);
        return actualText;
    }





}
