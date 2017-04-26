package com.huifang.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kk on 2017/3/30.
 */
public class TestNGDemo3 {
    @Test
    public void assertEqualTest(){
        String a="abse";
        String b="abd";
        System.out.println("登陆");
        Assert.assertEquals(a,b,"校验登陆成功");
        Assert.assertEquals(a,b,"用户名是否OK");
        System.out.println("操作打开页面删除");
        Assert.assertEquals(a,b,"删除成功");
    }
    @Test
    public void assertNotEqualTest(){
        int a=2;
        int b=1;
        Assert.assertNotEquals(a,b);
    }
//    @Test
//    public void assertNullTest(){
//        String a=null;
//        Assert.assertNull(a);
//    }
    @Test
    public void assertNullTest() {
    String  a="";
    Assert.assertNull(a);
    }
    @Test
    public void assertNortNulTest(){
        String a=null;
        Assert.assertNotNull(a);
}
    @Test
    public void a(){
        Boolean a=false;
        Assert.assertTrue(a);
    }
}
