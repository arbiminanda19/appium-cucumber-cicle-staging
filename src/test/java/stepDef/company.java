package stepDef;

import config.env;
import helper.accessFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.pageCompany;
import objects.pageGeneral;
import objects.pageHome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Random;

public class company extends env {

    pageHome pageHome = new pageHome();
    pageGeneral pageGeneral = new pageGeneral();
    pageCompany pageCompany = new pageCompany();
    Random rand = new Random();

    accessFile accessFile = new accessFile();
    String file_teamName = "src/test/resources/data/teamName.txt";

    @Then("user is on company page")
    public void user_is_on_company_page() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageCompany.getContainer_team())
        );
    }

    @And("user click add team")
    public void user_click_add_team() {
        driver.findElement(pageCompany.getBtn_addTeam()).click();
    }

    @And("user input team name")
    public void user_input_company_name() {
        String teamName = "Team" + rand.nextInt(10000);
        accessFile.writeToFile(file_teamName, teamName);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageGeneral.getInput_Name())
        );
        WebElement txt_teamName = driver.findElement(pageGeneral.getInput_Name());
        txt_teamName.click();
        txt_teamName.sendKeys(teamName);
    }

    @Then("user see team created")
    public void user_see_team_created() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageCompany.getBtn_team())
        );
    }

    @When("user open certain team")
    public void user_open_certain_team() {

    }

}
