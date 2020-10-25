package com.telRan.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfileHelper extends HelperBase{
    public ProfileHelper(WebDriver wd) {
        super(wd);
    }


    public  void  switchToAtllassinAccWindow(){
        String trello = wd.getWindowHandle();
        System.out.println(trello);
        waitForElementAndClick(By.cssSelector("a[href$=manage-profile]"),2000);

        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()){
            wd.switchTo().window(availableWindows.get(1));
        }
//now selenium on Atlassian page
        String atlassianAcc = wd.getWindowHandle();
        System.out.println(atlassianAcc);

    }
    public void changeAvatar() throws InterruptedException {
        WebElement avatar = wd.findElement(By.cssSelector("[data-test-selector='profile"));
        new Actions(wd).moveToElement(avatar).perform();
        click(By.cssSelector(".sc-iuJeZd"));
        Thread.sleep(2000);
        click(By.xpath("//*[@data-role='droplistContent']//*[@role='menuitem'][1]"));
        Thread.sleep(2000);
        takeScreenshot();
       // click(By.cssSelector("#image-input"));
        uploadFile(By.cssSelector("//*[@id='image-input']"),new File("C:/Users/yulia/Documents/GitHub/25TrelloSeleniumWebTests/src/test/resources/cat_small1.png"));
// confirm upload

        click(By.xpath("//*[contains(., 'Upload')]"));
        Thread.sleep(3000);
        takeScreenshot();
        
    }
}
