package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.components.CategoryMenu;
import com.zebrunner.carina.demo.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class ProductPage extends ProductPageBase {

    @FindBy (xpath = "//h1[contains(@class, 'productname')]//span")
    private ExtendedWebElement productNameLabel;

    @FindBy (xpath= "//ul[contains(@class, 'nav-pills categorymenu'")
    private CategoryMenu categoryMenu;

    @FindBy (xpath = "//input[contains(@name, 'quantity')]")
    private ExtendedWebElement itemQuantityLabel;


    @FindBy (xpath = "//span[contains(@class, 'total-price')]")
    private ExtendedWebElement totalPriceLabel;


    public boolean isProductNamePresent(){
        return productNameLabel.isPresent();
    }

    public ProductPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(productNameLabel);
    }

    public boolean isItemQuantityCorrect(String quantity){
        return Objects.equals(itemQuantityLabel.getAttribute("value"),quantity);
    }

    public boolean isTotalPriceCorrect(String price){
        return Objects.equals(totalPriceLabel.getText(),price);
    }

    public void enterNewItemQuantity(String newQuantity){
        itemQuantityLabel.click();
        itemQuantityLabel.type(newQuantity);
    }
}
