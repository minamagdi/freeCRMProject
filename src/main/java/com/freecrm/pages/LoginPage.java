package com.freecrm.pages;

import com.freecrm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase {
    public LoginPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//img[@class='img-responsive']")
    WebElement logo;
    @FindBy (linkText = "Login")
    WebElement mainLogin;
    @FindBy (xpath = "//input[@type='text']")
    WebElement userName;
    @FindBy (xpath = "//input[@type='password']")
    WebElement password;
    @FindBy (xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement login2;

    public String getTitle(){
        String ActualTitle = driver.getTitle();
        return ActualTitle;
    }
    public String getURL(){
        String AcgualURL = driver.getCurrentUrl();
        return AcgualURL;
    }

    public Boolean getLogo()
    {
        Boolean logoIsDisplayed = logo.isDisplayed();
        return logoIsDisplayed;
    }
    public HomePage performLogin() throws IOException {
        mainLogin.click();
        userName.sendKeys(prop.getProperty("UserName"));
        password.sendKeys(prop.getProperty("PassWord"));
        login2.click();
        return new HomePage();
    }

}
