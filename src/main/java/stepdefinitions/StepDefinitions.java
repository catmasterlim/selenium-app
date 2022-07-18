package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    private WebDriver driver;

    @Before
    public void beforeTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Then("입력한 값이 리스트 최상단에 노출")
    public void testFillGoogleForm(String username) {
        driver.get("https://stg-hive.ota.hmckmc.co.kr/web/v1/ota/hive/Vehicle/internal");
        WebElement usernameTxt = driver.findElement(By.id("username"));
        usernameTxt.sendKeys(username);

        WebElement passwordTxt = driver.findElement(By.id("password"));
    }

    @Given("로그인")
    public void 로그인() throws InterruptedException {
        driver.get("https://stg-hive.ota.hmckmc.co.kr/web/v1/ota/hive/signin");


        WebElement usernameTxt = driver.findElement(By.id("username"));
        usernameTxt.sendKeys("hivetest");

        WebElement passwordTxt = driver.findElement(By.id("password"));
        passwordTxt.sendKeys("devOta!23");
        TimeUnit.SECONDS.sleep(5);
        WebElement loginbutton = driver.findElement(By.className("login-form-button"));
        loginbutton.click();
    }

    @When("좌측 메뉴의 차량관리 선택")
    public void 좌측메뉴의차량관리선택() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        WebElement button = driver.findElement(By.xpath("//span[text()='차량관리']"));
        button.click();
    }

    @When("내부 용도차 관리 선택")
    public void 내부용도차관리선택() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        WebElement car_button = driver.findElement(By.xpath("//li[text()=' 내부용도차 관리 ']"));
        car_button.click();
    }

    @When("신규등록 선택")
    public void 신규등록선택() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        WebElement registration = driver.findElement(By.xpath("//*[@id=\"layout\"]/section/main/div/div/div[2]/button[1]"));
        registration.click();
    }

    @When("임의 차량목적 드롭박스 선택")
    public void 임의차량목적드롭박스선택() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        WebElement dropdown = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div/div/div"));
        dropdown.click();

        WebElement option = driver.findElement(By.xpath("//li[text()=' 시승차 ']"));
        option.click();
    }

    @When("VIN 번호 입력")
    public void vin번호입력() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        WebElement VIN = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/input"));
        VIN.sendKeys("TESTVIN1234567890");
    }

    @When("확인 버튼 선택")
    public void 확인버튼선택() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        WebElement confirm = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/div/button[2]"));
        confirm.click();
    }

    @When("체크 박스 선택")
    public void 체크박스선택() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"layout\"]/section/main/div/div/div[3]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/span/label/span/input"));
        checkbox.click();
    }

    @When("수정 버튼 클릭")
    public void 수정버튼클릭() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        WebElement modify = driver.findElement(By.xpath("//*[@id=\"layout\"]/section/main/div/div/div[4]/button"));
        modify.click();
    }

    @When("삭제 버튼 클릭")
    public void 삭제버튼클릭() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        WebElement delete = driver.findElement(By.xpath("//*[@id=\"layout\"]/section/main/div/div/div[4]/button[2]"));
        delete.click();
    }

    @When("alert창 확인 버튼 클릭")
    public void alert창확인버튼클릭() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(5);
//        if(ExpectedConditions.alertIsPresent().apply(driver)!=null){
//            driver.switchTo().alert().accept();
//        }
    }

    @Then("삭제되었는지 확인")
    public void 삭제되었는지확인() {

    }
}
