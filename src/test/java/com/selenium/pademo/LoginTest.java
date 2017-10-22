package com.selenium.pademo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by 米阳 on 2017/10/15.
 */
public class LoginTest {

    WebDriver driver;
    LoginDemo loginDemo;

    @BeforeMethod
    public void testChrome() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://mail.163.com/");
        loginDemo = new LoginDemo(driver);
    }

    @Test
    public void loginTest() {
/*        WebElement ifra = driver.findElement(LoginPage.iframe);
        driver.switchTo().frame(ifra);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendEmail("fasdfafd");
        loginPage.sendpwd("fafadf");
        driver.findElement(LoginPage.loginBtn).click();*/

        loginDemo.login("adfasdfa","fasfadf");
//        Assert......

    }


    @Test
    public void loginETest() {
        loginDemo.login("fasdfa","fafadf");
//        asssert

    }
}
