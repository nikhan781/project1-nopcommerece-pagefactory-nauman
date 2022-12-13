package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.TopMenuPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    //Declaring two classes Objects
    TopMenuPage topMenuPage;
    // This method contains objects of Pages
    @BeforeMethod(alwaysRun = true)
    public void pageObjects() {
        topMenuPage = new TopMenuPage();

    }


    @Test(groups = {"sanity", "regression"})
    public void verifySuccessfulPageNavigation() {
        topMenuPage.selectMenu("Electronics");
        Assert.assertEquals(topMenuPage.textOnEachPage(), "Electronics");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifySuccessfulPageNavigation2() {
        topMenuPage.selectMenu("Computers");
        Assert.assertEquals(topMenuPage.textOnEachPage(), "Computers");
    }
}
