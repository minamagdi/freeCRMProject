package com.freecrm.testcases;

import com.freecrm.base.TestBase;
import com.freecrm.pages.ContactPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class contactPageTest extends TestBase {
    LoginPage loginPage ;
    HomePage homePage;
    ContactPage contactPage ;
    public contactPageTest() throws IOException {
        super();
    }
    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser, Method method) throws IOException {
        logger= extent.startTest(method.getName());
        initialization(browser);
        loginPage=new LoginPage();
        homePage = loginPage.performLogin();

    }
    @Test(dataProvider = "testData")
    public void addContactTest(String fName, String lName, String companyName, String departmentName) throws IOException {
       contactPage = homePage.clickOnNewContact();
       homePage.Create();
       contactPage.addNewContact(fName,lName, companyName,departmentName);

    }
    @AfterMethod
    public void tears(Method method,ITestResult result) throws IOException {
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
    @DataProvider
    public Object[][] testData() throws Throwable{

        Object data[][]= TestUtils.getDataFromExcel("contactpagef");
        return data;
    }

}

