package stepDef;

import config.env;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import objects.pageHome;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;

public class home extends env {

    pageHome pageHome = new pageHome();

    @Given("user is on app home")
    public void user_is_on_app_home() throws MalformedURLException {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageHome.getPage_home())
        );
    }

}
