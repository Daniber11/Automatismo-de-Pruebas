package certificacion.google.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consulta.feature",
        glue = "certificacion.google.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class ConsultGoogle { }
