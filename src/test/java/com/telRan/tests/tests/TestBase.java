package com.telRan.tests.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.telRan.tests.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {


    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp()throws InterruptedException
    {
        app.init();
        app.session().login("yuliazaburmag@gmail.com","naomi_1007");
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("start test" +" with parameters : "+  m.getName(), Arrays.asList(p));
    }

    @AfterMethod
    public void logTestStop(Method m){
        logger.info("stop test " + m.getName());
    }


    @AfterSuite(enabled = true)
    public void tearDown(){
        app.stop();

    }

}