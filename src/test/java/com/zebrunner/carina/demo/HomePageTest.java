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
package com.zebrunner.carina.demo;

import com.zebrunner.carina.demo.gui.pages.common.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;

public class HomePageTest implements IAbstractTest {


    //Tests if changing the currency changes the currency letter in cart
    @Test
    public void testCurrencyChange() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.clickCurrencySelector();
        homePage.clickFirstItemInCurrencySelector();
        Assert.assertTrue(homePage.isCurrencyInCartCorrect("£"));
    }


    //Tests the total price in cart after adding an item
    @Test
    public void testCartTotal(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.clickAddToCartButton();
        Assert.assertTrue(homePage.isCartTotalCorrect("$29.50"));
    }


    //Checks if adding multiple items to cart changes the number of items in home page
    @Test
    public void testCartItemCount(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.clickAddToCartButton();
        homePage.clickAddToCartButton();
        homePage.clickAddToCartButton();
        Assert.assertTrue(homePage.isCartItemCountCorrect("3"));

    }


}
