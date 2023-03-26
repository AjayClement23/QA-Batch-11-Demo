package com.ttt.datautilities;

import com.ttt.enums.TestDataColumnHeaders;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public final class DataProviderUtil {

    public DataProviderUtil(){
        //adding no arg constructor for dataprovider invocation
    }

    @DataProvider
    public Object[][] getTestData(Method m){
        return new Object[][]{
                {
                    new ExcelUtil().getRowData(TestDataColumnHeaders.TESTCASENAME.getHeader(),m.getName())
                }
        };
    }

}
