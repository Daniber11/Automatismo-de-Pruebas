package test4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Unal {

        private WebDriver driver;

        By servicesLocator = By.xpath("//*[@id=\"services\"]/div");
        By institutionalLocator = By.xpath("//*[@id=\"services\"]/ul/li[1]");
        By accessGoogleLocator = By.xpath("//*[@id=\"login\"]/h1");

        By emailLocator  = By.id("j_username");
        By passwordLocator = By.name("j_password");

        By sendButtonLocator = By.xpath("//*[@id=\"formAuthentication\"]/div[3]/div[2]/span/span");


        @Before
        public void setUp() throws Exception {

            System.setProperty("webdriver.opera.driver", "./src/test/resources/operaDriver/operaDriver.exe");

            driver = new OperaDriver();

            driver.manage().window().maximize();

            driver.get("https://unal.edu.co");
        }

        @Test
        public void registerUser() throws InterruptedException{

            String originalWindow = driver.getWindowHandle();
            driver.findElement(servicesLocator).click();
            driver.findElement(institutionalLocator).click();

            for (String windowHandle : driver.getWindowHandles()) {
                if(!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            Thread.sleep(2000);
            if(driver.findElement(accessGoogleLocator).isDisplayed()){
                driver.findElement(emailLocator).sendKeys("dabernalhe");
                driver.findElement(passwordLocator).sendKeys("Micofenolato7");
                driver.findElement(sendButtonLocator).click();
                Thread.sleep(8000);

            }
            else {
                System.out.print("Register pages was not found");
            }

           List<WebElement> spans = driver.findElements(By.tagName("span"));

            assertEquals("Importantes",spans.get(34).getText());

        }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(8000);
        driver.quit();

    }

}


