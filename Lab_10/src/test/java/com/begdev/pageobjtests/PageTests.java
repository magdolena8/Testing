package com.begdev.pageobjtests;

import Pages.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import dev.failsafe.internal.util.Assert;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class PageTests {
    private final MainPage mainPage = new MainPage();

    @BeforeEach
    public void setUp() throws InterruptedException {
        mainPage.openPage();
    }

    @Test
    public void checkIfValidSortOnEmptyInput() throws InterruptedException {
        mainPage.clickElement(mainPage.itemslonk);
        mainPage.setPrices();
        Assert.isTrue(mainPage.productGrid.findAll("div").size()==0, "Error");
    }

    @Test
    public void checkIfValidPagesOpensAfterPhoneItemClick() {
        mainPage.clickElement(mainPage.secondpagelink);
        Assert.isTrue(mainPage.header.getText().equals("tablet phone"), "Opened invalid page");
    }

    @Test void checkIfValidPagesOpensAfterModelClick(){
        mainPage.openItemsPage();
        Assert.isTrue(mainPage.header.getText().equals("pocophone 13"), "Opened invalid page'");

    }

}
