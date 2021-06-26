package automatismo.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/feature/count_characters.feature"},
glue = {"automatismo.stepDefinitions"},
snippets = SnippetType.CAMELCASE)

public class CountCharacters {



}
