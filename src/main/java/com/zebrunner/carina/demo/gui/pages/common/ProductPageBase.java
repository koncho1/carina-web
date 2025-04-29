package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

    public abstract boolean isProductNamePresent();

    public abstract boolean isItemQuantityCorrect(String quantity);

    public abstract boolean isTotalPriceCorrect(String price);

    public abstract void enterNewItemQuantity(String newQuantity);

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }
}
