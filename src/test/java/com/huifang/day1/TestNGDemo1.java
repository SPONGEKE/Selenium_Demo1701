package com.huifang.day1;

import org.testng.annotations.*;

/**
 * Created by kk on 2017/3/29.
 */
public class TestNGDemo1 {
    @BeforeTest
    public void  beforeTest01(){
        System.out.println("这是@BeforeTest注解");
    }
    @BeforeMethod
    public void  beforeMethod01(){
        System.out.println("这是@BeforeMethod01注解");
    }


    @Test
    public void testCase2(){
        System.out.println("这是@Test注解,case2");
    }

    @Test
    public void testCase1(){
        System.out.println("这是@Test注解,case1");
    }

    @Test
    public void atestCase3(){
        System.out.println("这是@Test注解,acase3");
    }


    @AfterTest
    public void afterTest01(){
        System.out.println("这是@afterTest01注解");
    }
    @AfterMethod
    public void afterMethod01(){
        System.out.println("这是@afterMethod注解");
    }

}
