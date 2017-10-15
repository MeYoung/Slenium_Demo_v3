package com.selenium.practise;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by 米阳 on 2017/9/24.
 * 课时7 练习
 */
public class FirstPractise {
    WebDriver driver;

    @BeforeClass
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test1() {
        driver.get("http://www.seishipping.com/home/AnnouncementCenter5?nav=announcement");
        WebElement searchInput = driver.findElement(By.id("tbAnnouncementTitle"));
        WebElement searchButon = driver.findElement(By.id("btSearch"));
        List<WebElement> NoticeList = driver.findElements(By.name("contents"));
        NoticeList.get(1);
        //        不唯一
//        WebElement news = driver.findElement(By.linkText("本站新闻"));
//        WebElement news =  driver.findElement(By.xpath("//*[@id=\"b1\"]/span[2]"));
    }

    @AfterClass
    public void closed() {
        driver.quit();
    }
}
