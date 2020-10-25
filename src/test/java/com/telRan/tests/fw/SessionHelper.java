package com.telRan.tests.fw;

import com.telRan.tests.fw.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public  boolean isLoginErrorPresent(){
        return isElementPresent(By.cssSelector("#login-error"));
    }
    public void login(String email, String pwd) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        //fillLoginForm
        //fill email
        type(By.name("user"),email);
        //clickOnLoginWithAtlassianButton
        click(By.id("login"));
        Thread.sleep(10000);
        //fillPassword
        type(By.id("password"),pwd);
        click(By.id("login-submit"));
    }
}

