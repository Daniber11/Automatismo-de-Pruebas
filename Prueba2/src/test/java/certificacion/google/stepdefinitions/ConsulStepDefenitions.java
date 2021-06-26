package certificacion.google.stepdefinitions;

import certificacion.google.questions.ResultInGoogle;
import certificacion.google.userinterfaces.MainPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import static certificacion.google.userinterfaces.MainPage.SEARCH_BAR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class ConsulStepDefenitions {

    @Managed(driver = "chrome")
    private WebDriver browser;
    private MainPage page;

    Actor daniel;


    @Before
    public void createActor(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\operadriver.exe");
        daniel = Actor.named("Daniel");
        daniel.can(BrowseTheWeb.with(browser));
    }

    @Given("^open browser in the google$")
    public void openBrowserInTheGoogle() {
       daniel.attemptsTo(
               Open.browserOn(page)
       );
    }

    @When("^insert my search in the navigation bar$")
    public void insertMySearchInTheNavigationBar() {
        daniel.attemptsTo(
                Enter.theValue("LOL").into(SEARCH_BAR)
        );
    }

    @Then("^my first result league of legends$")
    public void myFirstResultLeagueOfLegends() {
        daniel.should(
                seeThat(ResultInGoogle.search(),is("LAL"))
        );
    }

}
