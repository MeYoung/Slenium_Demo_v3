package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 米阳 on 2017/9/18.
 */
public class HeadlessTest {

    @Test
    public void headlessChromeDemo() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        设置为 headless 模式 （必须）
        chromeOptions.addArguments("--headless");
//        设置浏览器窗口打开大小  （非必须）
        chromeOptions.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }

    @Test
    public void pjsTest() throws InterruptedException {
        System.setProperty("phantomjs.binary.path", "./drivers/phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }

    @Test
    public void headlessFirefoxDemo() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }

    @Test
    public void testee(){
        String a ="asdfasf 123";
        String regex = "[0-9]+";
        Matcher matcher = Pattern.compile(regex).matcher(a.trim());
        if(matcher.find()){
            String lastChar=matcher.group();
            System.out.println(lastChar);
        }

    }
}
