package test3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleSearch {

    private WebDriver driver;
    By linkLocator = By.cssSelector("a[href = 'https://www.testim.io/blog/what-is-test-automation/']");

        @Before
        public void setUp() throws Exception {
            System.setProperty("webdriver.opera.driver", "./src/test/resources/operaDriver/operaDriver.exe");
            driver = new OperaDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com");
        }

        @Test
        public void testGooglePage(){

            WebElement searchBox = driver.findElement(By.name("q"));

            searchBox.clear();

            searchBox.sendKeys("software test automation");

            searchBox.submit();

            // Implicit Wait
            // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Explicit wait
            //WebDriverWait  ewait = new WebDriverWait(driver,10);
            //ewait.until(ExpectedConditions.titleContains("test automation"));

            // FluentWait
            Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                    .withTimeout(10,TimeUnit.SECONDS)
                    .pollingEvery(2,TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            WebElement link =fwait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver){
                    return driver.findElement(linkLocator);
                }
            }
            );

            assertTrue(driver.findElement(linkLocator).isDisplayed());

        }

        @After
        public void tearDown(){
            driver.quit();
        }






}
