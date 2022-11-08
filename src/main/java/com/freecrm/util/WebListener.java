package com.freecrm.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebListener implements WebDriverEventListener {
    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before Navigating to : '" + url + "'");

    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("After Navigating to : '" + url + "'");

    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Navigating Back to previous Page");

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated Back to previous Page");

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Navigating Forward to Next Page");

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("Navigated Forward to Next Page");

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to Find Element By : " + by.toString());

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Founded Find Element By : " + by.toString());

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("clicked on : " + element.toString());

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("value of the : " + element.toString() + "before any changes made");

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("element value changed to : " + element.toString());

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Exception Occurred : " + error);

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }// هي عباره عن انترفيس من سيلينيم
}
