package com.selenium.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by 米阳 on 2017/9/26.
 * 课时8 练习
 */
public class Practise2 {
    WebDriver driver;

    @BeforeClass
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void closed() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void seachTest() {
        driver.get("http://www.seishipping.com/home/AnnouncementCenter5?nav=announcement");
        driver.findElement(By.id("tbAnnouncementTitle")).sendKeys("船期表");
        driver.findElement(By.id("btSearch")).click();
        List<WebElement> list = driver.findElements(By.name("contents"));
        for (WebElement textList : list) {
            System.out.println(textList.getText());
        }
    }


    @Test
    public void loginTest() {
        driver.get("http://www.seishipping.com/");
        driver.findElement(By.id("UserName")).sendKeys("xxxx");
        driver.findElement(By.id("password")).sendKeys("pwd");
        driver.findElement(By.id("mm_login")).click();
    }
}
