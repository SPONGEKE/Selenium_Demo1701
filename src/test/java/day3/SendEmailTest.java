package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by kk on 2017/4/18.
 */
public class SendEmailTest {
    WebDriver driver;

//    @BeforeMethod
    public void openChrome() {
        //String path = System.getProperty("user.dir");
        //System.setProperty("webdriver.chrome.driver",path+"//drivers//chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","C:\\自动化\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        //全局等待      会造成不必要的等待效率低，故考虑显示等待会提升效率
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.163.com/");
    }
    @Test
    public void sendEmail() throws InterruptedException {
        //调用LoginTest.java里面的login方法，登陆
        LoginTest.login(driver,"15606094243","qaz123");
        //点击写信按钮
        driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        //定位收件人和输入收件人名
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("644088559@qq.com");
        //定位主题和输入主题
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("这个是个主题aaa");
        //上传文件（图片）
        driver.findElement(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("C:\\Users\\kk\\Desktop\\Q17.png");
        //定位iframe
        Thread.sleep(5000);
        WebElement frame=driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("/html/body")).sendKeys("内容啊内容gerg");
        //driver控制权转交回页面
        driver.switchTo().defaultContent();
        //点击发送按钮jp0
       driver.findElement(By.xpath(".//*[@class='jp0']/div[1]/span[2]")).click();
       //String  text=driver.findElement(By.className("tK1")).getText();
        Boolean bl=driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(bl);
    }


    @Test
    public void aaa(){

    }
    @AfterMethod
    public void closeChrome(){
//        driver.quit();
    }
}



