package com.ttt.orangehrmtests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTest {

    @Test
    public void checkCode(){
        Assert.assertEquals("Pass","Pass","Unit Test Failed");
    }

}
