package test;

import Model.Item;
import Page.MainPage;
import Service.ItemCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class filterSearch extends CommonConditions{
    @Test
    private void SearchTest(){
        Item item= ItemCreator.createShirtWithFullName();
        String itemName = new MainPage(driver)
                .openPage()
                .inputSearch(item.Title)
                .startSearch()
                .getSingleItemName();
        Assert.assertEquals(itemName,item.Title);
    }
}
