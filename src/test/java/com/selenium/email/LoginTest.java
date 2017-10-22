package com.selenium.email;

import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.*;

        import java.util.concurrent.TimeUnit;

/**
 * Created by 米阳 on 2017/10/15.
 */
public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void testChrome() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://mail.163.com/");
    }

    @AfterMethod
    public void closed() {
        driver.quit();
    }

    @Test
    public void userError() throws InterruptedException {
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("test");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.id("dologin")).click();
        String msgError = driver.findElement(By.xpath(".//*[text()='帐号或密码错误']")).getText();
        System.out.println(msgError);
        Assert.assertEquals(msgError, "帐号或密码错误");
    }


    @Test
    public void login() throws InterruptedException {
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("meyoungtester");
        driver.findElement(By.name("password")).sendKeys("meyoung123");
        driver.findElement(By.id("dologin")).click();
        String text = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(text, "退出");
        String title = driver.getTitle();
        Assert.assertEquals(title, "网易邮箱6.0版");
    }

/*    public void login(WebDriver driver, String userName, String pwd) {
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }*/
}
