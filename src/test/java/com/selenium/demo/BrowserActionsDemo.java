package com.selenium.demo;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by 米阳 on 18/9/2017.
 */
public class BrowserActionsDemo {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        // 设置chromedriver系统变量
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        // 启动chrome浏览器
        driver = new ChromeDriver();

    }

    @Test
    public void getURLTest() {
        driver.get("https://www.baidu.com");
        String url = driver.getCurrentUrl();
        System.out.println("获取到的URL：" + url);
    }

    @Test
    public void backTest() throws InterruptedException {
        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 等同get()方法
        driver.navigate().to("https://google.com");
        // 为了看清楚效果，等待2S
        Thread.sleep(2000);
        // 浏览器后退
        driver.navigate().back();
        // 为了看清楚效果，等待2S
        Thread.sleep(2000);
        // 浏览器前进
        driver.navigate().forward();
    }

    @Test
    public void refreshTest() {
        // 打开百度首页
        driver.get("http://www.baidu.com");
        // 刷新当前页面
        driver.navigate().refresh();
    }

    @Test
    public void windowTest() throws InterruptedException {
        // 全屏
        driver.manage().window().fullscreen();
        // 为了看清楚效果，等待2S
        Thread.sleep(2000);

        // 设置浏览器大小
        Dimension dimension = new Dimension(500, 500);
        driver.manage().window().setSize(dimension);
        // 为了看清楚效果，等待2S
        Thread.sleep(2000);

        // 获取窗口大小
        Dimension dimension1 = driver.manage().window().getSize();
        int h = dimension1.getHeight();
        int w = dimension1.getWidth();
        System.out.println("h:" + h + "w:" + w);
        // 为了看清楚效果，等待2S
        Thread.sleep(2000);

        // 最大化
        driver.manage().window().maximize();
        // 为了看清楚效果，等待2S
        Thread.sleep(2000);

        // 设置窗口位置，相对屏幕左下角
        Point point = new Point(50, 60);
        driver.manage().window().setPosition(point);
        // 为了看清楚效果，等待2S
        Thread.sleep(2000);

        // 获取窗口位置，相对屏幕左上角
        Point point1 = driver.manage().window().getPosition();
        int x = point1.getX();
        int y = point1.getY();
        System.out.println("x:" + x + "y:" + y);
    }

    @AfterMethod
    public void closedChrome() throws InterruptedException {
        // 为了看效果，线程等待5S
        Thread.sleep(5000);
        // 关闭所有窗口，并退出
        driver.quit();
    }
}
