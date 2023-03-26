package com.ttt.orangehrmtests;


import com.ttt.pages.LoginPage;
import com.ttt.datautilities.ConfigDataManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class LoginTests extends BaseOrangeHRMTest{
    private LoginTests(){


    }
    @Test
    private void loginLogoutTest(){
        String loginTitleActual = new LoginPage()
                                     .login(ConfigDataManager.getAppUserName()
                                             ,ConfigDataManager.getAppPassword())
                                      .logOut()
                                      .getLoginTitleText();

        Assert.assertEquals(loginTitleActual,"Login");
    }











}
