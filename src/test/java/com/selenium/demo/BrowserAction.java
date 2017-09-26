package com.selenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by 米阳 on 2017/9/17.
 * <p>
 * 浏览器的操作，打开，关闭，输入URL，前进，后退，刷新，最大化，获取URL，
 * <p>
 * PhantomJS 介绍
 */
public class BrowserAction {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void getURL() {
        driver.get("http://www.baidu.com");
    }

    @AfterMethod
    public void closedBrowser(){
        driver.close();
//        driver.quit();
    }
}
