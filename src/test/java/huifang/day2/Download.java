package huifang.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by kk on 2017/4/15.
 */
public class Download {
    WebDriver driver;
    @Test
    public void downLoadTest() throws InterruptedException, AWTException {
        System.setProperty("webdriver,firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox.firefox.exe");
        driver=new FirefoxDriver();
        driver.get("http://rj.baidu.com/soft/detail/13478.html?ald");
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='softAbs']/a[2]")).click();
        Thread.sleep(2000);
        //Alert alert=driver.switchTo().alert();
        //alert.();
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
    }
    @AfterTest
    public  void closeFirefox(){
        driver.quit();
    }
}
