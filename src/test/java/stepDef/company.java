package stepDef;

import com.github.javafaker.Faker;
import config.env;
import helper.accessFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.pageCompany;
import objects.pageGeneral;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class company extends env {

    pageGeneral pageGeneral = new pageGeneral();
    pageCompany pageCompany = new pageCompany();
    Faker faker = new Faker();

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
    public void user_input_team_name() {
        String teamName = "Team" + faker.number().numberBetween(11111, 99999);
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
        By btn_certainTeam = pageCompany.getBtn_certainTeam(accessFile.readFromFile(file_teamName));
        driver.findElement(pageCompany.getScroll_toCertainTeam());
        wait.until(
                ExpectedConditions.elementToBeClickable(btn_certainTeam)
        );
        driver.findElement(btn_certainTeam).click();
    }

}
