package stepDef;

import config.env;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.pageTeam;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class team extends env {

    pageTeam pageTeam = new pageTeam();
    @Then("user is on team page")
    public void user_is_on_team_page() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageTeam.getTxt_teamName())
        );
    }

    @When("user click board button")
    public void user_click_board_button() {
        driver.findElement(pageTeam.getBtn_board()).click();
    }

}
