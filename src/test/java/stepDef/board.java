package stepDef;

import config.env;
import helper.accessFile;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.pageBoard;
import objects.pageCompany;
import objects.pageGeneral;
import objects.pageHome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class board extends env {

    pageBoard pageBoard = new pageBoard();
    pageGeneral pageGeneral = new pageGeneral();
    Random rand = new Random();

    accessFile accessFile = new accessFile();
    String file_boardName = "src/test/resources/data/boardName.txt";

    @Then("user is on board page")
    public void user_is_on_board_page() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageBoard.getBtn_dropdown())
        );
    }

    @When("user input board name")
    public void user_input_board_name() {
        String boardName = "Board" + rand.nextInt(10000);
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
                ExpectedConditions.visibilityOfElementLocated(pageBoard.getBtn_addNewCard())
        );
    }
}
