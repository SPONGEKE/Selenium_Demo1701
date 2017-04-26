package huifang.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by kk on 2017/4/12.
 */
public class WindowSelectTest {
    WebDriver driver;
    @BeforeMethod
    public  void  openChrome(){
        //System.setProperty("webdriver,chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
        driver = new ChromeDriver();
        //driver.get("http://www.baidu.com");
    }
    @Test
    public void windowSelect() throws InterruptedException {
        driver.get("C:\\自动化\\selenium_html\\selenium_html\\index.html");
        Thread.sleep(3000);
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        String handle1=driver.getWindowHandle();
        for(String handles:driver.getWindowHandles()){
            if(handles.equals(handle1))
                continue;
                driver.switchTo().window(handles);
            }

        driver.findElement(By.linkText("baidu")).click();
    }
    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
