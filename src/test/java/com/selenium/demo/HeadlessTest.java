package com.selenium.demo;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

/**
 * Created by 米阳 on 2017/9/18.
 */
public class HeadlessTest {

    @Test
    public void firefoxH() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
    }
}
