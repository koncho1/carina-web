package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import org.testng.Assert;


public abstract class BaseTests implements IAbstractTest {

    public HomePageBase startHomePage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        return homePage;
    }

}
