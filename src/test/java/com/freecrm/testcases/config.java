package com.freecrm.testcases;

import com.freecrm.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class config extends TestBase {
    public config() throws IOException {
        super();
    }
    @BeforeSuite
    public void start(){
        extent = new ExtentReports("C:\\Users\\TOP\\Desktop\\untitled\\TestReport\\index.html",true);
        extent.addSystemInfo("OS" , "windows");
        extent.addSystemInfo("owner","mina");
        extent.addSystemInfo("Test Name","FreeCRm");
        extent.addSystemInfo("Language","java");
        extent.addSystemInfo("FrameWork Design","Page Object");
    }
    @AfterSuite
    public void end(){
        extent.flush(); // to create our report

    }
}
