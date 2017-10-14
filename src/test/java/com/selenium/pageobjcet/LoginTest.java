package com.selenium.pageobjcet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by 米阳 on 14/10/2017.
 */
public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() {
        driver.get("http://mail.163.com/");
        LoginPage loginPage = new LoginPage(driver);
        WebElement element = driver.findElement(LoginPage.loginFrame);
        driver.switchTo().frame(element);
        loginPage.sendKeysEmail("meyoungtester");
        loginPage.sendKeysPWD("meyoung123");
        driver.findElement(LoginPage.loginBtn).click();
    }

    @Test
    public void testLogin2() {
        driver.get("http://mail.163.com/");
        LoginMail loginMail = new LoginMail(driver);
        loginMail.login("meyoungtester", "meyoung123");
    }

    @Test
    public void test(){
        driver.get("https://www.baidu.com");
        // 初始化 LoginPage
        PageFactory.initElements(driver ,LoginPage.class);
        LoginPage.emailName.sendKeys("Test");
    }

    @AfterClass
    public void closedChrome() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
