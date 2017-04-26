package com.huifang.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

/**
 * Created by kk on 2017/3/30.
 */
//firefox 48之前不用下driver，48之后要下相应的driver
public class OpenBrowserTest {
    @Test
    public void openFirefox(){

        WebDriver webdriver=new FirefoxDriver();
    }
    @Test
    public  void openFirefox1() {
        System.setProperty("webdriver,firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox.firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }
    @Test
    public void openChrome(){
        System.setProperty("webdriver,chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
        WebDriver webDriver=new ChromeDriver();
    }
   @Test
    public  void openIE(){
        System.setProperty("webdriver,InternetExplorer.bin","C:\\Windows\\System32\\iexplore.exe");
        WebDriver driver=new InternetExplorerDriver();
        driver.get("http://www.baidu.com");

   }

}
