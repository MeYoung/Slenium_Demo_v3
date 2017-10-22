package com.selenium.pademo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by 米阳 on 2017/10/15.
 */
public class LoginPage {
    public static By iframe = By.id("x-URS-iframe");

    public static By emailField = By.name("email");

    public static By pwdField = By.name("password");

    public static By loginBtn = By.id("dologin");

    @FindBy(id = "kw")
    public static WebElement seachField;

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void sendEmail(String email){
        driver.findElement(LoginPage.emailField).clear();
        driver.findElement(LoginPage.emailField).sendKeys(email);
    }

    public void sendpwd(String pwd){
        driver.findElement(LoginPage.pwdField).clear();
        driver.findElement(LoginPage.pwdField).sendKeys(pwd);
    }

}
