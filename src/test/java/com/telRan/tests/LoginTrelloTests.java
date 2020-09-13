package com.telRan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTrelloTests {
    WebDriver wd;


    @BeforeClass
    public void setUp(){
        //create in instance of Webdriver(open chrone driver)
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        //open site
        wd.navigate().to("https://trello.com/");


    }
    @Test
    public void loginAtlassianAccPositive() throws InterruptedException {
        //clickOnLoginWelcomePage
        wd.findElement(new By.ByCssSelector("[href='/login]")).click();


        //fillLoginForm
        //fill email
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("yuliazaburmag@gmail.com");

        //wait
        Thread.sleep(10000);
        //login with Atlassian button
        //fill password

        wd.findElement(By.id("login")).click();
        Thread.sleep(10000);
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("julia@54321");
        //click login button(confirm)
        wd.findElement(By.id("login-submit")).click();

        //expect res. userLoged(isAvatarPresent)


    }
    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();

    }


}