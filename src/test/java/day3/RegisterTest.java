package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by kk on 2017/4/17.
 */
//2 2216
public class RegisterTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
        driver=new ChromeDriver();
        driver.get("http://mail.163.com/");
    }
    @Test
    public void registerTest(){
        //控制权转交给iframe里面
        driver.switchTo().frame("x-URS-iframe");
        //点击注册按钮
        driver.findElement(By.id("changepage")).click();
        //获取当前driver所在的handle值
        String handle1=driver.getWindowHandle();
        //driver 切换到新的windows页面
        for (String handles:driver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;//如果相等 退出循环
            }
            driver.switchTo().window(handles);
        }
        String time= String.valueOf(System.currentTimeMillis()/100);
        driver.findElement(By.id("nameIpt")).sendKeys("mina"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("121214");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("121214");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        driver.findElement(By.id("vcodeIpt")).sendKeys("134141");
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("241412");
        driver.findElement(By.id("mainRegA")).click();
        //显示等待
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='m_mainAcode']/span")));

        String error1=driver.findElement(By.xpath(".//*[@id='m_mainAcode']/span")).getText();
        Assert.assertEquals(error1,"  手机验证码不正确，请重新填写");
    }
    @Test
    public void testcase01(){
        long time=System.currentTimeMillis();
        System.out.println(time);
    }
    @AfterMethod
    public void closedChrome(){
        driver.quit();
    }
}
