package automatismo.stepDefinitions;

import automatismo.calculo.Subtraction;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RestStepDefinitions {

    private Subtraction receiver;
    private int result;

    @Given("^I want rest$")
    public void prepareRest() {

        receiver = new Subtraction();

    }

    @When("^rest (\\d+) less (\\d+)$")
    public void rest(int arg1, int arg2) {

        result = receiver.rest(arg1, arg2);

    }

    @Then("^Should see that the result (\\d+)$")
    public void checkRest(int arg1) {

        Assert.assertEquals(arg1, result);

    }

}
