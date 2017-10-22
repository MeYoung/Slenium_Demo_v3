package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by 米阳 on 2017/9/25.
 */
public class BaiduLoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void baiduLoginTest() throws InterruptedException {
//        打开百度首页
        driver.get("https://www.baidu.com");
//        定位登录按钮，并点击
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(2000);
//        定位用户名输入框
        WebElement userTextFiled = driver.findElement(By.name("userName"));
//        清空输入框
        userTextFiled.clear();
//        输入 XXXXX
        userTextFiled.sendKeys("shijin880921");
//        定位密码输入框，并输入XXXXX
        driver.findElement(By.name("password")).sendKeys("xxxxxx");
//        点击登录按钮
        driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
        Thread.sleep(20000);
//        定位用户名标签，并获取标签文本
        String userName = driver.findElement(By.className("user-name")).getText();
        System.out.println("获取到的用户名：" + userName);
    }

    @AfterMethod
    public void closedBrowser() {
        driver.quit();
    }
}
