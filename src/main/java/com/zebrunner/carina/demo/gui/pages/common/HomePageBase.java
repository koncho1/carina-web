/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.demo.gui.pages.desktop.LoginPage;
import com.zebrunner.carina.demo.gui.pages.desktop.ProductPage;
import com.zebrunner.carina.demo.gui.pages.desktop.SearchPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class HomePageBase extends AbstractPage {

    public abstract LoginPage getLoginPage();

    public abstract SearchPage getSearchPage(String searchText);

    public abstract boolean isCartTotalCorrect(String correctCartTotal);

    public abstract void clickAddToCartButton();

    public abstract boolean isCartItemCountCorrect(String correctItemCount);

    public abstract void clickCurrencySelector();

    public abstract ProductPage getProductPage();

    public abstract void addItemsToCart(int numberOfItems);

    public abstract void changeCurrency(String currency);

    public abstract boolean isCurrencyInCartCorrect(String currencySign);

    @Override
    public void open() {
        super.open();
    }

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }


}
