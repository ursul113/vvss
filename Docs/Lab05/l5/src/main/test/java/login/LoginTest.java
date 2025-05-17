package login;

import base.BaseTest;
import org.example.testdata.LoginDataUtils;
import org.example.pages.LoginPage;
import org.example.pages.SecureAreaPage;
import org.testng.annotations.Test;


import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData1",dataProviderClass = LoginDataUtils.class)
    public void testSuccessfulLogin(String username, String password){
        LoginPage loginPage = homePage.getLoginPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        SecureAreaPage secureAreaPage = loginPage.getSecureAreaPage();
        assertTrue(secureAreaPage.getAlertText().contains("secure area!"));
    }

    @Test(dataProvider = "loginData2",dataProviderClass = LoginDataUtils.class)
    public void testWrongInputsLogin(String username,String password){
        LoginPage loginPage = homePage.getLoginPage();
        String correctPassword = "tom";
        String correctUsername = "SuperSecretPassword!";
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        assertNotEquals(username,correctUsername);
    }

    @Test(dataProvider ="loginData3",dataProviderClass = LoginDataUtils.class )
    public void testEmptyInputsLogin(String username, String password){
        LoginPage loginPage = homePage.getLoginPage();
        String correctUsername = "SuperSecretPassword!";
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        assertNotEquals(username,correctUsername);
    }
}
