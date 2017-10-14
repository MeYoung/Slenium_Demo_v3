package com.selenium.pageobjcet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by 米阳 on 14/10/2017.
 */
public class LoginPage {

    // 定位 ifrmae
    public static By loginFrame = By.id("x-URS-iframe");
    // 定位 邮箱地址输入框
    public static By emailField = By.name("email");
    // 定位 密码输入框
    public static By pwdFiled = By.name("password");
    // 定位 登录按钮
    public static By loginBtn = By.id("dologin");


    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 往邮箱文本框输入邮箱
     * @param email 邮箱地址
     */
    public void sendKeysEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    /**
     * 往密码文本框输入密码
     * @param pwd 密码
     */
    public void sendKeysPWD(String pwd) {
        driver.findElement(pwdFiled).clear();
        driver.findElement(pwdFiled).sendKeys(pwd);
    }


    @FindBy(id = "kw")
    public static WebElement emailName;



}
