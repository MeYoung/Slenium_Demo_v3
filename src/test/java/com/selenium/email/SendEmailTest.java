package com.selenium.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by 米阳 on 2017/10/15.
 */
public class SendEmailTest {

    WebDriver driver;

    @BeforeMethod
    public void testChrome() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.163.com/");
    }

    @Test
    public void testSendEmail() {
        LoginDemo.loginSuccess(driver, "meyoungtester", "meyoung123");
        driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("meyoungtester@163.com");
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("测试一下发邮件");
        driver.findElement(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("D:\\a.txt");
//        进入iframe
        WebElement frame = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("html/body")).sendKeys("发送的邮件内容");
//         控制权交回
        driver.switchTo().defaultContent();
//          点击发送
        driver.findElements(By.xpath(".//*[text()='发送']")).get(0).click();
//        校验是否发送成功
        Boolean bl = driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(bl);
    }


    @AfterMethod
    public void closed() {
        driver.quit();
    }
}
