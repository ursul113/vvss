package org.example.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage getLoginPage(){
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        return new LoginPage(driver);
    }

    public HoversPage getHoversPage(){
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");
        return new HoversPage(driver);
    }

    public AddRemoveElementsPage getAddRemoveElementsPage(){
        driver.navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");
        return new AddRemoveElementsPage(driver);
    }


}
