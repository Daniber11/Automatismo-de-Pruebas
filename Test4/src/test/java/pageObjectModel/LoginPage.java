package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends Base {

    By servicesLocator = By.xpath("//*[@id=\"services\"]/div");
    By institutionalLocator = By.xpath("//*[@id=\"services\"]/ul/li[1]");
    By accessGoogleLocator = By.xpath("//*[@id=\"login\"]/h1");

    By emailLocator  = By.id("j_username");
    By passwordLocator = By.name("j_password");

    By sendButtonLocator = By.xpath("//*[@id=\"formAuthentication\"]/div[3]/div[2]/span/span");

    By loggedMessage = By.tagName("span");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() throws InterruptedException {

        String originalWindow = driver.getWindowHandle();
        click(servicesLocator);
        click(institutionalLocator);

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(2000);
        if (isDisplayed(accessGoogleLocator)) {
            type("dabernalhe",emailLocator);
            type("Micofenolato7",passwordLocator);

            click(sendButtonLocator);
        }else {
            System.out.println("Login page was not found");
        }
    }

    public String loggedMessage() {
        List<WebElement> spans = findElements(loggedMessage);
        return  getText(spans.get(34));
    }


}
