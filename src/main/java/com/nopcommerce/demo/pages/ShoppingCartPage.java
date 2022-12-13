package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {


    //Declaring WebElement type variable
    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']")
    WebElement shoppingCartText2;
    @CacheLookup
    @FindBy(xpath = "//td[@class='quantity']/input")
    WebElement quantityField;
    @CacheLookup
    @FindBy(id = "updatecart")
    WebElement updateCartButton;
    @CacheLookup
    @FindBy(xpath = "//span[@class='value-summary'][1]/strong")
    WebElement totalPrice;
    @CacheLookup
    @FindBy(id = "termsofservice")
    WebElement termAndConditions;

    @CacheLookup
    @FindBy(id = "termsofservice")
    WebElement termAndConditions2;
    @CacheLookup
    @FindBy(name = "checkout")
    WebElement checkoutButton;
    @CacheLookup
    @FindBy(name = "checkout")
    WebElement checkoutButton2;

    //This method will get text
    public String getShoppingCartText() {
        Reporter.log("The shopping cart text " + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS, "The shopping cart text " + shoppingCartText);
        return getTextFromElement(shoppingCartText);
    }

    //This method will get New Customer text
    public void sendTextToQuantityField(String qty) {
        clearTextFromField(quantityField);
        sendTextToElement(quantityField, qty);
    }

    //This method will click
    public void clickOnUpdateCartButton() {
        Reporter.log("Click on Update Cart Button " + updateCartButton.toString());
        clickOnElement(updateCartButton);
        CustomListeners.test.log(Status.PASS, "Click on Update Cart Button");

    }

    //This method will get text
    public String getTotalPrice() {
        Reporter.log("The total price is " + totalPrice.toString());
        CustomListeners.test.log(Status.PASS, "The total price is " + totalPrice);
        return getTextFromElement(totalPrice);
    }

    //This method will click
    public void clickOnTermAndConditions() {
        Reporter.log("Click on erm and conditions box" + termAndConditions.toString());
        clickOnElement(termAndConditions);
        CustomListeners.test.log(Status.PASS, "Click on erm and conditions box");

    }

    //This method will click
    public void clickOnCheckoutButton() {
        Reporter.log("Click on checkout button " + checkoutButton.toString());
        clickOnElement(checkoutButton);
        CustomListeners.test.log(Status.PASS, "Click on checkout button ");
    }

    //This method will get text
    public String getQuantityInQtyField() {
        Reporter.log("Quantity is " + quantityField.toString());
        WebElement actualQuantity = quantityField;
        String actual = actualQuantity.getAttribute("value");
        CustomListeners.test.log(Status.PASS, "The quantity is " + actual);
        return actual;
    }

    //This method will get text
    public String getShoppingCartTextAgain() {
        Reporter.log("The shopping cart text " + shoppingCartText2.toString());
        CustomListeners.test.log(Status.PASS, "The shopping cart text " + shoppingCartText2);
        return getTextFromElement(shoppingCartText2);
    }

    //This method will click
    public void clickOnTermAndConditions2() {
        Reporter.log("Click on erm and conditions box" + termAndConditions2.toString());
        clickOnElement(termAndConditions2);
        CustomListeners.test.log(Status.PASS, "Click on erm and conditions box");
    }

    //This method will click
    public void clickOnCheckoutButton2() {
        Reporter.log("Click on checkout button " + checkoutButton2.toString());
        clickOnElement(checkoutButton2);
        CustomListeners.test.log(Status.PASS, "Click on checkout button ");
    }

}
