package com.selenium.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by 米阳 on 2017/10/15.
 */
public class LoginDemo {

    public static void loginSuccess(WebDriver driver, String userName, String pwd) {
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }
}
