package com.selenium.parallel;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by vidorh on 6/10/2017.
 */
public class ParallelTest2 {
    @BeforeSuite
    public void testt(){
        System.out.println("这是一个suite2");
    }
    @BeforeTest
    public void testtest(){
        System.out.println("这是一个 beforetest2");
    }
    @BeforeClass
    public void testttt(){
        System.out.println("这是一个 beforeClass");
    }
    @Test
    public void test5() throws InterruptedException {
        System.out.println("test5");
        Thread.sleep(5000);
    }

    @Test
    public void test6() throws InterruptedException {
        System.out.println("test6");
        Thread.sleep(5000);
    }

    @Test
    public void test7() throws InterruptedException {
        System.out.println("test7");
        Thread.sleep(5000);
    }

    @Test
    public void test8() throws InterruptedException {
        System.out.println("test8");
        Thread.sleep(5000);
    }
}
