package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by 米阳 on 6/10/2017.
 */
public class IframeTest {
    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开测试界面
     * 点击百度链接
     */
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        // 通过 ID 或者 name 方式 转交控制权
        //driver.switchTo().frame("aa");

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        // 通过webelement 方式转交driver控制权
        driver.switchTo().frame(iframe);
//        driver.switchTo().frame("aa");
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        // driver 控制权转交给原来界面
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面")).click();
    }


    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
