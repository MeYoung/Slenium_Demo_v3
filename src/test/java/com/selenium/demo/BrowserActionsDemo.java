package com.selenium.demo;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.util.List;

/**
 * Created by 米阳 on 18/9/2017.
 */
public class BrowserActionsDemo {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        // 设置chromedriver系统变量
        System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
        // 启动chrome浏览器
        driver = new InternetExplorerDriver();

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
    public void getTitleTest() {
        // 打开百度首页
        driver.get("https://www.baidu.com");
        // 获取百度首页的title
        String tilte = driver.getTitle();
        System.out.println(tilte);
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
        Dimension dimension = new Dimension(900, 800);
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
        Point point = new Point(500, 600);
        driver.manage().window().setPosition(point);
        // 为了看清楚效果，等待2S
        Thread.sleep(2000);

        // 获取窗口位置，相对屏幕左下角
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
