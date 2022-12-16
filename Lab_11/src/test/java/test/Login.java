package test;

import Model.User;
import Page.ProfilePage;
import Page.MainPage;
import Service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends CommonConditions {
    @Test
    private void CheckIfAddedTest(){
        User user= UserCreator.createUser();
        ProfilePage cabinetPage = new MainPage(driver)
                .openPage()
                .openLoginPage()
                .inputLogin(user.Login)
                .inputPassword(user.Password)
                .loginButtonClick();
            Assert.assertEquals(cabinetPage.getClass(), ProfilePage.class);
    }
}
