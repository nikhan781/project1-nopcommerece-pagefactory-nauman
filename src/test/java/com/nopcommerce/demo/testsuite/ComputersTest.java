package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class ComputersTest extends BaseTest {
    //Declaring two classes Objects
    TopMenuPage topMenuPage;
    ProductSelectionPage productSelectionPage;
    OrderPage orderPage;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    LoginPage loginPage;
    CheckOutPage checkOutPage;
    RegisterPage registerPage;
    CategoriesPage categoriesPage;

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
        categoriesPage = new CategoriesPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Click on Computer Menu.
        topMenuPage.selectMenu("Computers");
        //1.2 Click on Desktop
        categoriesPage.selectCategory("Desktops");
        //1.3 Select Sort By position "Name: Z to A"
        productSelectionPage.selectSortByType("Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(productSelectionPage.beforeSortTheProducts(), productSelectionPage.afterSortingTheProducts());

    }

    //Test 2
    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        topMenuPage.selectMenu("Computers");
        //2.2 Click on Desktop
        categoriesPage.selectCategory("Desktops");
        //2.3 Select Sort By position "Name: A to Z"
        productSelectionPage.selectSortByType("Name: A to Z");
        Assert.assertEquals(productSelectionPage.beforeSortTheProducts(), productSelectionPage.afterSortingTheProducts());
        Thread.sleep(1000);
        //2.4 Click on "Add To Cart"
        productSelectionPage.selectAddToCartProduct("Build your own computer");
        //2.5 Verify the Text "Build your own computer"
        Assert.assertEquals(orderPage.getProductName(), "Build your own computer");
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        orderPage.selectAProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select RAM "8GB [+$60.00]" using Select class.
        orderPage.SelectARam("8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        orderPage.clickAndSelectHDD();
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        orderPage.clickAndSelectOsPremium();
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        orderPage.clickAndSelectTotalCommander();
        Thread.sleep(2000);
        //2.11 Verify the price "$1,475.00"
        Assert.assertEquals(orderPage.getPrice(), "$1,475.00");
        //2.12 Click on "ADD TO CARD" Button.
        orderPage.clickOnAddToCartButton();
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals(orderPage.getMessageAfterAddingToCart(), "The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        orderPage.clickOnCloseButtonOnMessage();
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        homePage.hoverMouseOverShoppingCartLink();
        homePage.clickOnGoToCartLink();
        //2.15 Verify the message "Shopping cart"
        Assert.assertEquals(shoppingCartPage.getShoppingCartText(), "Shopping cart");
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.sendTextToQuantityField("2");
        shoppingCartPage.clickOnUpdateCartButton();
        //2.17 Verify the Total"$2,950.00"
        Assert.assertEquals(shoppingCartPage.getTotalPrice(), "$2,950.00");
        //2.18 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermAndConditions();
        //2.19 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckoutButton();
        //2.20 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals(loginPage.getWelcomeText(), "Welcome, Please Sign In!");
        //2.21Click on “CHECKOUT AS GUEST” Tab
        loginPage.clickOnCheckoutAsGuestButton();
        //2.22 Fill the all mandatory field
        checkOutPage.sendTextToFirstNameField("Prime");
        checkOutPage.sendTextToLastNameField("Testing");
        checkOutPage.sendTextTOEmailField("prime");
        checkOutPage.selectACountryInCountryField("United Kingdom");
        checkOutPage.sendTextToCityField("London");
        checkOutPage.sendTextToAddressField("1 London Road");
        checkOutPage.sendTextToPostCodeField("LL1 LL2");
        checkOutPage.sendTextToPhoneField("08765467654");
        //2.23 Click on “CONTINUE”
        checkOutPage.clickOnContinueButtonCheckout();
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        checkOutPage.clickOnNextDayAirDelivery();
        //2.25 Click on “CONTINUE”
        checkOutPage.clickOnContinueButtonDelivery();
        //2.26 Select Radio Button “Credit Card”
        checkOutPage.clickOnCreditCardPaymentMethod();
        checkOutPage.clickOnContinueButtonPayment();
        //2.27 Select “Master card” From Select credit card dropdown
        checkOutPage.selectCreditCard(1);
        //2.28 Fill all the details
        checkOutPage.sendTextToCardholderNameField("Prime");
        checkOutPage.sendTextToCardNumberField("5555555555554444");
        checkOutPage.selectExpiryMonth("5");
        checkOutPage.selectExpiryYear("2024");
        checkOutPage.sendTextToCardCodeField("123");
        //2.29 Click on “CONTINUE”
        checkOutPage.clickOnContinueButtonCreditCard();
        //2.30 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals(checkOutPage.getPaymentMethodText(), "Payment Method: Credit Card");
        //2.32 Verify “Shipping Method” is “Next Day Air”
        Assert.assertEquals(checkOutPage.getDeliveryMethodText(), "Shipping Method: Next Day Air");
        //2.33 Verify Total is “$2,950.00”
        Assert.assertEquals(checkOutPage.getTotalPriceText(), "$2,950.00");
        //2.34 Click on “CONFIRM”
        checkOutPage.clickOnConfirmButton();
        //2.35 Verify the Text “Thank You”
        Assert.assertEquals(checkOutPage.getThankYouTextAfterOrderConfirmation(), "Thank you");
        //2.36 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals(checkOutPage.getOrderProcessedSuccessfullyTextAfterOrderConfirmation(), "Your order has been successfully processed!");
        //2.37 Click on “CONTINUE”
        checkOutPage.clickOnContinueButtonOnThankYouNote();
        //2.37 Verify the text “Welcome to our store”
        Assert.assertEquals(homePage.getWelcomeTextMessage(), "Welcome to our store");
    }
}
