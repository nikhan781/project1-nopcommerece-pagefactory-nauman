package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {
    //Declaring WebElement type variable
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='form-fields']/div[1]/div/span[1]")
    WebElement maleGenderButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='form-fields']/div[1]/div/span[2]")
    WebElement femaleGenderButton;
    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement dateOfBirthDay;
    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement dateOfBirthMonth;
    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement dateOfBirthYear;
    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailId;
    @CacheLookup
    @FindBy(id = "Password")
    WebElement password;
    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(xpath = "//button[@id='register-button']")
    WebElement registerButton;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registrationSuccessfulText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButtonAfterRegistrationComplete;

    //This method will get  text
    public String getRegisterPageText() {
        Reporter.log("The Register Page text " + registerText.toString());
        CustomListeners.test.log(Status.PASS, "The Register Page text ");
        return getTextFromElement(registerText);
    }

    //This method will select element
    public void selectGenderOnRegistrationPage(String gender) {
        Reporter.log("Select Gender ");
        if (gender.equalsIgnoreCase("Male")) {
            clickOnElement(maleGenderButton);
        } else if (gender.equalsIgnoreCase("Female")) {
            clickOnElement(femaleGenderButton);
        }
        CustomListeners.test.log(Status.PASS, "Selected Gender ");
    }

    //This method will send text
    public void sendTextToFirstNameField(String fName) {
        Reporter.log("Enter user first name " + fName + " to firstname field " + firstNameField.toString());
        sendTextToElement(firstNameField, fName);
        CustomListeners.test.log(Status.PASS, "Entered  first name " + fName);
    }

    //This method will send text
    public void sendTextToLastNameField(String lName) {
        Reporter.log("Enter user last name " + lName + " to lastname field " + lastNameField.toString());
        sendTextToElement(lastNameField, lName);
        CustomListeners.test.log(Status.PASS, "Entered  last name " + lName);
    }

    //This method will select element
    public void selectDayOfBirth(String day) {
        Reporter.log("Select Day of Birth " + dateOfBirthDay.toString());
        selectByValueFromDropDown(dateOfBirthDay, day);
        CustomListeners.test.log(Status.PASS, "Day of Birth is " + day);
    }

    //This method will select element
    public void selectDayOfMonth(String month) {
        Reporter.log("Select Month of Birth " + dateOfBirthMonth.toString());
        selectByValueFromDropDown(dateOfBirthMonth, month);
        CustomListeners.test.log(Status.PASS, "Selected Credit Card is " + month);

    }

    //This method will select element
    public void selectDayOfYear(String year) {
        Reporter.log("Select Month of Birth " + dateOfBirthYear.toString());
        selectByValueFromDropDown(dateOfBirthYear, year);
        CustomListeners.test.log(Status.PASS, "Select Month of Birth " + year);

    }

    //This method will send text
    public void sendTextToEmailField(String email) {
        Reporter.log("Enter user email " + email + " to Email field " + emailId.toString());
        sendTextToElement(emailId, email + getAlphaNumericString(2) + "@gmail.com");
        CustomListeners.test.log(Status.PASS, "Entered  gmail " + email);

    }

    //This method will send text
    public void sendTextToPasswordField(String rPassword) {
        Reporter.log("Enter Password " + rPassword + " to password field " + password.toString());
        sendTextToElement(password, rPassword);
        CustomListeners.test.log(Status.PASS, "Entered  password " + rPassword);

    }

    //This method will send text
    public void sendTextToConfirmPasswordField(String cPassword) {
        Reporter.log("Enter Password again " + cPassword + " to Confirm Password field " + confirmPassword.toString());
        sendTextToElement(confirmPassword, cPassword);
        CustomListeners.test.log(Status.PASS, "Entered  COnfirm Password " + cPassword);

    }

    //This method will click
    public void clickOnRegisterButton() {
        Reporter.log("Click On Register " + registerButton.toString());
        clickOnElement(registerButton);
        CustomListeners.test.log(Status.PASS, "Click On Register  ");

    }

    //This method will get  text
    public String getRegistrationSuccessfulText() {
        Reporter.log("The Registration successful text " + registrationSuccessfulText.toString());
        CustomListeners.test.log(Status.PASS, "The payment method text");
        return getTextFromElement(registrationSuccessfulText);
    }

    //This method will click
    public void clickOnContinueButtonAfterRegistrationComplete() {
        Reporter.log("Click on Continue Button After Registration is Successful " + continueButtonAfterRegistrationComplete.toString());
        clickOnElement(continueButtonAfterRegistrationComplete);
        CustomListeners.test.log(Status.PASS, "Click on Continue Button After Registration is Successful ");

    }
}