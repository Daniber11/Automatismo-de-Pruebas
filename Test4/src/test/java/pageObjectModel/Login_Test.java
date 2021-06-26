package pageObjectModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Login_Test {

    private WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() throws Exception {
        loginPage = new LoginPage(driver);
        driver = loginPage.operaDriverConnection();
        loginPage.visit("https://unal.edu.co");
    }

    @After
    public void tearDown() throws Exception {
       // driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        loginPage.login();
        Thread.sleep(8000);
        assertEquals("Importantes",loginPage.loggedMessage());

    }








}
