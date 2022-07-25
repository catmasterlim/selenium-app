package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;;import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.function.Function;


public class TestWebDriver {

    /**
     * chrome 바로가기 생성 후 디버그 모드로 실행
     * "C:\Program Files\Google\Chrome\Application\chrome.exe" --remote-debugging-port=9222 --user-data-dir=C:\Works\selenum\ChromeProfile
     */

    @Test
    public void test()
    {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://mvnrepository.com/artifact/com.codeborne/selenide/6.6.6");
        WebElement element = driver.findElement(By.cssSelector("#gradle-short-li > a"));
        element.click();
    }

    @Test
    public void existBrowerAttachTest()
    {
        WebDriverManager.chromedriver().setup();

        ChromeOptions opt=new ChromeOptions();
        opt.setExperimentalOption("debuggerAddress","localhost:9222 ");
        ChromeDriver driver = new ChromeDriver(opt);

        if( driver.getCurrentUrl().matches("http://tbell[.]co[.]kr/?")  == false ) {
            driver.get("http://tbell.co.kr/");
        }
        By by = By.cssSelector("a#slider-9-slide-12-layer-3.rs-layer.rev-btn");
        WebDriverWait w = new WebDriverWait(driver, Duration.ofMinutes(5));
        w.until(ExpectedConditions.presenceOfElementLocated(by) );
        WebElement element = driver.findElement(by);
        element.click();
    }

    @Test
    public void paramterTest() throws Throwable {
        WebDriverManager.chromedriver().setup();

        ChromeOptions opt=new ChromeOptions();
        opt.setExperimentalOption("debuggerAddress","localhost:9222 ");
        ChromeDriver driver = new ChromeDriver(opt);

        driver.manage().window().maximize();


        String url=driver.getCurrentUrl();
        URL aURL = new URL(url);
        System.out.println("url = " + url);
        System.out.println("protocol = " + aURL.getProtocol());
        System.out.println("authority = " + aURL.getAuthority());
        System.out.println("host = " + aURL.getHost());
        System.out.println("port = " + aURL.getPort());
        System.out.println("path = " + aURL.getPath());
        System.out.println("query = " + aURL.getQuery());
        System.out.println("filename = " + aURL.getFile());
        System.out.println("ref = " + aURL.getRef());

    }
}
