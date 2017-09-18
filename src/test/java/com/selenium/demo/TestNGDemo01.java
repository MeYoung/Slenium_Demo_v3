package com.selenium.demo;

import org.testng.annotations.*;

/**
 * Created by 米阳 on 2017/9/12.
 */
public class TestNGDemo01 {

    @BeforeClass
    public void beforeClass() {
        System.out.println("这个是 BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("这个是 AfterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("这个是一个 BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("这个是一个 AfterTest");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是一个 BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是一个 AfterMethod");
    }

    @Test
    public void test1() {
        System.out.println("这个是 test1");
    }

    @Test
    public void test2() {
        System.out.println("这个是 test2");
    }
}
