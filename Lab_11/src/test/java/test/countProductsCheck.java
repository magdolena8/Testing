package test;

import Page.MainPage;
import Util.IntUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class countProductsCheck extends CommonConditions{
    @Test
    private void CheckIfAddedTest() throws InterruptedException {
        String itemQuantity = new MainPage(driver)
                .openPage()
                .openRunPage()
                .openSingleItemPage()
                .addToCart()
                .increaseQuantitySeveralTimes(IntUtils.getRandomInt())
                .getItemQuantity();
        Assert.assertEquals(itemQuantity,"2");
    }
}
