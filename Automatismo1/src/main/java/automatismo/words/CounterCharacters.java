package automatismo.words;

import java.util.List;

public class CounterCharacters {

    public int count(String word){

        return word.length();
    }

    public int count(List<String> word){

        return word.stream().mapToInt(String::length).sum();
    }


}
