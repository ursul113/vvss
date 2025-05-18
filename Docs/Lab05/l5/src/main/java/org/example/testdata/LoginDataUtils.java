package org.example.testdata;


import org.testng.annotations.DataProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoginDataUtils {
    @DataProvider(name="loginData1")
    public static Object[][] getLoginData1() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        LoginData[] loginData = objectMapper.readValue(new File("resources/data.json"), LoginData[].class);
        String username = loginData[0].getUsername();
        String password = loginData[0].getPassword();
        return new Object[][]{{username, password}};
    }

    @DataProvider(name="loginData2")
    public static Object[][] getLoginData2() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        LoginData[] loginData = objectMapper.readValue(new File("resources/data.json"), LoginData[].class);
        String username = loginData[1].getUsername();
        String password = loginData[1].getPassword();
        return new Object[][]{{username, password}};
    }

    @DataProvider(name="loginData3")
    public static Object[][] getLoginData3() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        LoginData[] loginData = objectMapper.readValue(new File("resources/data.json"), LoginData[].class);
        String username = loginData[2].getUsername();
        String password = loginData[2].getPassword();
        return new Object[][]{{username, password}};
    }



}
