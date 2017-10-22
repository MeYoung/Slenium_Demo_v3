package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
/**
 * Created by vidorh on 5/10/2017.
 */
public class ActionsTest4 {
    WebDriver driver;

    @BeforeClass
    public void openchrome(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
////        实例化 FirefoxDriver
//        driver = new FirefoxDriver();
    }

    @Test
    public void keyTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement ele = driver.findElement(By.id("su"));
        Actions action = new Actions(driver);
        // 在元素上右键
        action.contextClick(ele).perform();
        Thread.sleep(3000);
        //  在上双击
        action.doubleClick(ele).perform();
    }

    @Test
    public void moveTest(){
        driver.get("http://www.qq.com/");
        WebElement ele = driver.findElement(By.className("searchSelected"));
        Actions action = new Actions(driver);
        // 鼠标移动到某个元素上
        action.moveToElement(ele).perform();
    }

    @Test
    public void dragTest() throws InterruptedException {
        driver.get("file:///D:/html/dragAndDrop.html");
        WebElement ele = driver.findElement(By.id("drag"));
//        Thread.sleep(4000);
        Actions action = new Actions(driver);
        // 拖动某个元素到某个坐标
        action.dragAndDropBy(ele,400,400).perform();
    }

    @Test
    public void dragTest1(){
        driver.get("file:///D:/html/dragAndDrop.html");
        WebElement ele1 = driver.findElement(By.id("drag"));
        WebElement ele2 = driver.findElement(By.xpath("html/body/h1"));
        Actions action = new Actions(driver);
        // 在元素1上按住,然后拖动到元素2在释放
        action.clickAndHold(ele1).moveToElement(ele2).release(ele1).perform();
    }

    @Test
    public void selectedTest() throws InterruptedException {
        driver.get("file:///D:/html/index.html");
//        定位下拉框
        WebElement selected = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
//        定位下拉框中的选项
        java.util.List<WebElement> eles = selected.findElements(By.tagName("option"));
        Actions action = new Actions(driver);
        Thread.sleep(3000);
        // 按住 shift ，鼠标点击元素1和元素2
        action.click(eles.get(0)).keyDown(Keys.SHIFT).click(eles.get(2)).keyUp(Keys.SHIFT).perform();

    }

    @Test
    public void robotTest() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        driver.get("file:///D:/html/index.html");
        // 按住 Ctrl + S
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        // 释放 Ctrl + S
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
    }

    @AfterTest
    public void closedriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
