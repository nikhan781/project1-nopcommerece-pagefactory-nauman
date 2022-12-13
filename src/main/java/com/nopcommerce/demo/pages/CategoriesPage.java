package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class CategoriesPage extends Utility {


    //Declaring WebElement type variable
    @CacheLookup
    @FindBy(xpath = "//div[@class='item-grid']/child::*")
    List<WebElement> categoriesList;

    //Select category
    public void selectCategory(String cat) {
        Reporter.log("The Category List is " + categoriesList.toString());
        List<WebElement> catList = categoriesList;
        try {
            for (WebElement list : catList) {
                if (list.getText().equalsIgnoreCase(cat)) {
                    list.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            catList = categoriesList;
        }
        CustomListeners.test.log(Status.PASS, "The category is \"" + cat + "\"");
    }
}
