package com.selenium.parallel;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by vidorh on 6/10/2017.
 */
public class ParallelTest1 {
    @BeforeSuite
    public void testt() {
        System.out.println("这是一个suite1");
    }

    @BeforeTest
    public void testtest() {
        System.out.println("这是一个 beforetest1");
    }

    @BeforeClass
    public void testttt() {
        System.out.println("这是一个 beforeClass");
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println("test1");
        Thread.sleep(5000);
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("test2");
        Thread.sleep(5000);
    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println("test3");
        Thread.sleep(5000);
    }

    @Test
    public void test4() throws InterruptedException {
        System.out.println("test4");
        Thread.sleep(5000);
    }
}
