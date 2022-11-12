package org.example;

import com.sun.tools.javac.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWebDriverTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        MainPage page= new MainPage(driver);
        page.OpenPage();
        page.SetCode();
        page.SetPasteExpiration();
        page.SetName();
        page.ClickCreateNewPasteButton();
    }
}