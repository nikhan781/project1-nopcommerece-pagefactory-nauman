package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OrderPage extends Utility {

    //Declaring WebElement type variable
    @CacheLookup
    @FindBy(xpath = "//div[@class='product-name']/h1")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement selectProcessor;
    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement selectRam;
    @CacheLookup
    @FindBy(id = "product_attribute_3_7")
    WebElement selectHDD400GB;
    @CacheLookup
    @FindBy(id = "product_attribute_4_9")
    WebElement selectVistaPremium;
    @CacheLookup
    @FindBy(id = "product_attribute_5_12")
    WebElement selectTotalCommander;
    @CacheLookup
    @FindBy(xpath = "//div[@class='product-price']")
    WebElement price;
    @CacheLookup
    @FindBy(id = "product_enteredQuantity_20")
    WebElement quantityField;

    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 add-to-cart-button']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/p[1]")
    WebElement messageAfterAddingToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@id='bar-notification']/div[1]/span[1]")
    WebElement closeButtonOnMessage;

    //This method will get  text
    public String getProductName() {
        Reporter.log("The product " + productName.toString());
        CustomListeners.test.log(Status.PASS, "The product");
        return getTextFromElement(productName);
    }

    //This method will select text
    public void selectAProcessor(String process) {
        Reporter.log("Select the processor " + selectProcessor.toString());
        selectByVisibleTextFromDropDown(selectProcessor, process);
        CustomListeners.test.log(Status.PASS, "Selected the processor is " + process);
    }

    //This method will select text
    public void SelectARam(String ram) {
        Reporter.log("Select RAM " + selectRam.toString());
        selectByVisibleTextFromDropDown(selectRam, ram);
        CustomListeners.test.log(Status.PASS, "Selected RAM is " + ram);
    }

    //This method will click
    public void clickAndSelectHDD() {
        Reporter.log("Select HDD " + selectHDD400GB.toString());
        clickOnElement(selectHDD400GB);
        CustomListeners.test.log(Status.PASS, "Selected HDD is ");
    }

    //This method will click
    public void clickAndSelectOsPremium() {
        Reporter.log("Click on OS Premium " + selectVistaPremium.toString());
        clickOnElement(selectVistaPremium);
        CustomListeners.test.log(Status.PASS, "Click on OS Premium ");
    }

    //This method will click
    public void clickAndSelectTotalCommander() {
        Reporter.log("Click on Total Commander " + selectTotalCommander.toString());
        clickOnElement(selectTotalCommander);
        CustomListeners.test.log(Status.PASS, "Click on Total Commander ");
    }

    //This method will select text
    public String getPrice() {
        Reporter.log("The price is " + price.toString());
        CustomListeners.test.log(Status.PASS, "The price is " + price.getText());
        return getTextFromElement(price);
    }

    //This method will click
    public void clickOnAddToCartButton() {
        Reporter.log("Click on add card button " + addToCartButton.toString());
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS, "Click on add card button ");

    }

    //This method will select text
    public String getMessageAfterAddingToCart() {
        Reporter.log("The Message after Adding to cart is " + messageAfterAddingToCart.toString());
        CustomListeners.test.log(Status.PASS, "The Message after Adding to cart is " + messageAfterAddingToCart.getText());
        return getTextFromElement(messageAfterAddingToCart);
    }

    //This method will click
    public void clickOnCloseButtonOnMessage() {
        Reporter.log("Click on close Button on Message " + closeButtonOnMessage.toString());
        clickOnElement(closeButtonOnMessage);
        CustomListeners.test.log(Status.PASS, "Click on close Button on Message");
    }

    //This method will send text
    public void sentTextToQuantityField(String qty) {
        Reporter.log("Click quantity field " + quantityField.toString());
        clearTextFromField(quantityField);
        sendTextToElement(quantityField, qty);
        CustomListeners.test.log(Status.PASS, "The quantity is " + qty);
    }


}
