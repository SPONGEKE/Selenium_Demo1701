package BetaTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by kk on 2017/4/11.
 */
public class Login0 {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver,chrom.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
        driver=new ChromeDriver();
        driver.get("http://e.zmyou.org/_beta/zmyou");
    }

    @Test
    public void loginName(){
        String arrtributename0=driver.findElement(By.id("user_name")).getAttribute("placeholder");
        Assert.assertEquals(arrtributename0,"输入用户名");
        Boolean b0=driver.findElement(By.id("user_name")).isEnabled();
        Assert.assertTrue(b0,"校验用户名框为可输入状态");
        String arrtributename1=driver.findElement(By.id("password")).getAttribute("placeholder");
        Assert.assertEquals(arrtributename1,"输入密码");
        Boolean b1=driver.findElement(By.id("password")).isEnabled();
        Assert.assertTrue(b1,"校验密码为可输入状态");
        String arrtributename2=driver.findElement(By.id("captcha")).getAttribute("placeholder");
        Assert.assertEquals(arrtributename2,"输入验证");
        WebElement element=driver.findElement(By.id("getcode_num"));

        Actions builder=new Actions(driver);
        builder.moveToElement(element).perform();
    }

    //    @Test
//    public void loginCodeshowMoveGet(){
//        WebElement element=driver.findElement(By.id("getcode_num")).getAttribute("");
//    }
    @Test
    //输入正确用户名密码验证码正常登陆
    public void loginInputUsername1() throws InterruptedException {
        WebElement loginname=driver.findElement(By.id("user_name"));
        loginname.sendKeys("admin");
        Thread.sleep(3000);
        WebElement loginpassword=driver.findElement(By.id("password"));
        loginpassword.sendKeys("rwy123456");
        WebElement logincode=driver.findElement(By.id("captcha"));
        logincode.sendKeys("000000");
        driver.findElement(By.className("loginbtn")).click();
        Thread.sleep(6000);
        String url=driver.getCurrentUrl();
        System.out.println(url);
        // Assert.assertTrue(Boolean.parseBoolean(url),"http://e.zmyou.org/_beta/zmyou/index.php");
        Assert.assertEquals(url,"http://e.zmyou.org/_beta/zmyou/index.php");
    }
    @Test
    //输入错误用户名点击登陆
    public void loginInputerroUsername2() throws InterruptedException {
        WebElement loginnamen0=driver.findElement(By.id("user_name"));
        loginnamen0.sendKeys("wei");
        driver.findElement(By.className("loginbtn")).click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        String text1=alert.getText();
        Thread.sleep(2000);
        Assert.assertEquals(text1,"请输入密码");
//        alert.accept();
//        loginnamen0.sendKeys("admin");
//        driver.findElement(By.className("loginbtn")).click();
//        Alert alert1=driver.switchTo().alert();
        }
        @Test
        //输入错误用户名密码点击登陆
        public void loginInputerrorUsername3() throws InterruptedException {
            WebElement loginnamen0=driver.findElement(By.id("user_name"));
            loginnamen0.sendKeys("fsd");
            WebElement loginpassword=driver.findElement(By.id("password"));
            loginpassword.sendKeys("afff");
            driver.findElement(By.className("loginbtn")).click();
            Thread.sleep(3000);
            String handle1=driver.getWindowHandle();
            for (String handles : driver.getWindowHandles()) {
                if (handles.equals(handle1))
                    Thread.sleep(5000);
            }
            //Alert alert=driver.switchTo().alert();
            //String text2=alert.getText();
            //Thread.sleep(3000);
            //Assert.assertEquals(text2,"验证码输入错误,请重新输入");
        }

    @Test
    //输入错误用户名、密码、正确验证码点击登陆
    public void loginInputerrorUsername4() throws InterruptedException {
        WebElement loginnamen0=driver.findElement(By.id("user_name"));
        loginnamen0.sendKeys("adje");
        WebElement loginpassword=driver.findElement(By.id("password"));
        loginpassword.sendKeys("agg");
        WebElement logincode=driver.findElement(By.id("captcha"));
        logincode.sendKeys("000000");
        driver.findElement(By.className("loginbtn")).click();
        Thread.sleep(3000);
        Alert alert1=driver.switchTo().alert();
        String text3=alert1.getText();
        Assert.assertEquals(text3,"账号密码错误");
    }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}

