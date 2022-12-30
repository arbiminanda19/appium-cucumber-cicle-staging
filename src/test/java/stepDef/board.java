package stepDef;

import com.github.javafaker.Faker;
import config.env;
import helper.accessFile;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.pageBoard;
import objects.pageGeneral;
import objects.pageTeam;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class board extends env {

    pageBoard pageBoard = new pageBoard();
    pageGeneral pageGeneral = new pageGeneral();
    pageTeam pageTeam = new pageTeam();

    Faker faker = new Faker();

    accessFile accessFile = new accessFile();
    String file_boardName = "src/test/resources/data/boardName.txt";
    String file_cardName = "src/test/resources/data/cardName.txt";
    String file_teamName = "src/test/resources/data/teamName.txt";
    String file_cardAmount = "src/test/resources/data/cardAmount.txt";

    Integer amountCardFiltered = 0;

    @Then("user is on board page")
    public void user_is_on_board_page() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageBoard.getBtn_dropdown())
        );
        if (driver.findElements(pageTeam.getTxt_recentlyViewed()).size() > 0) {
            driver.findElement(pageTeam.getBtn_Team(accessFile.readFromFile(file_teamName))).click();
        }
    }

    @When("user input board name")
    public void user_input_board_name() {
        String boardName = "Board" + faker.number().numberBetween(11111, 99999);
        accessFile.writeToFile(file_boardName, boardName);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageGeneral.getInput_Name())
        );
        WebElement txt_teamName = driver.findElement(pageGeneral.getInput_Name());
        txt_teamName.click();
        txt_teamName.sendKeys(boardName);
    }

    @Then("user see board created")
    public void user_see_board_created() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageBoard.getTxt_boardName(accessFile.readFromFile(file_boardName)))
        );
    }

    @When("user click add new card")
    public void user_click_add_new_card() {
        driver.findElement(pageBoard.getBtn_addNewCard()).click();
    }

    @When("user input card name")
    public void user_input_card_name() {
        String cardName = "Card" + faker.number().numberBetween(11111, 99999);
        accessFile.writeToFile(file_cardName, cardName);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageBoard.getInput_cardName())
        );
        WebElement txt_cardName = driver.findElement(pageBoard.getInput_cardName());
        txt_cardName.click();
        txt_cardName.sendKeys(cardName);
    }

    @When("user click confirm card name")
    public void user_click_confirm_card_name() {
        driver.findElement(pageBoard.getBtn_confirmCardName()).click();
    }

    @When("user check private card switch")
    public void user_check_private_card_switch() {
        driver.findElement(pageBoard.getBtn_switchPrivateCard()).click();
        String switchStatus = driver.findElement(pageBoard.getBtn_switchPrivateCard()).getAttribute("checked");
        Assert.assertEquals(switchStatus, "true");
    }

    @Then("user see card created")
    public void user_see_card_created() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageBoard.getBtn_cardContainer(accessFile.readFromFile(file_cardName)))
        );
    }

    @When("user click filter button")
    public void user_click_filter_button() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageBoard.getBtn_filter())
        );
        driver.findElement(pageBoard.getBtn_filter()).click();
    }
    @When("user input card name for filter")
    public void user_input_card_name_for_filter() {
        driver.findElement(pageBoard.getInput_filterCardName()).click();
        driver.findElement(pageBoard.getInput_filterCardName()).sendKeys(accessFile.readFromFile(file_cardName));
        driver.hideKeyboard();
    }

    @Then("user see filtered card")
    public void user_see_filtered_card() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageBoard.getBtn_cardContainer(accessFile.readFromFile(file_cardName)))
        );
        amountCardFiltered = driver.findElements(pageBoard.getBox_cardContainer()).size();
        accessFile.writeToFile(file_cardAmount, String.valueOf(amountCardFiltered));
    }

    @Then("user see all cards")
    public void user_see_all_cards() {
        amountCardFiltered = driver.findElements(pageBoard.getBox_cardContainer()).size();
        Assert.assertTrue(Integer.valueOf(accessFile.readFromFile(file_cardAmount)) < amountCardFiltered);
    }

}
