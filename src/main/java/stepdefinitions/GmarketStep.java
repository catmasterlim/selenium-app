package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GmarketStep {

    private WebDriver driver;

    @Before
    public void before() {


    }
    @After
    public void after(){
        driver.close();
    }

    @Given("Gmarket 로그인 {string} {string}")
    public void gmarket로그인(String _id, String _pass) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt=new ChromeOptions();
        opt.setExperimentalOption("debuggerAddress","pms.tbell.kro.kr:9222 ");
        driver = new ChromeDriver(opt);

        driver.get("https://signinssl.gmarket.co.kr/login/login?url=https://www.gmarket.co.kr/");

        By selector_id = By.cssSelector("#id");
        WebDriverWait w = new WebDriverWait(driver, Duration.ofMinutes(2));
        w.until(ExpectedConditions.presenceOfElementLocated(selector_id) );

        driver.findElement(selector_id).sendKeys(_id);

        By selector_pwd = By.cssSelector("#pwd");
        driver.findElement(selector_pwd).sendKeys(_pass);
        driver.findElement(selector_pwd).submit();
    }

    @When("Gmarket 출석체크")
    public void gmarket출석체크() {
        driver.get("http://promotion.gmarket.co.kr/Event/pluszone.asp");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // pluszone
        By selector_start = By.cssSelector("#wrapper > a");
        WebDriverWait w = new WebDriverWait(driver, Duration.ofMinutes(2));
        w.until(ExpectedConditions.presenceOfElementLocated(selector_start) );

        String backgroundImageName = driver.findElement(selector_start).getDomProperty("background-image");
        System.out.println(backgroundImageName);
        driver.findElement(selector_start).click();
    }
}
