package com.freecrm.pages;

import com.freecrm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ContactPage extends TestBase {

    public ContactPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//input[@name='first_name']")
    WebElement firstName;
    @FindBy (xpath = "//input[@name='last_name']")
    WebElement lastName;
    @FindBy (xpath = "//input[@class='search']")
    WebElement company;
    @FindBy (xpath = "//input[@name='department']")
    WebElement department;
    @FindBy (xpath = "//button[@class='ui linkedin button']")
    WebElement save;

    public void addNewContact(String fName, String lName, String companyName, String departmentName){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        company.sendKeys(companyName);
        department.sendKeys(departmentName);
        save.click();
    }


}
