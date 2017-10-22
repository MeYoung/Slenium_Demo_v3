package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by 米阳 on 2017/9/25.
 */
public class ActionsTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开百度页面
     * 通过xpath 百度一下按钮
     */
    @Test
    public void byXpath() {
        driver.get("http://www.baidu.com");
        WebElement e1 = driver.findElement(By.xpath(".//*[@id='u1']/a[2]"));
    }

    @Test
    public void clickTest() {
        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 定位 新闻 链接文本
        WebElement newsLink = driver.findElement(By.xpath(".//*[@id='u1']/a[1]"));
        // 点击 新闻 链接
        newsLink.click();
    }

    @Test
    public void getTitleTest() {
//        打开百度页面
        driver.get("http://www.baidu.com");
//        获取页面title值
        String title = driver.getTitle();
//        控制台输出
        System.out.println(title);
    }

    @Test
    public void sendKeysTest() {
        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 定位搜索框 并输入 "selenium"
        driver.findElement(By.id("kw")).sendKeys("selenium");
        // 定位百度一下按钮，并点击
        driver.findElement(By.id("su")).click();
    }

    @Test
    public void clearTest() throws InterruptedException {
        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 定位搜索框
        WebElement searchTextFiled = driver.findElement(By.id("kw"));
        // 输入 "selenium"
        searchTextFiled.sendKeys("selenium");
        // 为了看到效果，等待3S
        Thread.sleep(3000);
        // 清空文本框
        searchTextFiled.clear();
    }

    @Test
    public void getTextTest() {
        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 定位首页右上角文本,多个元素用findElements()
        List<WebElement> listText = driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (WebElement element : listText) {
            // 获取元素文本
            String text = element.getText();
            System.out.println(text);
        }
    }

    @Test
    public void getAttributeTest() throws InterruptedException {
        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 定位 登录 链接，并点击
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(3000);
        // 定位用户名文本框元素 并获取该元素placeholder的属性值
        String placeholderValue = driver.findElement(By.id("TANGRAM__PSP_10__userName")).getAttribute("placeholder");
        System.out.println(placeholderValue);
    }

    @Test
    public void submitTest() throws InterruptedException {
        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 定位 登录 链接，并点击
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(3000);
        // 定位用户名文本框,不做任何操作，直接提交表单
        driver.findElement(By.id("TANGRAM__PSP_10__userName")).submit();
    }


    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
//        driver.quit();
    }
}
