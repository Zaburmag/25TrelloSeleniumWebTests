package com.telRan.tests.fw;


import com.telRan.tests.model.Board;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    SessionHelper session;
    BoardHelper board;
    HeaderHelper header;
    TeamHelper team;
    LeftNavigationMenuPage leftNav;
    ProfileHelper profile;

    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }


    public void init() {

        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }

        wd= new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        //open site
        wd.navigate().to("https://trello.com/");

        session = new SessionHelper(wd);
        board = new BoardHelper( wd);
        header = new HeaderHelper(wd);
        team = new TeamHelper(wd);
        leftNav = new LeftNavigationMenuPage(wd);
        profile = new ProfileHelper(wd);
    }

    public SessionHelper session() {
        return session;
    }
    public LeftNavigationMenuPage LeftNav() {
        return leftNav;
    }

    public LeftNavigationMenuPage profile() {
        return leftNav;
    }



    public BoardHelper board() {
        return board;
    }
    public HeaderHelper header() {
        return header;
    }
    public TeamHelper team() {
        return team;
    }
    public void stop(){
        wd.quit();
    }


    public LeftNavigationMenuPage leftNav() {//?
        return leftNav;
    }
}



