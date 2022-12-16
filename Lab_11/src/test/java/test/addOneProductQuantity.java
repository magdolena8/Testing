package test;

import Page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class addOneProductQuantity extends CommonConditions {
    @Test
    private void CheckIfAddedTest(){
        String quantity = new MainPage(driver)
                .openPage()
                .openRunPage()
                .openSingleItemPage()
                .addToCart()
                .increaseQuantity()
                .getItemQuantity();
        Assert.assertEquals(quantity,"2");
    }
}
