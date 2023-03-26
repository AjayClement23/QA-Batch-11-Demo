package com.ttt.frameworklisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ttt.reportutils.ExtentReportLogger;
import com.ttt.reportutils.ExtentTestManager;
import com.ttt.runconstants.PathConstants;
import org.testng.*;

import java.util.Objects;

public class TestRunStateListener implements ITestListener, ISuiteListener {

    private  ExtentReports extentReports;
    private  ExtentSparkReporter extentSparkReporter;
    private  ExtentKlovReporter extentKlovReporter;


    @Override
    public void onStart(ISuite suite) {
        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(PathConstants.EXTENT_TEST_RESULT_FILE_PATH);
        extentReports.attachReporter(extentSparkReporter);
    }

    @Override
    public void onFinish(ISuite suite) {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
       ExtentTestManager.setExtentTest(
        extentReports.createTest(result.getTestContext().getCurrentXmlTest().getName())
                       .createNode(result
                .getMethod().getMethodName())
       );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportLogger.reportPass(result.getMethod().getMethodName()+" passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportLogger.reportFailWithoutScreenshot(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
          ExtentReportLogger.reportSkipped(result.getSkipCausedBy().toString());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ExtentReportLogger.reportFailWithoutScreenshot(result.getThrowable());
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
