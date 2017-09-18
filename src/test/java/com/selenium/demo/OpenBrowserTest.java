package com.selenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by 米阳 on 7/9/2017.
 */
public class OpenBrowserTest {

    public static void main(String args[]) {
        openEdge();
    }

    private static void openEdge() {
//        指定MicrosoftWebDriver路径
        System.setProperty("webdriver.edge.driver", ".\\drivers\\MicrosoftWebDriver.exe");
//        启动 Edge浏览器
        WebDriver driver = new EdgeDriver();
    }

/*    private static void openFirefoxByGeck() {
//        设置系统变量,并设置 geckodriver 的路径为系统属性值
        System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
//        实例化 FirefoxDriver
        WebDriver driver = new FirefoxDriver();
    }*/

/*    private static void openFirefoxDef(){
 //       实例化 FirefoxDriver
        WebDriver driver = new FirefoxDriver();
    }*/


/*    private static void openIE() {
//        设置系统变量,并设置 IEDriverServer 的路径为系统属性值
        System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
//        实例化 InternetExplorerDriver
        WebDriver driver = new InternetExplorerDriver();
    }*/
/*
    private static void openChrome() {
//        设置系统变量,并设置 chromedriver 的路径为系统属性值
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
//        实例化ChromeDriver
        WebDriver driver = new ChromeDriver();
    }*/

}








