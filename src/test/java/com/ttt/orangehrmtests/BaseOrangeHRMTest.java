package com.ttt.orangehrmtests;


import com.ttt.enums.DriverType;
import com.ttt.datautilities.ConfigDataManager;
import com.ttt.reportutils.ExtentTestManager;
import com.ttt.uidriverutils.UiDriverLauncher;
import com.ttt.uidriverutils.UiDriverManager;
import org.testng.annotations.*;
import java.util.Objects;

public class BaseOrangeHRMTest {




   protected BaseOrangeHRMTest(){

   }


   @Parameters("driverType")
   @BeforeMethod
    public void launchAppUrl(@Optional("") String driverType){
      if(driverType.equals("")){
         UiDriverLauncher.launchBrowser(ConfigDataManager.getBrowser());

      }else{
          UiDriverLauncher.launchBrowser(
                  DriverType.valueOf(driverType.toUpperCase()));

      }

       UiDriverManager.getDriver().manage().window().maximize();
       UiDriverManager.getDriver().get(ConfigDataManager.getAppUrl());
   }

   @AfterMethod
   public void quitBrowser() {
       if (Objects.nonNull(UiDriverManager.getDriver())){
           UiDriverManager.getDriver().quit();
           UiDriverManager.unLoadDriver();
       }

   }

   @AfterTest
    public void afterTest(){
       if(Objects.nonNull(ExtentTestManager.getExtentTest())){
           ExtentTestManager.unloadExtentTest();
       }
   }



}
