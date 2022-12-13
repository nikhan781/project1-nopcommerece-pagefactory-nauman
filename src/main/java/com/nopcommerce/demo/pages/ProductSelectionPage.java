package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductSelectionPage extends Utility {
    //Declaring WebElement type variable
    @CacheLookup
    @FindBy(xpath = "//select[@id='products-orderby']")
    WebElement sortBy;
    @CacheLookup
    @FindBy(xpath = "//div[@class='product-grid']//child::*")
    List<WebElement> listOfProductsOptions;
    @CacheLookup
    @FindBy(xpath = "//div[@class='item-grid']/div//h2")
    List<WebElement> productsList;
    @CacheLookup
    @FindBy(xpath = "//div[@class='buttons']")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'List')]")
    WebElement listView;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-grid']//div[1]/div[2]//h2")
    WebElement productTitle;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Nokia Lumia 1020')]")
    WebElement nokiaLumia;

    //This Method will sort the products
    public void selectSortByType(String sortByType) {
        Reporter.log("Select Sort By" + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, sortByType);
        CustomListeners.test.log(Status.PASS, "Selected Sort By " + sortByType);
    }

    //This method will click on Add to cart button the change in product listing

    public void selectAddToCartProduct(String product) {
        Reporter.log("List of Products" + listOfProductsOptions.toString());

        List<WebElement> productsList = listOfProductsOptions;
        try {
            for (WebElement list : productsList) {
                if (list.getText().equalsIgnoreCase(product)) {
                    Actions actions = new Actions(driver);
                    WebElement addCart = addToCartButton;
                    actions.click(addCart).build().perform();
                }
            }
        } catch (StaleElementReferenceException e) {
            productsList = listOfProductsOptions;
        }
        CustomListeners.test.log(Status.PASS, "Selected Product " + product);

    }

    //These 2 methods will verify sort by application
    public ArrayList beforeSortTheProducts() {
        Reporter.log("Product List" + productsList.toString());

        List<WebElement> products = productsList;
        ArrayList<String> originalProductList = new ArrayList<>();
        for (WebElement list : products) {
            originalProductList.add(list.getText());
        }
        CustomListeners.test.log(Status.PASS, "Selected country is ");
        return originalProductList;
    }

    public ArrayList afterSortingTheProducts() {
        Reporter.log("List of Products after sorting" + productsList.toString());

        System.out.println(beforeSortTheProducts());
        Collections.reverse(beforeSortTheProducts());
        System.out.println(beforeSortTheProducts());
        List<WebElement> products = productsList;
        ArrayList<String> afterSortList = new ArrayList<>();
        for (WebElement newList : products) {
            afterSortList.add(newList.getText());
        }
        CustomListeners.test.log(Status.PASS, "Selected country is ");
        return afterSortList;
    }

    //This method will click onm list view
    public void clickOnListViewIcon() {
        Reporter.log("Click on List view" + listView.toString());
        clickOnElement(listView);
        CustomListeners.test.log(Status.PASS, "List View Clicked ");
    }

    //This method will click on Add to cart button the change in product listing

    public void clickOnTheProduct(String product) {
        Reporter.log("Select a product" + listOfProductsOptions.toString());

        List<WebElement> productList = listOfProductsOptions;
        try {
            for (WebElement list : productList) {
                if (list.getText().equalsIgnoreCase(product)) {
                    Actions actions = new Actions(driver);
                    WebElement products = productTitle;
                    actions.moveToElement(products).click().build().perform();
                }
            }
        } catch (StaleElementReferenceException e) {
            productList = listOfProductsOptions;
        }
        CustomListeners.test.log(Status.PASS, "Selected product is " + product);

    }

    //This method will click
    public void clickOnNokiaLumia() {
        Reporter.log("Click on Nokia Lumia" + nokiaLumia.toString());
        clickOnElement(nokiaLumia);
        CustomListeners.test.log(Status.PASS, "Nokia Lumia Clicked");

    }
}
