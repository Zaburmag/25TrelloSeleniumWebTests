package com.telRan.tests.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTests extends  TestBase{


    @BeforeMethod
    public void ensurePreconditions(){
        if(app.header().isAvatarPresent()){
            app.header().logout();
        }
    }

    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        //clickOnLoginButtonOnWelcomePage
        app.session().login("yuliazaburmag@gmail.com", "naomi_1007");
        //er userLoggedIn (isAvatar present)
        Assert.assertTrue(app.header().isAvatarPresent());
        //is user correct

    }

    @Test
    public void negativeLoginAtlassianAccPositiveTest() throws InterruptedException {
        app.session().login("yuliazaburmag@gmail.com", "naomi_1007");
        Assert.assertTrue(app.session().isLoginErrorPresent());
        Assert.assertFalse(app.header().isAvatarPresent());


    }
}