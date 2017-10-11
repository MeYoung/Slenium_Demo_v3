package com.selenium.demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by 米阳 on 2/10/2017.
 */
public class SelectDemo {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void selectTest() throws InterruptedException {
        // 打开测试页面
        driver.get("file:///D:/html/index.html");
        // 定位下拉框
        WebElement selectHtml = driver.findElement(By.name("select"));
        // 实例化Select
        Select select = new Select(selectHtml);

        // 为了看效果，线程等待2S
        Thread.sleep(2000);
        // 通过下拉框文本值选取
        select.selectByVisibleText("Opel");
        // 为了看效果，线程等待2S
        Thread.sleep(2000);
        // 通过下拉框索引选取
        select.selectByIndex(2);
        // 为了看效果，线程等待2S
        Thread.sleep(2000);
        // 通过 value 属性值选取
        select.selectByValue("volvo");
    }


    @Test
    public void getOptionsTest(){
        // 打开测试页面
        driver.get("file:///D:/html/index.html");
        // 定位下拉框
        WebElement selectHtml = driver.findElement(By.name("select"));
        // 实例化Select
        Select select = new Select(selectHtml);
        // 获取第一个选择选项
        WebElement element = select.getFirstSelectedOption();
        // 获取第一选项的Text
        String text = element.getText();
        System.out.println(text);
        // 获取所有的选项
        List<WebElement> optionsList= select.getOptions();
        // 循环输出所有选项的Text
        for(WebElement option:optionsList){
            String optionText = option.getText();
            System.out.println(optionText);
        }


    }

    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        //driver.close();
        Thread.sleep(3000);
        driver.quit();
    }
}
