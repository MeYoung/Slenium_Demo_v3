package com.selenium.datadriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by 米阳 on 6/10/2017.
 */
public class DataProviderTest {

    //在@DataProvider注解中为数据源命名 testData
    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"name", 1},
                {"test1", "test2"},
                {"test3", "test4"}
        };
    }

/*    //在@Test注解中指定dataProvider参数并设置获取数据的来源 testData
    @Test(dataProvider = "data")
    public void dataDriverTest(String name, String passwork) {
        System.out.println("使用账号:" + name + "_和密码：" + passwork + " 登录!");
    }*/

    //在@DataProvider注解中为数据源命名 testData
    @DataProvider(name = "data1",parallel = true)
    public Object[][] data2() {
        return new String[][]{
                {"name", "gsfdg", "fadsf"},{"a","v","c"}
        };
    }

    //在@Test注解中指定dataProvider参数并设置获取数据的来源 testData
    @Test(dataProvider = "data1")
    public void dataDriverTest(String name, String i, String b) throws InterruptedException {
        System.out.println(name + i + b);
        Thread.sleep(5000);
    }


/*    //获取 com.seleium.datadriver包下的Data类中的名为 dataTest的数据源
    @Test(dataProvider = "dataTest", dataProviderClass = com.selenium.datadriver.Data.class)
    public void dataDriverTest2(int a) {
        System.out.println(a);
    }*/
}
