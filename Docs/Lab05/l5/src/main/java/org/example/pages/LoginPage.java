package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameField = By.cssSelector("#username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#login button");
    private By statusAlert = By.cssSelector("a.close");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username){

        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){

        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage getSecureAreaPage(){
        driver.navigate().to("https://the-internet.herokuapp.com/secure");
        return new SecureAreaPage(driver);
    }


}
