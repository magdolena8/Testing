package test;

import Model.Item;
import Page.MainPage;
import Service.ItemCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class addToBasket extends CommonConditions {
    @Test
    private void CheckIfAddedTest(){
        Item item= ItemCreator.createShirt();
        String shoeName = new MainPage(driver)
                .openPage()
                .openRunPage()
                .openSingleItemPage()
                .addToCart()
                .getItemName();
        Assert.assertEquals(shoeName,item.Title);
    }
}
