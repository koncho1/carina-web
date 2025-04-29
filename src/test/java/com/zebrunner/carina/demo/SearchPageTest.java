package com.zebrunner.carina.demo;

import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.SearchPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTests {

    private String shirt = "Shirt";
    private String apple = "Apple";

    //Tests if searching for a shirt adds a shirt keyword to filter
    @Test
    public void testSearchShirt() {
        HomePageBase homePage = startHomePage();
        SearchPageBase searchPage = homePage.getSearchPage(shirt);
        Assert.assertTrue(searchPage.isPageOpened());
        Assert.assertTrue(searchPage.isSearchTextCorrect(shirt));
    }


    //Search for an unavailable item
    @Test
    public void testUnsuccesfulSearch() {
        HomePageBase homePage = startHomePage();
        SearchPageBase searchPage = homePage.getSearchPage(apple);
        Assert.assertTrue(searchPage.isPageOpened());
        Assert.assertTrue(searchPage.isNoProductMessagePresent());
    }
}
