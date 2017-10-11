package com.selenium.datadriver;

import org.testng.annotations.DataProvider;

/**
 * Created by 米阳 on 6/10/2017.
 */
public class Data {
    @DataProvider(name = "dataTest")
    public static Object[][] dataDriver() {
        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }
}
