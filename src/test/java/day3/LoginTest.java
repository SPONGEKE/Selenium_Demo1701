package day3;

import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by kk on 2017/4/17.
 */
public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\自动化\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        //全局等待    会造成不必要的等待效率低，故考虑显示等待
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.163.com/");
    }
    @DataProvider(name="userlist")
    public Object[][] test1(){
        return  new Object[][]{
                {"uwer","13456"},
                {"uwwo","46285"}};
    }
    @Test(dataProvider="userlist")
    public void loginSucess(String username,String pwd){
//        driver.switchTo().frame(("x-URS-iframe"));
//        driver.findElement(By.name("email")).sendKeys("15606094243");
//        driver.findElement(By.name("password")).sendKeys("qaz123");
//        driver.findElement(By.id("dologin")).click();
        LoginTest.login(driver,username,pwd);
        //显示等待
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String text=driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(text,"退出");
    }
    @Test
    public void loginFailed() {
//        driver.switchTo().frame(("x-URS-iframe"));
//        driver.findElement(By.name("email")).sendKeys("15606094243");
//        driver.findElement(By.name("password")).sendKeys("qaz12r");
//        driver.findElement(By.id("dologin")).click();
        LoginTest.login(driver,"15606094243","qa23");
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        String text = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(text, "帐号或密码错误");
    }


    @Test
    public void loginFailed2() {
//        driver.switchTo().frame(("x-URS-iframe"));
//        driver.findElement(By.name("email")).sendKeys("15606094243");
//        driver.findElement(By.name("password")).sendKeys("qaz12r");
//        driver.findElement(By.id("dologin")).click();
        LoginTest.login(driver,"15606094243","qa23");
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        String text = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(text, "帐号或密码错误");
    }
    @Test
        public static  void login(WebDriver driver,String email,String pwd){
        //driver 控制权转交
            driver.switchTo().frame("x-URS-iframe");
            driver.findElement(By.name("email")).sendKeys(email);
            driver.findElement(By.name("password")).sendKeys(pwd);
            //driver.findElement(By.id("")).sendKeys(s);
            driver.findElement(By.id("dologin")).click();
        }
        //调用LoginPage类，在多个case需要更改元素情况下可以减少代码修改成本和提升效率
    @Test
        public static void loginPo1(WebDriver driver,String email,String pwd){
            //driver 控制权转交
            driver.switchTo().frame("x-URS-iframe");
            driver.findElement(LoginPage.emailInput).sendKeys(email);
            driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
            //driver.findElement(By.id("")).sendKeys(s);
            driver.findElement(LoginPage.loginButton).click();
        }

    @Test
    public static void loginPo2(WebDriver driver,String email,String pwd){
        //driver 控制权转交
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        //driver.findElement(By.id("")).sendKeys(s);
        driver.findElement(LoginPage.loginButton).click();
    }
    @AfterMethod
    public void closeChrome(){
        driver.quit();
       }
}
