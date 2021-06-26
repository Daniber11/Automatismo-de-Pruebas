package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

public class prueba1 {

    public static void main(String[] args) {
        OperaDriver driver = new OperaDriver();
        driver.get("https://www.google.com/webhp?hl=es-419&sa=X&ved=0ahUKEwiBrp7Unq7uAhV2RzABHcrjBPEQPAgI");

        WebElement barra = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        barra.sendKeys("Parche 11.2 league of legends");
        barra.sendKeys(Keys.ENTER);


    }

}
