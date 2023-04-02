package com.ttt.pages;


import com.ttt.uielementutils.UiElementReusables;
import com.ttt.uidriverutils.UiDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public final class CommonPage {

    By userAccountDrpDwnLoc =By.className("oxd-userdropdown-tab");
    By logOutButtonLoc = By.xpath("//a[text()='Logout']");
    private WebDriver driver;

    public CommonPage(){
        this.driver= UiDriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    public LoginPage logOut(){
        UiElementReusables.clickElement(driver,userAccountDrpDwnLoc);
        UiElementReusables.clickElement(driver,logOutButtonLoc);
        return new LoginPage();
    }
}
