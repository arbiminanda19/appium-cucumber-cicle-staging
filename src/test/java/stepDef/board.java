package stepDef;

import config.env;
import helper.accessFile;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.pageCompany;
import objects.pageGeneral;
import objects.pageHome;

import java.util.Random;

public class board extends env {

    pageHome pageHome = new pageHome();
    pageGeneral pageGeneral = new pageGeneral();
    pageCompany pageCompany = new pageCompany();
    Random rand = new Random();

    accessFile accessFile = new accessFile();
    String file_teamName = "src/test/resources/data/teamName.txt";

    @Then("user is on board page")
    public void user_is_on_board_page() {

    }

    @When("user input board name")
    public void user_input_board_name() {

    }

    @Then("user see board created")
    public void user_see_board_created() {

    }
}
