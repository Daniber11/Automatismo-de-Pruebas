package certificacion.google.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;

import static certificacion.google.userinterfaces.MainPage.SEARCH_RESULT;

public class ResultInGoogle implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        return Text.of(SEARCH_RESULT).viewedBy(actor).asString();
    }

    public static ResultInGoogle search(){
        return new ResultInGoogle();
    }

}
