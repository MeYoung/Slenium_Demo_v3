package com.selenium.parallel;

import org.testng.annotations.Test;

/**
 * Created by vidorh on 6/10/2017.
 */
public class ParallelTest1 {
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
