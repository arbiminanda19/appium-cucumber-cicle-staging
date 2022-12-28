package stepDef;

import config.env;
import helper.accessFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.pageCompany;
import objects.pageGeneral;
import objects.pageHome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class team extends env {

    pageHome pageHome = new pageHome();
    pageGeneral pageGeneral = new pageGeneral();
    pageCompany pageCompany = new pageCompany();
    Random rand = new Random();

    accessFile accessFile = new accessFile();
    String file_teamName = "src/test/resources/data/teamName.txt";

    @Then("user is on team page")
    public void user_is_on_team_page() {

    }

    @When("user click board button")
    public void user_click_board_button() {

    }

}
