package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class ElectronicTest extends BaseTest {
    //Declaring two classes Objects
    TopMenuPage topMenuPage;
    ProductSelectionPage productSelectionPage;
    OrderPage orderPage;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    LoginPage loginPage;
    CheckOutPage checkOutPage;
    RegisterPage registerPage;
    // This method contains objects of Pages
    @BeforeMethod(alwaysRun = true)
    public void pageObjects() {
        homePage = new HomePage();
        topMenuPage = new TopMenuPage();
        productSelectionPage = new ProductSelectionPage();
        orderPage = new OrderPage();
        shoppingCartPage = new ShoppingCartPage();
        loginPage = new LoginPage();
        checkOutPage = new CheckOutPage();
        registerPage = new RegisterPage();

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        topMenuPage.hoverOverMenu("Electronics");
        //1.2 Mouse Hover on “Cell phones” and click
        topMenuPage.selectMenu("Cell phones");
        //1.3 Verify the text “Cell phones”
        Assert.assertEquals(topMenuPage.textOnEachPage(), "Cell phones");
    }

    //Test 2
    @Test(groups = {"smoke", "regression"})
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        topMenuPage.hoverOverMenu("Electronics");
        //2.2 Mouse Hover on “Cell phones” and click
        topMenuPage.selectMenu("Cell phones");
        //2.3 Verify the text “Cell phones”
        Assert.assertEquals(topMenuPage.textOnEachPage(), "Cell phones");
        //2.4 Click on List View Tab
        productSelectionPage.clickOnListViewIcon();
        Thread.sleep(1500);
        //2.5 Click on product name “Nokia Lumia 1020” link
        productSelectionPage.clickOnNokiaLumia();
        //productSelectionPage.clickOnTheProduct("Nokia Lumia 1020");
        //2.6 Verify the text “Nokia Lumia 1020”
        Assert.assertEquals(orderPage.getProductName(), "Nokia Lumia 1020");
        //2.7 Verify the price “$349.00”
        Assert.assertEquals(orderPage.getPrice(), "$349.00");
        //2.8 Change quantity to 2
        orderPage.sentTextToQuantityField("2");
        //2.9 Click on “ADD TO CART” tab
        orderPage.clickOnAddToCartButton();
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals(orderPage.getMessageAfterAddingToCart(), "The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        orderPage.clickOnCloseButtonOnMessage();
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        homePage.hoverMouseOverShoppingCartLink();
        homePage.clickOnGoToCartLink();
        //2.12 Verify the message "Shopping cart"
        Assert.assertEquals(shoppingCartPage.getShoppingCartText(), "Shopping cart");
        //2.13 Verify the quantity is 2
        Assert.assertEquals(shoppingCartPage.getQuantityInQtyField(), "2");
        //2.14 Verify the Total $698.00
        Assert.assertEquals(shoppingCartPage.getTotalPrice(), "$698.00");
        //2.15 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermAndConditions();
        //2.16 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckoutButton();
        //2.17 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals(loginPage.getWelcomeText(), "Welcome, Please Sign In!");
        //2.18 Click on “REGISTER” tab
        loginPage.clickOnRegisterButton();
        //2.19 Verify the text “Register”
        Assert.assertEquals(registerPage.getRegisterPageText(), "Register");
        //2.20 Fill the mandatory fields
        registerPage.selectGenderOnRegistrationPage("Male");
        registerPage.sendTextToFirstNameField("Jhonny");
        registerPage.sendTextToLastNameField("Bravo");
        registerPage.selectDayOfBirth("15");
        registerPage.selectDayOfMonth("5");
        registerPage.selectDayOfYear("1970");
        registerPage.sendTextToEmailField("jhonny");
        registerPage.sendTextToPasswordField("bravo123");
        registerPage.sendTextToConfirmPasswordField("bravo123");
        //2.21 Click on “REGISTER” Button
        registerPage.clickOnRegisterButton();
        //2.22 Verify the message “Your registration completed”
        Assert.assertEquals(registerPage.getRegistrationSuccessfulText(), "Your registration completed");
        //2.23 Click on “CONTINUE” tab
        registerPage.clickOnContinueButtonAfterRegistrationComplete();
        //2.24 Verify the text “Shopping card”
        Assert.assertEquals(shoppingCartPage.getShoppingCartTextAgain(), "Shopping cart");
        //2.25 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermAndConditions2();
        //2.26 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckoutButton2();
        //2.27 Fill the Mandatory fields
        checkOutPage.selectACountryInCountryField("United Kingdom");
        checkOutPage.sendTextToCityField("Bolton");
        checkOutPage.sendTextToAddressField("1 London Road");
        checkOutPage.sendTextToPostCodeField("BB1 BB2");
        checkOutPage.sendTextToPhoneField("087654676634");
        //2.28 Click on “CONTINUE”
        checkOutPage.clickOnContinueButtonCheckout();
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        checkOutPage.clickOnSecondDayAirDelivery();
        //2.30 Click on “CONTINUE”
        checkOutPage.clickOnContinueButtonDelivery();
        //2.31 Select Radio Button “Credit Card”
        checkOutPage.clickOnCreditCardPaymentMethod();
        checkOutPage.clickOnContinueButtonPayment();
        //2.32 Select “Visa” From Select credit card dropdown
        checkOutPage.selectCreditCard(0);
        //2.33 Fill all the details
        checkOutPage.sendTextToCardholderNameField("JHonny");
        checkOutPage.sendTextToCardNumberField("5555555555554444");
        checkOutPage.selectExpiryMonth("5");
        checkOutPage.selectExpiryYear("2024");
        checkOutPage.sendTextToCardCodeField("123");
        //2.34 Click on “CONTINUE”
        checkOutPage.clickOnContinueButtonCreditCard();
        //2.35 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals(checkOutPage.getPaymentMethodText(), "Payment Method: Credit Card");
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        Assert.assertEquals(checkOutPage.getDeliveryMethodText(), "Shipping Method: 2nd Day Air");
        //2.37 Verify Total is “$698.00”
        Assert.assertEquals(checkOutPage.getTotalPriceText(), "$698.00");
        //2.38 Click on “CONFIRM”
        checkOutPage.clickOnConfirmButton();
        //2.39 Verify the Text “Thank You”
        Assert.assertEquals(checkOutPage.getThankYouTextAfterOrderConfirmation(), "Thank you");
        //2.40 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals(checkOutPage.getOrderProcessedSuccessfullyTextAfterOrderConfirmation(), "Your order has been successfully processed!");
        //2.41 Click on “CONTINUE”
        checkOutPage.clickOnContinueButtonOnThankYouNote();
        //2.42 Verify the text “Welcome to our store”
        Assert.assertEquals(homePage.getWelcomeTextMessage(), "Welcome to our store");
        //2.43 Click on “Logout” link
        homePage.clickOnLogOutLink();
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        Assert.assertEquals(homePage.currentUrl(), "https://demo.nopcommerce.com/");
    }
}
