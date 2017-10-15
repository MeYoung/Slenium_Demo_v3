package com.selenium.email;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


/**
 * Created by 米阳 on 2017/10/15.
 */
public class RegTest {

    WebDriver driver;

    long time = System.currentTimeMillis();

    @BeforeClass
    public void testChrome() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /**
     * 校验注册  验证码失败提示
     */
    @Test
    public void registerTest() {
        driver.get("http://mail.163.com/");
        driver.switchTo().frame("x-URS-iframe");
//        点击注册
        driver.findElement(By.id("changepage")).click();
//        获取当前页面的句柄
        String handle1 = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handle1.equals(handles)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
//         点击 注册字母邮箱
        driver.findElement(By.xpath(".//*[@id='tabsUl']/li[1]/a")).click();
        driver.findElement(By.id("nameIpt")).sendKeys("M" + String.valueOf(time));
        driver.findElement(By.id("mainPwdIpt")).sendKeys("password");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("password");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(String.valueOf(time / 100));
        driver.findElement(By.id("vcodeIpt")).sendKeys("966va");
        driver.findElement(By.id("sendMainAcodeBtn")).click();
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("123456");
        driver.findElement(By.id("mainRegA")).click();
        String msgText = driver.findElement(By.xpath("//*[@id=\"m_vcode\"]/span")).getText();
        System.out.println(msgText);
        Assert.assertEquals(msgText, "  请填写图片中的验证码");
    }

/*
    @Test
    public void testT() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }
    */

    @AfterClass
    public void closed() {
        driver.quit();
    }
}
