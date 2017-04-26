package day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by kk on 2017/4/16.
 */
public class JSTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.Chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void exJS() throws InterruptedException {
        driver.get("http://www.baidu.com");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        //在百度栏输入webdriver
        //js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\")");
        //
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"maxlength\",\"13232\")");
        Thread.sleep(3000);
    }
    @AfterTest
    public void closedChrome() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
