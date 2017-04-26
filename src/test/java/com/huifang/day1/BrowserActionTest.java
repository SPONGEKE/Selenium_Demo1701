package com.huifang.day1;

import com.sun.imageio.plugins.wbmp.WBMPImageReader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kk on 2017/4/1.
 */
public class BrowserActionTest {
    WebDriver driver;
    @BeforeTest
    public void OpenBrowsersTest() {
        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void getTest() throws InterruptedException {
//        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
//        driver=new ChromeDriver();
        //打开百度网页
        //driver.get("http://www.baidu.com");
        driver.navigate().to("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void backTest() throws InterruptedException {
//        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
//        driver=new ChromeDriver();
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void forwardTest() throws InterruptedException {
//        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
//        driver=new ChromeDriver();
        driver.navigate().to("http://www.baidu.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void refreshTest() throws InterruptedException {
//        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
//        driver=new ChromeDriver();
        driver.get("http://www.baidu.com");
        Thread.sleep(300);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void windTest() throws InterruptedException {
//        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
//        driver=new ChromeDriver();
        driver.get("http://www.baidu.com");
        //设置窗口大小
        Dimension dimension=new Dimension(300,300);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        //窗口最大化
        driver.manage().window().maximize();
        //driver.navigate().to("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void getUrlTest(){
//        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
//        driver=new ChromeDriver();
        driver.get("http://www.baidu.com");
        //获得url,校验当前页面URL是不是百度页面
        String url=driver.getCurrentUrl();
        System.out.println("获取到的URL："+ url);
        Assert.assertEquals(url,"https://www.baidu.com/");
        //driver.quit();
    }
    @Test
    public void getTitleTest(){
        driver.get("http://www.baidu.com");
        //获得当前页面title
        String title=driver.getTitle();
        System.out.println("当前页面："+ title);
    }

        @AfterMethod
        public void closedBrowser(){
        driver.quit();
        }
}
