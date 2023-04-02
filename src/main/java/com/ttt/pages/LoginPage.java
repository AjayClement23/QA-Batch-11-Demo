package com.ttt.pages;


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
        UiElementReusables.enterInput(driver,password,passwordLoc);
        UiElementReusables.clickElement(driver,loginButtonLoc);
        return  new CommonPage();
    }
    public String getLoginTitleText(){
        String actualText= UiElementReusables.getElementText(driver
                ,loginTitleLoc);
        return actualText;
    }





}
