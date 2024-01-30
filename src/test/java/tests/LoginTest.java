package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import config.ConfigReader;
import pages.PageObjects;

public class LoginTest extends ConfigReader {

    private PageObjects loginPage;

    @BeforeClass
    public void setUpTest() {
        setUp();
        loginPage = new PageObjects(getDriver());
    }

    @Test (priority = 1)
    public void loginTest() {
        getDriver().get(getBaseUrl());

        // case 1 - valid credentials from the config file
        String username = getUsername();
        String password = getPassword();

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        
        loginPage.pauseForView(5000);

        loginPage.clickLoginButton();

        loginPage.pauseForView(5000);

        
    }
    
 // case 2 - invalid credentials password from the config file
  
    @Test (priority = 2)  
    public void loginTestInvalid() {
        getDriver().get(getBaseUrl());

     
        String username = getUsername();
        String password = getPassword();

        loginPage.enterUsername(username);
        loginPage.enterPassword(password +"invalid");
        loginPage.pauseForView(5000);

        loginPage.clickLoginButton();
        loginPage.pauseForView(5000);
        
        loginPage.quitWindow();
        
    }
    
    
}
