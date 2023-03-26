package com.ttt.reportutils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;

public final class ExtentReportLogger {



    private ExtentReportLogger() {

    }

    public static void reportPass(String description){
        ExtentTestManager.getExtentTest().log(Status.PASS, description);
    }

    public static void reportPassWithScreenshot(String description, Media screenshot){
        ExtentTestManager.getExtentTest().log(Status.PASS, description, screenshot);
    }

    public static void reportFail(String description, Throwable exception, Media screenshot){
        ExtentTestManager.getExtentTest().log(Status.FAIL,description,exception,screenshot);
    }

    public static void reportFailWithoutScreenshot(Throwable exception){
        ExtentTestManager.getExtentTest().log(Status.FAIL, exception);
    }

    public static void reportSkipped(String description){
        ExtentTestManager.getExtentTest().log(Status.SKIP, description);
    }

    public static void reportInfo(String description){
        ExtentTestManager.getExtentTest().log(Status.INFO, description);
    }
}
