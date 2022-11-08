package com.freecrm.testcases;

import com.freecrm.base.TestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.lang.reflect.Method;

public class HomePageTest extends TestBase {
    LoginPage loginPage ;
    HomePage homePage;
    public HomePageTest() throws IOException {
        super();
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser , Method method) throws IOException {
        logger = extent.startTest(method.getName());
        initialization(browser);
        loginPage = new LoginPage();
        homePage = loginPage.performLogin();
    }
    @AfterMethod
    public void tears(Method method, ITestResult result) throws IOException {
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
    @Test(priority = 4)
    public void clickOnContactsTest(){
        SoftAssert softassert = new SoftAssert();
        homePage.clickOnContact();
        homePage.Create();
        WebElement firstNameLabel = driver.findElement(By.xpath("//div[@class='ui field']"));
        Boolean actualResult = homePage.firstNameLabelOfContacts();
        softassert.assertTrue(actualResult);
        softassert.assertAll();
    }
    @Test(priority = 5)
    public void clickOnDealsTest(){
        SoftAssert softassert = new SoftAssert();
        homePage.clickOnDeals();
        homePage.Create();
        Boolean actualResult = homePage.firstNameLabelOfDeals();
        softassert.assertTrue(actualResult);
        softassert.assertAll();
    }
    @Test(priority = 6)
    public void clickOnTasksTest(){
        SoftAssert softassert = new SoftAssert();
        homePage.clickOnTasks();
        homePage.Create();
        Boolean actualResult = homePage.firstNameLabelOfTasks();
        softassert.assertTrue(actualResult);
        softassert.assertAll();

    }
}
