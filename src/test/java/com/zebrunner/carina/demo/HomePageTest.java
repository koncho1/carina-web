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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTests {


    //Tests if changing the currency changes the currency letter in cart
    @Test(dataProvider = "currencyValuesProvider")
    public void testCurrencyChange(String enteredCurrency, String expectedCurrency) {
        HomePageBase homePage = super.startHomePage();
        homePage.changeCurrency(enteredCurrency);
        Assert.assertTrue(homePage.isCurrencyInCartCorrect(expectedCurrency));
    }


    //Tests the total price in cart after adding an item
    @Test
    public void testCartTotal() {
        HomePageBase homePage = startHomePage();
        homePage.clickAddToCartButton();
        Assert.assertTrue(homePage.isCartTotalCorrect("$29.50"));
    }


    //Checks if adding multiple items to cart changes the number of items in home page
    @Test(dataProvider = "itemCountProvider")
    public void testCartItemCount(int numberOfItemsToAdd, String expectedNumberInCart) {
        HomePageBase homePage = startHomePage();
        homePage.addItemsToCart(numberOfItemsToAdd);
        Assert.assertTrue(homePage.isCartItemCountCorrect(expectedNumberInCart));

    }

    @DataProvider(name = "currencyValuesProvider")
    public static Object[][] currencyProvider() {
        return new Object[][]{
                {"£", "£"},
                {"$", "$"},
                {"€", "€"}
        };
    }

    @DataProvider(name = "itemCountProvider")
    public static Object[][] itemCountProvider() {
        return new Object[][]{
                {3, "3"},
                {1, "1"},
                {5, "5"}
        };
    }

}
