package test;

import Page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class priceSumCheck extends CommonConditions {
    @Test
    private void CheckIfCheckoutPriceIsRight(){
        String shoeName = new MainPage(driver)
                .openPage()
                .openRunPage()
                .openSingleItemPage()
                .addToCart()
                .increaseQuantity()
                .moveToCheckoutPage()
                .getAllProductsPrice();
        Assert.assertEquals(shoeName,"15 500 руб.");
    }
}
