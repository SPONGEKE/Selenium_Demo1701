package huifang.day2;

import org.apache.xpath.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by kk on 2017/4/13.
 */
public class WaitTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver,chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
        driver = new ChromeDriver();
        //driver.get("http://www.baidu.com");
        //全局等待   10为超时时间，单位为后面的秒
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void waitTest1() throws InterruptedException {
        driver.get("C:\\自动化\\selenium_html\\selenium_html\\index.html");
        driver.findElement(By.xpath(".//*[@id='wait']/input")).click();
        //Thread.sleep(5000);
        java.lang.String text=driver.findElement(By.xpath(".//*[@id='display']/div")).getText();
        Assert.assertEquals(text,"wait for display");
    }

    @Test
    public void waitTest2() throws InterruptedException {
        driver.get("C:\\自动化\\selenium_html\\selenium_html\\index.html");
        driver.findElement(By.xpath(".//*[@id='wait']/input")).click();
        //显示等待
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='display']/div")));
        //Thread.sleep(5000);
        java.lang.String text = driver.findElement(By.xpath(".//*[@id='display']/div")).getText();
        Assert.assertEquals(text, "wait for display");
    }
    @AfterMethod
    public void closeChrome() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
