package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.demo.gui.pages.desktop.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShopItem extends AbstractUIObject {

    @FindBy( xpath = "//a[contains(@class, 'prdocutname')]")
    private ExtendedWebElement productName;

    @FindBy (xpath = "//div[contains(@class, 'price')]//div")
    private ExtendedWebElement price;

    public ShopItem(WebDriver driver) {
        super(driver);
    }

    public ProductPage getProductPage(){
        this.productName.click();
        return new ProductPage(driver);
    }

}
