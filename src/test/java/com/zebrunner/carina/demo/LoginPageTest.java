package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest implements IAbstractTest {

    //Tests if login page opens properly
    @Test
    public void testLoginOpens(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        LoginPageBase loginPage = homePage.getLoginPage();
        Assert.assertTrue(loginPage.isPageOpened());
    }
    //Tests if error shows after entering incorrect credentials
    @Test
    public void testIncorrectCredentials() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        LoginPageBase loginPage = homePage.getLoginPage();
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.enterLogin("aaa");
        loginPage.enterPassword("Abc");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }


    //Tests if error shows after entering an email that hasn't been registered
    @Test
    public void testForgotPassword(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        LoginPageBase loginPage = homePage.getLoginPage();
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.clickForgotPasswordButton();
        loginPage.enterLogin("aaa");
        loginPage.enterEmail("abc@gmail.com");
        loginPage.clickContinueButton();
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }
}
