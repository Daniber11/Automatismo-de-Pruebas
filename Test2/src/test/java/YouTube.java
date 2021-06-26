import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YouTube {

    private WebDriver driver;

    By logInLocator = By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer/a/paper-button/yt-formatted-string");

    By logInPageLocator = By.xpath("//*[@id=\"headingText\"]/span");

    By emailLocator  = By.id("identifierId");

    By nextButtonLocator = By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]");


    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.opera.driver", "./src/test/resources/operaDriver/operaDriver.exe");

        driver = new OperaDriver();

        driver.manage().window().maximize();

        driver.get("https://www.youtube.com");
    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(8000);
        driver.quit();

    }


    @Test
    public void registerUser() throws InterruptedException{

        driver.findElement(logInLocator).click();
        Thread.sleep(4000);
        if(driver.findElement(logInPageLocator).isDisplayed()){
        driver.findElement(emailLocator).sendKeys("danielbernalhenao@hotmail.com");
        driver.findElement(nextButtonLocator).click();
        }
        else {
            System.out.print("Register pages was not found");
        }

        List<WebElement> spans = driver.findElements(By.tagName("span"));

        assertEquals("Acceder",spans.get(2).getText()); // la segunda pagina que se despliega no la reconoce se toma desde la enaterior


    }


}
