package com.freecrm.testcases;

import com.freecrm.base.TestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class LoginPageTest extends TestBase {

    public LoginPageTest() throws IOException {
        super();// to goto testbase.java and run its constractor(public testbase(){prop.....}
    }

    LoginPage loginpage;   // make object from LoginPage in this TC
    HomePage homePage;      // make object from HomePage in this TC
    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser,Method method) throws IOException {
        logger = extent.startTest(method.getName());
        initialization(browser);
        loginpage =new LoginPage();

    }

    @AfterMethod
    public void tears(Method method , ITestResult result) throws IOException {
        // screenshot code
        TestUtils.takePicture(method.getName());
        if (result.getStatus() == ITestResult.SUCCESS){
            logger.log(LogStatus.PASS,"Test Passed");
            logger.log(LogStatus.PASS,"<a href='"+result.getName()+".png"+"'><span class='label info'>Download SnapShot</span></a>");
        }
        else if (result.getStatus()==ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL,result.getThrowable());
            logger.log(LogStatus.PASS,"<a href='"+result.getName()+".png"+"'><span class='label info'>Download SnapShot</span></a>");
        }
        else logger.log(LogStatus.SKIP,"Test Skipped");
        driver.quit();
    }
    @Test(priority = 0)
    public void TitleTest(Method method) throws IOException {
        SoftAssert softassert = new SoftAssert();
        String expectedResult ="Free CRM software for customer relationship management";
        String actualResult = loginpage.getTitle();
        softassert.assertEquals(actualResult,expectedResult,"title is not equal");
        softassert.assertAll();
        System.out.println("soft assert massage after assert all");
    }
    @Test(priority = 1)
    public void urlTest(Method method) throws IOException {
        SoftAssert softassert = new SoftAssert();
        String expectedResult ="https://freecrm.com/";
        String actualResult = loginpage.getURL();
        softassert.assertEquals(actualResult,expectedResult,"url is not equal");
        softassert.assertAll();
        System.out.println("soft assert massage after assert all");
    }
    @Test(priority = 2)
    public void logoTest(Method method){
        SoftAssert softassert = new SoftAssert();
        Boolean expectedResult = true;
        Boolean logoCheck = loginpage.getLogo();
        softassert.assertEquals(logoCheck,expectedResult);
        softassert.assertAll();
    }
    @Test(priority = 3 )
    public void loginTest(Method method) throws IOException {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        SoftAssert softassert = new SoftAssert();
        homePage = loginpage.performLogin();   // this means we define homepage from this method  loginpage
        String expectedResult = "https://ui.freecrm.com/";
        String actualResult =homePage.getCurrentURL();
        softassert.assertEquals(expectedResult, actualResult);
        softassert.assertAll();
    }

}




