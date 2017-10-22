package com.selenium.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Created by 米阳 on 6/10/2017.
 */
public class AlertTest {
    WebDriver driver;


    @BeforeClass
    public void openChrome() {
        System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");

//        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new FirefoxDriver();
    }

    /**
     * 1. 打开“UI自动化测试”主页
     * 2. 点击Alert按钮
     * 3.  在alert警告框点击确定按钮
     */

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        // 把控制权转交给 alert
        Alert alert = driver.switchTo().alert();
        // 获取警告框的文本值
        String text = alert.getText();
        System.out.println(text);
        // 点击警告窗确定按钮
        alert.accept();
    }


    /**
     * 1. 打开“UI自动化测试”主页
     * 2. 点击Confirm按钮
     * 3. 在Confirm警告框点击取消按钮
     * 4. 再次点击确定按钮
     */
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
//        driver控制权转交给　alert
        Alert alert = driver.switchTo().alert();
//        点击取消
        alert.dismiss();
        Thread.sleep(3000);
//        点击确定
        alert.accept();
    }

    /**
     * 1. 打开“UI自动化测试”主页
     * 2. 点击Prompt按钮
     * 3. 在Prompt 弹窗中，输入“这个是Prompt”
     * 4.  点击确定
     * 5. 再次点击确定按钮
     */
    @Test
    public void promptTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(2000);
        // driver控制权转交给　alert
        Alert alert = driver.switchTo().alert();
        // 往弹窗输入 文本
        alert.sendKeys("这个是Prompt");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }


    @AfterClass
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
