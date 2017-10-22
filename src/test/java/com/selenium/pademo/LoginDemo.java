package com.selenium.pademo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.lang.ref.WeakReference;

/**
 * Created by 米阳 on 2017/10/15.
 */
public class LoginDemo {
    WebDriver driver;
    public LoginDemo(WebDriver driver){
        this.driver=driver;
    }

    public void login(String email,String pwd){
        WebElement ifra = driver.findElement(LoginPage.iframe);
        driver.switchTo().frame(ifra);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendEmail("fasdfafd");
        loginPage.sendpwd("fafadf");
//         验证码操作
        driver.findElement(LoginPage.loginBtn).click();
    }

    @Test
    public void tests(){
        driver.get("http://www.baidu.com");
        PageFactory.initElements(driver,LoginPage.class);

        LoginPage.seachField.sendKeys("fafadf");
    }
}
