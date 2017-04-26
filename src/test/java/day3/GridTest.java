package day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kk on 2017/4/20.
 */
public class GridTest {
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        //创建一个 DesiredCapabilities类型
        DesiredCapabilities dc =DesiredCapabilities.chrome();
        //实例化一个driver
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.178.128:4445/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }
    @DataProvider(name="data1")
    public Object[][] test1(){
        return  new Object[][]{
                {"firefox","http://192.168.178.128:6666"},
                {"chrome","http://192.168.178.128:5555"}};
        }
        @Test(dataProvider="data1")
    public void testGrid2(String browser,String url) throws MalformedURLException, InterruptedException {
            DesiredCapabilities dc=null;
            if(browser.contentEquals("firefox")){
                dc=DesiredCapabilities.firefox();
        }else if(browser.equals("chrome")){
                dc=DesiredCapabilities.chrome();
            }else {
            System.out.println("error");
            }
            WebDriver driver=new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
            driver.get("http://www.baidu.com");
            Thread.sleep(5000);
            driver.quit();


    }

}
