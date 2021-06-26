package automatismo.stepDefinitions;

import automatismo.words.CounterCharacters;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CountCharactersStepDefinitions {

    private CounterCharacters counter;
    private int result;

    @Given("^I want count characters$")
    public void prepareCountingCharacters() {
        counter = new CounterCharacters();

    }

    @When("^Count the characters of the word (.*)$")
    public void countCharacters(String word) {
        result = counter.count(word);

    }

    @When("^Count the characters of list$")
    public void countTheCharactersOfList(List<String> words) {

        result = counter.count(words);

    }

    @Then("^Should see that the number of characters is (\\d+)$")
    public void checkResult(int arg1){
            Assert.assertEquals(arg1, result);

    }
}


