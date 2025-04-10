package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductPageBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductPageTest implements IAbstractTest {


    //Checks if the product page opens properly
    @Test
    public void testClickProduct(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        ProductPageBase productPage=homePage.getProductPage();
        Assert.assertTrue(productPage.isProductNamePresent());
    }


    //Checks if changing the quantity also changes price
    @Test(dataProvider = "TestValuesProvider")
    public void testChangeQuantityChangePrice(String beginningQuantity, String enteredQuantity, String expectedValue){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        ProductPageBase productPage=homePage.getProductPage();
        Assert.assertTrue(productPage.isProductNamePresent());
        Assert.assertTrue(productPage.isItemQuantityCorrect(beginningQuantity));
        Assert.assertTrue(productPage.isTotalPriceCorrect("$29.50"));
        productPage.enterNewItemQuantity(enteredQuantity);
        Assert.assertTrue(productPage.isItemQuantityCorrect(enteredQuantity));
        Assert.assertTrue(productPage.isTotalPriceCorrect(expectedValue));
    }


    @DataProvider (parallel = false, name = "TestValuesProvider")
    public static Object[][] dataprovider(){
        return new Object[][] {
                {"1", "2", "$59.00"},
                {"1", "4", "$118.00"},
                {"1", "5", "$147.50"}
        };
    }

}
