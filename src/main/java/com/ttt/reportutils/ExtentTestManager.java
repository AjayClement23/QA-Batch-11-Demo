package com.ttt.reportutils;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtentTestManager {

    private ExtentTestManager(){

    }

    private static ThreadLocal<ExtentTest> tdlExtentTest = new ThreadLocal<>();

    public static void setExtentTest(ExtentTest extentTest){
        if(Objects.isNull(tdlExtentTest.get())) {
            tdlExtentTest.set(extentTest);
        }
    }

    public static ExtentTest getExtentTest(){
        return tdlExtentTest.get();
    }

    public static void unloadExtentTest(){
        if (Objects.nonNull(tdlExtentTest)) {
            tdlExtentTest.remove();
        }
    }

}
