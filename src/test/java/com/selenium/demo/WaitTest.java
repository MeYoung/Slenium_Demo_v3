package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by vidorh on 5/10/2017.
 */
public class WaitTest {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        // 设置全局等待时间为 30S
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void waitTest() {
        driver.get("file:///D:/html/index.html");
        // 点击 wait 按钮
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        // 定位 文本
        By el = By.xpath("//*[@id=\"display\"]/div");
        // 等待元素加载
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(el));
        // 获取 文本值
        String text = driver.findElement(el).getText();
        System.out.println(text);
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @AfterTest
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
