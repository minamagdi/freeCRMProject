package com.freecrm.pages;

import com.freecrm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBase {
    public HomePage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='users icon']")
    WebElement contacts;
    @FindBy(linkText = "Create")
    WebElement create;
    @FindBy(linkText = "Deals")
    WebElement Deals;
    @FindBy(xpath = "//span[@class='item-text']")
    WebElement tasks;
    @FindBy(xpath = "//div[@class='ui field']")
    WebElement firstNameLabelOfContacts;
    @FindBy(xpath = "//div[@class='ui field']")
    WebElement firstNameLabelOfDeals;
    @FindBy(xpath = "//div[class='ui field']")
    WebElement tasksStatus;

    public String getCurrentURL() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public void clickOnContact() {
        contacts.click();
    }

    public void Create() {
        create.click();
    }

    public Boolean firstNameLabelOfContacts() {
        Boolean firstNameLabelDisplayed = firstNameLabelOfContacts.isDisplayed();
        return firstNameLabelDisplayed;
    }

    public void clickOnDeals() {
        Deals.click();
    }

    public Boolean firstNameLabelOfDeals() {
        Boolean firstNameLabelOfTask = firstNameLabelOfDeals.isDisplayed();
        return firstNameLabelOfTask;
    }

    public void clickOnTasks() {
        tasks.click();
    }

    public Boolean firstNameLabelOfTasks() {
        Boolean firstNameLabelOfTask = tasksStatus.isDisplayed();
        return firstNameLabelOfTask;
    }
    public ContactPage clickOnNewContact() throws IOException {
        contacts.click();
        return new ContactPage();
    }
}
