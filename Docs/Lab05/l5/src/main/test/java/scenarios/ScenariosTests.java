package scenarios;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import base.BaseTest;
import org.example.pages.AddRemoveElementsPage;
import org.example.pages.LoginPage;
import org.example.pages.SecureAreaPage;
import org.example.testdata.LoginDataUtils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ScenariosTests extends BaseTest {

    @Test(dataProvider = "loginData1",dataProviderClass = LoginDataUtils.class, groups ={"scenario"})
    public void testScenario(String username, String password){
        //test login successful
        LoginPage loginPage = homePage.getLoginPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        SecureAreaPage secureAreaPage = loginPage.getSecureAreaPage();
        assertTrue(secureAreaPage.getAlertText().contains("secure area!"));
        goHome();

        //test hover successful over first element on hovers page
        var hoversPage = homePage.getHoversPage();
        var caption = hoversPage.hoverOverPictures(1);
        assertTrue(caption.isDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(), "name: user1", "Caption titile is incorrect");
        goHome();

        //test add element on add/remove elements page
        AddRemoveElementsPage addRemovePage = homePage.getAddRemoveElementsPage();
        WebElement testButton = addRemovePage.getAddButton();
        int counterBeforeAddAction = addRemovePage.countElements();
        testButton.click();
        int counterAfterAddAction = addRemovePage.countElements();
        assertTrue(counterAfterAddAction-counterBeforeAddAction==1);
    }
}