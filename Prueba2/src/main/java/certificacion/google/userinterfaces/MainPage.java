package certificacion.google.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://www.google.com")
public class MainPage extends PageObject {
    public static final Target SEARCH_BAR = Target.
            the("search bar").located(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
    public static final Target SEARCH_RESULT = Target.
            the("search result").located(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/ul/li[2]/div/div[2]/div[2]/span"));

}
