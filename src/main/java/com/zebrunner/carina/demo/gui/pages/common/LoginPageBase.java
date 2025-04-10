package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.demo.gui.components.CategoryMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    private ExtendedWebElement sectionText;

    public LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    private ExtendedWebElement loginField;

    private ExtendedWebElement passwordField;

    private ExtendedWebElement loginButton;

    private CategoryMenu categoryMenu;

    private ExtendedWebElement errorMessage;

    private ExtendedWebElement forgotPasswordButton;

    private ExtendedWebElement emailField;

    private ExtendedWebElement continueButton;

    public abstract void clickForgotPasswordButton();

    public abstract void enterLogin(String login);

    public abstract void enterEmail(String email);

    public abstract void clickContinueButton();

    public abstract boolean isErrorMessagePresent();

    public abstract void enterPassword(String password);

    public abstract void clickLoginButton();

    @Override
    public void open() {
        super.open();
    }

}
