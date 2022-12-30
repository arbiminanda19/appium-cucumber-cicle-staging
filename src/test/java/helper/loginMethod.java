package helper;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class loginMethod {

    public String getLoginMethod() {

        List<String> givenList = Arrays.asList("Swipe", "Skip");
        Random rand = new Random();
        String loginMethod = givenList.get(rand.nextInt(givenList.size()));

        return loginMethod;
    }

}
