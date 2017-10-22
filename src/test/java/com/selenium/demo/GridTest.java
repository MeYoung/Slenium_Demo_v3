package com.selenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 米阳 on 2017/10/18.
 */
public class GridTest {

    @Test
    public void teet1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
//        判断要打开的浏览器
        String url = "http://192.168.1.120:4444/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(url), desiredCapabilities);

        Thread.sleep(10000);
//        driver=new ChromeDriver();

    }
}
