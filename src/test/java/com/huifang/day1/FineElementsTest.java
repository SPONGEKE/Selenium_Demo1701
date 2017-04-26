package com.huifang.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by kk on 2017/4/2.
 */
public class FineElementsTest {
    WebDriver driver;
    @BeforeMethod
   public void openChrome(){
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
   driver=new ChromeDriver();
    }

    @Test
    public void byIDTest(){
       driver.get("http://www.baidu.com");
       WebElement keyFile=driver.findElement(By.id("kw"));
    }
    @Test
    public void byNameTest(){
        driver.get("http://www.baidu.com");
        WebElement keyFile=driver.findElement(By.name("wd"));
    }
    @Test
    public void byClassNameTest(){
        driver.get("http://www.baidu.com");
        WebElement keyFile=driver.findElement(By.className("bg s_btn"));
    }

    //通过partialLinkText定位搜索文本框
    @Test
    public void byLinkTextTest(){
        driver.get("http://www.baidu.com");
        WebElement keyFile=driver.findElement(By.linkText("糯米"));
        System.out.println("文本="+ keyFile);
    }
    @Test
    public void byTagName(){
        driver.get("http://www.baidu.com");
        List<WebElement>list=driver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }
    @Test
    public void byXpath() throws InterruptedException {
//        System.setProperty("webdriver,firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox.firefox.exe");
//        driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
         Thread.sleep(3000);
        WebElement e1=driver.findElement(By.xpath(".//*[@id='su']"));
    }
    @Test
    public void byCss(){
        driver.get("http://www.baidu.com");
        WebElement e1=driver.findElement(By.cssSelector("#lg > img"));
    }

    @Test
    public void byAllXpath(){
        driver.get("http://www.baidu.com");
        List<WebElement>list=driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (int i=0;i<list.size();i++) {
            String text = list.get(i).getText();
            System.out.println(text);
        }
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
