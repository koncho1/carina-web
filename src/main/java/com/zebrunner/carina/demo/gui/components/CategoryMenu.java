package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CategoryMenu extends AbstractUIObject {

    @FindBy (xpath = "//a[contains(@class, 'active menu_home')]")
    ExtendedWebElement homeButton;

    @FindBy (xpath = "//a[contains(text(), '  Apparel & accessories')]")
    ExtendedWebElement apparelAndAccessoriesButton;

    @FindBy (xpath = "//a[contains(text(), '  Makeup')]")
    ExtendedWebElement makeupButton;

    @FindBy (xpath = "//a[contains(text(), '  Skincare')]")
    ExtendedWebElement skincareButton;

    @FindBy (xpath = "//a[contains(text(), '  Fragnance')]")
    ExtendedWebElement fragnanceButton;

    @FindBy (xpath = "//a[contains(text(), '  Men')]")
    ExtendedWebElement menButton;

    @FindBy (xpath = "//a[contains(text(), '  Hair care')]")
    ExtendedWebElement hairCareButton;

    @FindBy (xpath = "//a[contains(text(), '  Books')]")
    ExtendedWebElement booksButton;

    public void openBooksSection(){
        booksButton.click();
    }

    public void openHairCareSection(){
        hairCareButton.click();
    }

    public void openMenSection(){
        menButton.click();
    }

    public void openFragnanceSection(){
        fragnanceButton.click();
    }

    public void openSkincareSection(){
        skincareButton.click();
    }

    public void openMakeupSection(){
        makeupButton.click();
    }

    public void openApparelAndAccessoriesSection(){
        apparelAndAccessoriesButton.click();
    }

    public void openHome(){
        homeButton.click();
    }

    public CategoryMenu(WebDriver driver) {
        super(driver);
    }
}
