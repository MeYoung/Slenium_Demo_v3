package com.selenium.pageobjcet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by 米阳 on 14/10/2017.
 */
public class LoginMail {
    WebDriver driver;

    public LoginMail(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 登陆
     *
     * @param emial 邮箱地址
     * @param pwd   密码
     */
    public void login(String emial, String pwd) {
        LoginPage loginPage = new LoginPage(driver);
        WebElement element = driver.findElement(LoginPage.loginFrame);
        driver.switchTo().frame(element);
        loginPage.sendKeysEmail(emial);
        loginPage.sendKeysPWD(pwd);
        driver.findElement(LoginPage.loginBtn).click();
    }
}
