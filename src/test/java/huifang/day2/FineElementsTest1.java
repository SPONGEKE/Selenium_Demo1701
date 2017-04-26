package huifang.day2;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by kk on 2017/4/8.
 */
public class FineElementsTest1 {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
    System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application.chrome.exe");
    driver = new ChromeDriver();
    driver.get("http://www.baidu.com");
    }

    @Test
   public void clickTest() throws InterruptedException {
    Thread.sleep(5000);
    WebElement newslink=driver.findElement(By.name("tj_trnews"));
    newslink.click();
    String url=driver.getCurrentUrl();
    Assert.assertEquals(url,"http://news.baidu.com/");
    }

    @Test
    public void sendKeysTest() throws InterruptedException {
        //定位百度搜索栏
        WebElement element=driver.findElement(By.id("kw"));
        //搜索栏输入selenium
        element.sendKeys("selenium");
        //定位搜索按钮
        WebElement baiduButton=driver.findElement(By.id("su"));
        //点击搜索按钮
        baiduButton.click();
        Thread.sleep(5000);
        //获得页面title
        String  title=driver.getTitle();
        //校验当前页面是否为  selenium_百度搜索
        Assert.assertEquals(title,"selenium_百度搜索");
        Thread.sleep(3000);
    }
    @Test
    public void clearTest() throws InterruptedException {
        WebElement element=driver.findElement(By.id("kw"));
        element.sendKeys("selenium");
        Thread.sleep(5000);
        element.clear();
    }
    @Test
    public void getTextTest(){
        List<WebElement>listText=driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for(int i=0;i<listText.size();i++){
            String text=listText.get(i).getText();
            System.out.println(text);
        }
    }
   //@Test
    //getText()获取是标签的中间值
//    public void getTextTest1(){
//        WebElement element=driver.findElement(By.id("kw"));
//        element.sendKeys("selenium");
//        String text1=element.getText();
//        element.clear();
//        String text2=element.getText();
//        Assert.assertEquals(text1,"selenium");
//        Assert.assertEquals(text2,"");
//    }

    @Test
    public void getTextTest1() {
        String tex1=driver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(tex1,"新闻");
    }
    @Test
    public void getTagNameTest(){
       String tagName=driver.findElement(By.id("kw")).getTagName();
//       if(tagName.equals("input")) {
//           System.out.println("OK");
//       }else {
//           System.out.println("error");
//       }
        Assert.assertEquals(tagName,"input111");
    }

    @Test
    public void getAttributeTest() throws InterruptedException {
        WebElement element=driver.findElement(By.id("kw"));
        element.sendKeys("webdriver");
        Thread.sleep(3000);
        String att=element.getAttribute("value");
        System.out.println(att);
    }
    //判断百度按钮的文本
    @Test
    public  void getAttributeTest1(){
        String attributeValue=driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attributeValue,"百度一下");
    }
    @Test
    public  void getTitleTest(){
        String title=driver.getTitle();
        Assert.assertEquals(title,"百度一下，你就知道");
    }

    @Test
    public void isDisplayedTest(){
        Boolean bb=driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(bb,"校验百度一下按钮是否显示");
    }

    @Test
    public void iaSelectedTest() throws InterruptedException {
        driver.get("C:\\自动化\\selenium_html\\selenium_html\\demo1.html");
        Thread.sleep(3000);
        //driver.findElement(By.xpath(".//*[@id='radio']/input[1]")).click();
        //以上备注释可以写成如下
        WebElement element=driver.findElement(By.xpath(".//*[@id='radio']/input[1]"));
        element.click();
        Boolean b=element.isSelected();
        Assert.assertTrue(b);
        //Boolean aa=driver.findElement(By.xpath(".//*[@id='radio']/input[1]")).isSelected();
        //Assert.assertTrue(aa,"校验单选框已选中");
    }

    @Test
    public void isEnabledTest() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
        Thread.sleep(3000);
        Boolean cc=driver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(cc,"校验输入框为不可输入状态");
    }
//截百度首页图
    @Test
    public void screenShotFile() {
//        File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try{
//            FileUtils.copyFile(screenShotFile(),new File("C://test.png"));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("C:\\test.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public  void alertTest() throws InterruptedException {
        driver.get("C:\\自动化\\selenium_html\\selenium_html\\demo1.html");
        Thread.sleep(300);
        driver.findElement(By.xpath(".//*[@id='alert']/input")).click();
        //Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public  void confirmTest() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
        driver.findElement(By.xpath(".//*[@id='confirm']/input")).click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        String textcontxt=alert.getText();
        System.out.println(textcontxt);
        //alert.accept();
        alert.dismiss();
        Assert.assertEquals(textcontxt,"我是提示信息");
    }

    @Test
    public void prompTest() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
        driver.findElement(By.xpath(".//*[@id='prompt']/input")).click();
        Alert prompt=driver.switchTo().alert();
        prompt.sendKeys("这是prompt");
        Thread.sleep(6000);
        prompt.accept();
    }

    @Test
    //通过id 转交控制权
    public void iframeTest() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
        driver.switchTo().frame("aa");
        Thread.sleep(5000);
        driver.findElement(By.id("user")).sendKeys("我在iframe里面的元素输入了11");
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
    }
    @Test
    //通过name 转交控制权
    public void iframeTest1() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
       WebElement iframe=driver.findElement(By.tagName("iframe"));
       driver.switchTo().frame(iframe);
       driver.findElement(By.linkText("baidu")).click();
       Thread.sleep(3000);
       driver.switchTo().defaultContent();
       driver.findElement(By.linkText("登陆界面")).click();
    }
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
        WebElement select1 = driver.findElement(By.id("moreSelect"));
        Select select=new Select(select1);
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByValue("vivo");
        Thread.sleep(3000);
        select.selectByVisibleText("iphone");
        Thread.sleep(3000);
    }
//        @Test
//        public void winTest(){
//            driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
//            driver.findElement(By.xpath(".//*[@id='open']/a")).click();
//            String handle=driver.getWindowHandle();
//
//        }

    //????
    @Test
    public void mouseliftTest() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
        WebElement element=driver.findElement(By.xpath(".//*[@id='load']"));
        Thread.sleep(5000);
        Actions action=new Actions(driver);
        action.moveToElement(element);
        action.click().perform();
    }
    @Test
    public void testContextClick() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
        WebElement element=driver.findElement(By.xpath(".//*[@id='load']"));
        Actions action=new Actions(driver);
        //右击
        action.contextClick(element).perform();
        //双击
       // action.doubleClick(element).perform();
        Thread.sleep(5000);
    }

    @Test
    public  void testMoveToElement() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
        WebElement element=driver.findElement(By.xpath(".//*[@id='action']/input"));
        Actions action=new Actions(driver);
        action.moveToElement(element).perform();
        Thread.sleep(5000);
    }
    @Test
    public  void testDragAndDropBy() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/aa.html");
        WebElement drag=driver.findElement(By.xpath("html/body/div[1]"));
        Thread.sleep(5000);
        Actions  action=new Actions(driver);
        action.dragAndDropBy(drag,900,900);
        Thread.sleep(5000);
    }
    //把一个元素拖动到另一个元素上


//    @Test
//    public  void selectmoreTest() throws InterruptedException {
//        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
//        WebElement element=driver.findElement(By.xpath(".//*[@id='load']"));
//        Select select=new Select(element);
//        select.selectByIndex(2);
//        Thread.sleep(3000);
//  }
    @Test
    public void  winTest() throws InterruptedException {
        driver.get("file:///C:/%E8%87%AA%E5%8A%A8%E5%8C%96/selenium_html/selenium_html/index.html");
        driver.findElement(By.xpath(".//*[@id='open']/a")).click();
        String handle = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }
        Thread.sleep(3000);
        driver.findElement(By.id("user")).sendKeys("test1");
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(handle);
        Thread.sleep(3000);
        driver.findElement(By.id("user")).sendKeys("test2");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void closeChrome() {
        driver.quit();
    }
}

