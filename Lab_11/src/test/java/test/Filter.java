package test;

import Model.Item;
import Page.MainPage;
import Service.ItemCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Filter extends CommonConditions{
    @Test
    private void CheckIfAddedTest(){
        Item item= ItemCreator.createShorts();
        String firstItemPrice = new MainPage(driver)
                .openPage()
                .openRunPage()
                .openPriceFilter()
                .inputMaxPrice()
                .getFirstItemPrice();
        Assert.assertEquals(firstItemPrice,item.Price);
    }
}
