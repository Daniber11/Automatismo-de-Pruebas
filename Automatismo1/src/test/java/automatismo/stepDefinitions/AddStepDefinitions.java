package automatismo.stepDefinitions;

import automatismo.calculo.Sum;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class AddStepDefinitions {

    private Sum adder;
    private  int result;

    @Given("^i want add$")
    public void prepareSum() {
        adder = new Sum();
    }


    @When("^i add (\\d+) plus (\\d+)$")
    public void add(int arg1, int arg2) {

        result = adder.add(arg1, arg2);

    }

    @Then("^should see that the result (\\d+)$")
    public void checkResult(int arg1) {

        Assert.assertEquals(arg1, result);

    }


}
