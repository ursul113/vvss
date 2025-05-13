package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemoveElementsPage {
    private WebDriver driver;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addElement(){
        List<WebElement> buttons = driver.findElements(By.cssSelector(".added-manually"));
        WebElement newButton = (WebElement) ((JavascriptExecutor)driver).executeScript("var button = document.createElement('button'); button.setAttribute('id', 'button-id-1'); button.innerHTML='My Button'; return button;");
        buttons.add(newButton);
    }

    public WebElement getAddButton(){
        WebElement div = driver.findElement(By.cssSelector(".example"));
        WebElement button = div.findElement(By.cssSelector("button"));
        return button;

    }

    public int countElements(){
        //int counter;
        WebElement div = driver.findElement(By.cssSelector("#elements"));
        List<WebElement> elements = div.findElements(By.cssSelector(".added-manually"));
        return elements.size();
    }

    public WebElement getRemoveButton(){
        WebElement div = driver.findElement(By.cssSelector("#elements"));
        List<WebElement> elements = div.findElements(By.cssSelector(".added-manually"));
        return elements.get(0);
    }
}
