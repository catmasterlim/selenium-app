package com.selenium.test.junit.tests;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.webtestsbase.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sidelnikov Mikhail on 19.09.14.
 * Uses JUnit test framework
 * Test demonstrates simple webdriver functions : how to start browser, open url, insert some text and check that this text was inserted
 */
public class SimpleTest {

    private WebDriver driver;

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }


    @Test
    public void testFillGoogleForm() {
        String toSearch = "Selenium";
        driver.get("https://dev-hive.ota.hmckmc.co.kr/web/v1/ota/hive/event/list");
        WebElement usernameTxt = driver.findElement(By.id("username"));
        usernameTxt.sendKeys(toSearch);

        WebElement passwordTxt = driver.findElement(By.id("password"));
    }


    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
