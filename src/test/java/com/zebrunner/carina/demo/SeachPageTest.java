package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.SearchPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeachPageTest implements IAbstractTest {

    //Tests if searching for a shirt adds a shirt keyword to filter
    @Test
    public void testSearchShirt(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        SearchPageBase searchPage= homePage.getSearchPage("Shirt");
        Assert.assertTrue(searchPage.isPageOpened());
        Assert.assertTrue(searchPage.isSearchTextCorrect("Shirt"));
    }


    //Search for an unavailable item
    @Test
    public void testUnsuccesfulSearch(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        SearchPageBase searchPage= homePage.getSearchPage("Apple");
        Assert.assertTrue(searchPage.isPageOpened());
        Assert.assertTrue(searchPage.isNoProductMessagePresent());
    }
}
