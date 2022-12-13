package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    //Declaring WebElement type variable
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeMessage;
    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;
    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 checkout-as-guest-button']")
    WebElement checkoutAsGuestButton;

    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 register-button']")
    WebElement registerButton;
    //This method will get  text
    public String getWelcomeText() {
        Reporter.log("The Welcome text " + welcomeMessage.toString());
        CustomListeners.test.log(Status.PASS, "The Welcome text");
        return getTextFromElement(welcomeMessage);
    }
    //This method will send text
    public void enterEmailId(String userEmail) {
        Reporter.log("Enter Email ID " + userEmail + " to Email field " + emailField.toString());
        sendTextToElement(emailField, userEmail);
        CustomListeners.test.log(Status.PASS, "Email ID is " + userEmail);
    }
    //This method will send text
    public void enterPassword(String userPassword) {
        Reporter.log("Enter password  " + userPassword + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, userPassword);
        CustomListeners.test.log(Status.PASS, "Entered password is " + userPassword);
    }
    //This method will click
    public void clickOnLogInButton() {
        Reporter.log("Click on Login Button " + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on continue Button on card section");
    }
    //This method will get  text
    public String getErrorMessage() {
        Reporter.log("The Error Message " + errorMessage.toString());
        CustomListeners.test.log(Status.PASS, "The Error Message is ");
        return getTextFromElement(errorMessage);
    }
    //This method will click
    public void clickOnCheckoutAsGuestButton() {
        Reporter.log("Click on checkout Button in guest section " + checkoutAsGuestButton.toString());
        clickOnElement(checkoutAsGuestButton);
        CustomListeners.test.log(Status.PASS, "Click on checkout Button in guest section");
    }
    //This method will click
    public void clickOnRegisterButton() {
        Reporter.log("Click on Register Button " + registerButton.toString());
        clickOnElement(registerButton);
        CustomListeners.test.log(Status.PASS, "Click on Register Button");
    }
}
