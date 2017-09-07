package com.selenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by 米阳 on 7/9/2017.
 */
public class OpenBrowserTest {

    public static void main(String args[]) {
        openChrome();
        openIE();
        openFirefox();

    }

    private static void openChrome() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }

    private static void openIE() {
        System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
    }

    private static void openFirefox() {
        System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
    }

}
