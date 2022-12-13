package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    //Declaring WebElement type variable
    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logoutLink;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement shoppingCartLink;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement goToCartLink;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
    WebElement welcomeTextMessage;

    public void clickOnLoginLink() {
        Reporter.log("Click on login link " + loginLink.toString());
        clickOnElement(loginLink);
        CustomListeners.test.log(Status.PASS, "Click on login link");

    }

    public void clickOnRegisterLink() {
        Reporter.log("Click on Register link " + registerLink.toString());
        clickOnElement(registerLink);
        CustomListeners.test.log(Status.PASS, "Click on Register link");

    }

    //This method will hover mouse
    public void hoverMouseOverShoppingCartLink() {
        Reporter.log("Click on Shopping cart link " + shoppingCartLink.toString());
        mouseHoverToElement(shoppingCartLink);
        CustomListeners.test.log(Status.PASS, "Click on Shopping cart link");

    }
    //This method will click
    public void clickOnGoToCartLink() {
        Reporter.log("Click on Go to Cart " + goToCartLink.toString());
        clickOnElement(goToCartLink);
        CustomListeners.test.log(Status.PASS, "Click on Go to Cart");

    }
    //This method will get text
    public String getWelcomeTextMessage() {
        Reporter.log("The welcome text " + welcomeTextMessage.toString());
        CustomListeners.test.log(Status.PASS, "The welcome text ");
        return getTextFromElement(welcomeTextMessage);
    }
    //This method will click
    public void clickOnLogOutLink() {
        Reporter.log("Click on logout link " + logoutLink.toString());
        clickOnElement(logoutLink);
        CustomListeners.test.log(Status.PASS, "Click on logout link");

    }
    //This method will get url
    public String currentUrl() {
        Reporter.log("The url is ");
        String url = driver.getCurrentUrl();
        CustomListeners.test.log(Status.PASS, "The current url is " +url);
        return url;
    }
}
