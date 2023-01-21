package stepDef;

import com.github.javafaker.Faker;
import config.env;
import helper.accessFile;
import helper.click;
import helper.drag;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.pageBoard;
import objects.pageGeneral;
import objects.pageFileManager;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;

public class board extends env {

    pageBoard pageBoard = new pageBoard();
    pageGeneral pageGeneral = new pageGeneral();
    pageFileManager pageFileManager = new pageFileManager();

    Faker faker = new Faker();
    click click = new click();
    drag drag = new drag();

    accessFile accessFile = new accessFile();
    String file_boardName = "src/test/resources/data/boardName.txt";
    String file_cardName = "src/test/resources/data/cardName.txt";
    String file_privateCardName = "src/test/resources/data/privateCardName.txt";
    String file_cardAmount = "src/test/resources/data/cardAmount.txt";

    String file_firstBoardName = "src/test/resources/data/firstBoardName.txt";
    String file_secondBoardName = "src/test/resources/data/secondBoardName.txt";

    Integer amountCardFiltered = 0;

    @Then("user is on board page")
    public void user_is_on_board_page() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageBoard.getBtn_dropdown())
        );
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

    @When("user input private card name")
    public void user_input_private_card_name() {
        String cardName = "Card" + faker.number().numberBetween(11111, 99999);
        accessFile.writeToFile(file_privateCardName, cardName);
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
        String privateCardName = accessFile.readFromFile(file_privateCardName);
        String pageSource = (driver.getPageSource());
        Assert.assertFalse(pageSource.contains(privateCardName));
    }

    @Then("user see all cards")
    public void user_see_all_cards() {
        amountCardFiltered = driver.findElements(pageBoard.getBox_cardContainer()).size();
        Assert.assertTrue(Integer.valueOf(accessFile.readFromFile(file_cardAmount)) < amountCardFiltered);
        String cardName = accessFile.readFromFile(file_cardName);
        String privateCardName = accessFile.readFromFile(file_privateCardName);
        String pageSource = (driver.getPageSource());
        pageSource.contains(privateCardName);
        pageSource.contains(cardName);
    }

    @When("user get order existing board")
    public void get_existing_board_order() {
        String firstBoardName = driver.findElement(pageBoard.getTxt_boardNameGeneral(1)).getAttribute("content-desc");
        accessFile.writeToFile(file_firstBoardName, firstBoardName);
        String secondBoardName = driver.findElement(pageBoard.getTxt_boardNameGeneral(2)).getAttribute("content-desc");
        accessFile.writeToFile(file_secondBoardName, secondBoardName);
    }

    @When("user see board order changed")
    public void see_board_order_changed() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageBoard.getToast_reorderBoard())
        );
        String firstBoardName = driver.findElement(pageBoard.getTxt_boardNameGeneral(1)).getAttribute("content-desc");
        Assert.assertEquals(firstBoardName, accessFile.readFromFile(file_secondBoardName));
        String secondBoardName = driver.findElement(pageBoard.getTxt_boardNameGeneral(2)).getAttribute("content-desc");
        Assert.assertEquals(secondBoardName, accessFile.readFromFile(file_firstBoardName));
    }

    @When("user change board order")
    public void change_board_order() throws InterruptedException {
        drag.dragByElement(driver, pageBoard.getTxt_boardNameGeneral(2), pageBoard.getTxt_boardNameGeneral(1));
    }

    @When("user click certain card")
    public void click_certain_card() {
        driver.findElement(pageBoard.getBtn_certainCard()).click();
    }

    @When("user click attach file")
    public void click_attach_file() {
        if (driver.findElements(pageBoard.getBtn_attachFile()).size() > 0) {
            driver.findElement(pageBoard.getBtn_attachFile()).click();
        } else {
            driver.findElement(pageBoard.getBtn_attachFileIcon()).click();
        }
    }

    @When("user upload file")
    public void upload_file() throws IOException {
        String fileSource = "local";
        if (fileSource.equals("local")) {
            driver.pushFile("/sdcard/attachments.png", new File(System.getProperty("user.dir") + "/src/test/resources/files/attachments.png"));
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(pageFileManager.getBtn_sideBar())
            );
            driver.findElement(pageFileManager.getBtn_sideBar()).click();
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(pageFileManager.getBtn_optionSideBar())
            );
            Integer sideBarAmount = driver.findElements(pageFileManager.getBtn_optionSideBar()).size();
            driver.findElement(pageFileManager.getBtn_sdcard(sideBarAmount)).click();
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(pageFileManager.getBtn_fileSdCard())
            );
            driver.findElement(pageFileManager.getBtn_fileSdCard()).click();
        } else {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(pageFileManager.getBtn_sideBar())
            );
            driver.findElement(pageFileManager.getBtn_sideBar()).click();
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(pageFileManager.getBtn_drive())
            );
            driver.findElement(pageFileManager.getBtn_drive()).click();
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(pageFileManager.getBtn_fileDrive())
            );
            driver.findElement(pageFileManager.getBtn_fileDrive()).click();
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(pageFileManager.getBtn_fileDrive())
            );
            driver.findElement(pageFileManager.getBtn_fileDrive()).click();
        }
    }

    @Then("user see attachment uploaded")
    public void see_attachment_success() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageBoard.getToast_attachFileSuccess())
        );
    }

}
