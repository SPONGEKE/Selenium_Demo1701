package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

/**
 * Created by kk on 2017/4/16.
 */
public class PhantomjsTest {
    @Test
    public void pjsTest() throws InterruptedException {
        System.setProperty("phantomjs.binary.path","C:\\自动化\\webdriver view\\ThreeDay\\phantomjs.exe");
        WebDriver driver=new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");

        Thread.sleep(3000);
        String title=driver.getTitle();
        System.out.println(title);
        driver.quit();
    }
}
