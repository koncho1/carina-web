package com.zebrunner.carina.demo.gui.pages.common;

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

    public abstract void clickForgotPasswordButton();

    public abstract boolean isErrorMessagePresent();

    public abstract void logIn(String login, String password);

    public abstract void fillForgotPasswordForm(String email, String login);

    @Override
    public void open() {
        super.open();
    }

}
