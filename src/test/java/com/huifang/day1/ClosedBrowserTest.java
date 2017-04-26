package com.huifang.day1;

import org.junit.experimental.theories.Theories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by kk on 2017/4/1.
 */
public class ClosedBrowserTest {
    @Test
    public void closedChrome1() throws InterruptedException {
     System.setProperty("webdriver.chrome.driver","C:\\自动化\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        //等待5s
        Thread.sleep(5000);
        //关闭当前窗口
        driver.close();
    }
    @Test
    public void closedChromle2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\自动化\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(5000);
        //关闭浏览器完全退出浏览器
        driver.quit();
    }

}
