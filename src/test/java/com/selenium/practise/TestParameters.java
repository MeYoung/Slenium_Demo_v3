package com.selenium.practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by 米阳 on 2017/10/22.
 */
public class TestParameters {

    private static final String DRIVER_FIREFOX = "firefox";
    private static final String DRIVER_CHROME = "chrome";
    private static final String DRIVER_PHANTOMJS = "phantomjs";
    private static final String DRIVER_IE = "ie";

    public static WebDriver driver;
    public static WebDriver openBrowser(String browser) {
        String path = System.getProperty("user.dir");
        if (browser.equals(DRIVER_CHROME)) {
            System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals(DRIVER_IE)) {
            System.setProperty("webdriver.ie.driver", path + "/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browser.equals(DRIVER_FIREFOX)) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("你传入的浏览器名有误为：" + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

    @Parameters({"browser"})
    @Test
    public void testOpen(String br){
       openBrowser(br);
    }
}
