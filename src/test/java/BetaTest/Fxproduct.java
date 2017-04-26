package BetaTest;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by kk on 2017/4/11.
 */
public class Fxproduct {
    WebDriver driver;

    @BeforeMethod
    public void login() throws InterruptedException {
        System.setProperty("webdriver,chrom.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
        driver=new ChromeDriver();
        driver.get("http://e.zmyou.org/_beta/zmyou");
        Thread.sleep(2000);
        WebElement loginname=driver.findElement(By.id("user_name"));
        loginname.sendKeys("admin");
        Thread.sleep(3000);
        WebElement loginpassword=driver.findElement(By.id("password"));
        loginpassword.sendKeys("rwy123456");
        WebElement logincode=driver.findElement(By.id("captcha"));
        logincode.sendKeys("000000");
        driver.findElement(By.className("loginbtn")).click();
        Thread.sleep(6000);
    }
    @Test
    public void fenxiaoProduct() throws InterruptedException {
        driver.findElement(By.xpath(".//*[@id='leftmenu']/dd[2]/div")).click();
        Thread.sleep(3000);
        //Select select=new
    }
    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
