package com.zebrunner.carina.demo;

import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTests {

    //Tests if login page opens properly
    @Test
    public void testLoginOpens() {
        HomePageBase homePage = startHomePage();
        LoginPageBase loginPage = homePage.getLoginPage();
        Assert.assertTrue(loginPage.isPageOpened());
    }

    //Tests if error shows after entering incorrect credentials
    @Test
    public void testIncorrectCredentials() {
        HomePageBase homePage = startHomePage();
        LoginPageBase loginPage = homePage.getLoginPage();
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.logIn("aaa", "bbbb");
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }


    //Tests if error shows after entering an email that hasn't been registered
    @Test
    public void testForgotPassword() {
        HomePageBase homePage = startHomePage();
        LoginPageBase loginPage = homePage.getLoginPage();
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.clickForgotPasswordButton();
        loginPage.fillForgotPasswordForm("abc@gmail.com", "aaa");
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }
}
