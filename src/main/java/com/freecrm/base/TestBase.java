package com.freecrm.base;


import com.freecrm.util.WebListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static  Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebListener weblistener;
    public static ExtentReports extent;
    public static ExtentTest logger ;
    public TestBase() throws IOException {   // define constructor
        prop = new Properties();
        FileInputStream fis = new FileInputStream("E:\\mavenProject\\update001CRM\\src\\test\\java\\com\\freecrm\\config\\config.properties");
        prop.load(fis);
    }
    public void initialization(String browser){
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }


        e_driver =new EventFiringWebDriver(driver);
        weblistener = new WebListener();
        e_driver.register(weblistener);
        driver = e_driver;

        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }
}
