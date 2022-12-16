package test;

import Model.Item;
import Page.MainPage;
import Service.ItemCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class filterSum extends CommonConditions {
    @Test
    private void SearchTest(){
        Item item= ItemCreator.createXLShorts();
        String itemSize = new MainPage(driver)
                .openPage()
                .openRunPage()
                .openSingleShortsPage()
                .choseDestination()
                .addToCart()
                .getProductDescription();
        Assert.assertEquals(itemSize,"Размер одежды: " + item.Description);
    }
}
