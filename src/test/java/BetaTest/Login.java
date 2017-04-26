package BetaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by kk on 2017/4/11.
 */
public class Login {
    WebDriver driver;

  @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\自动化\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://e.zmyou.org/_beta/zmyou");
    }

    @Test
    public void loginName(){
        String arrtributename0=driver.findElement(By.id("user_name")).getAttribute("placeholder");
         Assert.assertEquals(arrtributename0,"输入用户名");
    }

    @Test
    public  void loginNameisEnable(){
        Boolean b0=driver.findElement(By.id("user_name")).isEnabled();
        Assert.assertTrue(b0,"校验用户名框为可输入状态");
    }

    @Test
    public  void loginPassword(){
        String arrtributename1=driver.findElement(By.id("password")).getAttribute("placeholder");
        Assert.assertEquals(arrtributename1,"输入密码");
    }

    @Test
    public  void loginPasswordisEnable(){
        Boolean b1=driver.findElement(By.id("password")).isEnabled();
        Assert.assertTrue(b1,"校验密码为可输入状态");
    }

    @Test
    public  void  loginCode(){
        String arrtributename2=driver.findElement(By.id("captcha")).getAttribute("placeholder");
        Assert.assertEquals(arrtributename2,"输入验证");
    }

    @Test
    public void loginCodeshowMove(){
        WebElement element=driver.findElement(By.id("getcode_num"));
        Actions builder=new Actions(driver);
        builder.moveToElement(element).perform();
    }
//    @Test
//    public void loginCodeshowMoveGet(){
//        WebElement element=driver.findElement(By.id("getcode_num")).getAttribute("");
//    }
        @Test
        public void loginInputUsername() throws InterruptedException {
        WebElement loginname=driver.findElement(By.id("user_name"));
        loginname.sendKeys("admin");
        Thread.sleep(3000);
        WebElement loginpassword=driver.findElement(By.className("loginpwd"));
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

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
