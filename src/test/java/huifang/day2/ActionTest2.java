package huifang.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by kk on 2017/4/14.
 */
public class ActionTest2 {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver,chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
        driver=new ChromeDriver();
        driver.get("http://www.baidu.com");
    }
    @Test
    public void rightClickTest(){
        WebElement buttonBaidu=driver.findElement(By.id("su"));
        Actions actions=new Actions(driver);
        //右击
        actions.contextClick(buttonBaidu).perform();

    }
    @Test
    public void doubleClickTest() throws InterruptedException {
        WebElement buttonBaidu=driver.findElement(By.id("su"));
        Thread.sleep(3000);
        Actions actions=new Actions(driver);
        actions.doubleClick(buttonBaidu).perform();
    }
    @Test
    //鼠标移动到action按钮
    public void moveTest() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
        WebElement element=driver.findElement(By.xpath(".//*[@id='action']/input"));
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        String hello =driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Assert.assertEquals(hello,"Hello World!");
        ////*[@id="action"]/input
    }
    @Test
    //元素拖拽
    public void testDrop() throws InterruptedException {
        driver.get("C:\\自动化\\selenium_html\\selenium_html\\aa.html");
        WebElement element=driver.findElement(By.xpath("html/body/div[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(element,500,500).perform();
        Thread.sleep(3000);
    }
    //元素从一个顶峰
    @Test
    public void dropTest() throws InterruptedException {
        driver.get("C:\\自动化\\selenium_html\\selenium_html\\dragAndDrop.html");
        WebElement el1=driver.findElement(By.id("drag"));
        WebElement el2=driver.findElement(By.xpath("html/body/h1"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(el1).moveToElement(el2).release(el1).perform();
        Thread.sleep(3000);
    }
    @Test
    public void moreSelectTest() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
        WebElement element=driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement>list=driver.findElements(By.xpath(".//*[@id='selectWithMultipleEqualsMultiple']/option"));
        Thread.sleep(3000);
          Actions actions=new Actions(driver);
          //多选框选中1-3
          //actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();
          //多选框只选中1和3
        actions.keyDown(Keys.CONTROL).click(list.get(2)).keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);
    }

    @Test
    //在百度页面保存页面ctrl+s键
    public void robotTest() throws AWTException, InterruptedException {
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        int keyS=(int)new Character('a');
        System.out.println(keyS);
        robot.keyPress(keyS);
        //robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        //点击保存
        robot.keyPress(KeyEvent.VK_ENTER);
        //释放按钮
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
    }
    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\沙漠.jpg");
        Thread.sleep(5000);
    }
    @AfterMethod
    public void closeChrome() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
