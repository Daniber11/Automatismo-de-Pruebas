package test5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.IOException;

public class DataDrivenTestingTest {

    private WebDriver driver;
    private WriteExcelFile writeFile;
    private ReadExcelFile readFile;
    private By searchBoxLocator = By.id("search_query_top");
    private By searchButtonLocator = By.name("submit_search");
    private By resultTextLocator = By.cssSelector("span.heading-counter");

    @Before
    public  void setUp() throws Exception {
        System.setProperty("webdriver.opera.driver","./src/test/resources/operaDriver/operaDriver.exe");
        driver = new OperaDriver();
        writeFile = new WriteExcelFile();
        readFile = new ReadExcelFile();

        driver.get("http://automationpractice.com");
    }

    @After
    public  void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public  void test() throws IOException {
        String filepath = "C:\\Users\\Daniel11\\Desktop\\Automatismo de Pruebas\\Test5\\Test.xlsx";

        String searchText = readFile.getCellValue(filepath,"Hoja1",0,0);

        driver.findElement(searchBoxLocator).sendKeys(searchText);

        driver.findElement(searchButtonLocator).click();

        String resultText = driver.findElement(resultTextLocator).getText();

        System.out.println("Page result text" + resultText);

        readFile.readExcel(filepath,"Hoja1");

        writeFile.writeCellValue(filepath,"Hoja1",0,1,resultText);

        readFile.readExcel(filepath,"Hoja1");
    }


}
