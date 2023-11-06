package api.utiliti;


import api.utilities.Logs;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    private static String getTestMethodNAME(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }




    @Override
    public void onTestStart(ITestResult iTestResult) {
        Logs.info(getTestMethodNAME(iTestResult) + " is starting.");
    }
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am on test passed method " + getTestMethodNAME(iTestResult) + " passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult iTestResultresult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        Logs.info("Finishing " + context.getName());
    }
}