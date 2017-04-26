package com.huifang.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kk on 2017/3/29.
 */
public class TestNGDemo2 {
    @Test
    public void assertEqualTest(){
        String a="abse";
        String b="abse";
//        if(a.equals (b)){
//            System.out.println("正确");
//        }else
//        {
//            System.out.println("错误");
//        }
        System.out.println("================");
       Assert.assertEquals(a,b,"a不等于b");

        //Assert.assertEquals(a,b);

    }
}
