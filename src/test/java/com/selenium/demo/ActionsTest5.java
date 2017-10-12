package com.selenium.demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by 米阳 on 6/10/2017.
 */
public class ActionsTest5 {

    WebDriver driver;

    @BeforeClass
    public void openchrome() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @AfterClass
    public void closedriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    /**
     * 打开百度首页
     * 判断是否显示百度一下按钮
     */
    @Test
    public void isDisplayedTest() {
        driver.get("http://www.baidu.com");
        Boolean b = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b, "校验百度一下按钮是否显示");
    }

    /**
     * 打开测试页面
     * 判断Volvo单选框被选中
     */
    @Test
    public void idSelectTest() {
        driver.get("file:///C:/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
        element.click();
        Boolean b = element.isSelected();
        Assert.assertTrue(b);
    }

    /**
     * 打开测试页面
     * 判断 sumbit 按钮处于未激活状态
     */
    @Test
    public void isEnabledTest() {
        driver.get("file:///C:/selenium_html/index.html");
        Boolean b = driver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(b);
    }

    /**
     * 截图百度首页
     */
    @Test
    public void shotTest() throws IOException {
        driver.get("http://www.baidu.com");
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(".\\test12.jpg"));
    }

    @Test
    public void exJS() throws InterruptedException {
        driver.get("http://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // 执行JS语句
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"执行JS\")");
        Thread.sleep(5000);
    }


}
