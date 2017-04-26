package com.huifang.day1;

import org.testng.annotations.Test;

/**
 * Created by kk on 2017/3/29.
 */
public class BT {

    @Test
    public void  BBB1(){
        AT at =new AT();
        at.b();
    }
    @Test
    public void BBB2(){
        AT.a();
    }
}
