package stepDef;

import com.github.javafaker.Faker;
import config.env;
import helper.accessFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.pageGeneral;
import objects.pageHome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.charset.Charset;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class home extends env {

    pageHome pageHome = new pageHome();
    pageGeneral pageGeneral = new pageGeneral();

    accessFile accessFile = new accessFile();
    Faker faker = new Faker();
    String file_companyName = "src/test/resources/data/companyName.txt";

    @Given("user is on home page")
    public void user_is_on_home_page() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageHome.getImg_logo())
        );
    }

    @When("user click create company button")
    public void user_click_create_company_button() {
        driver.findElement(pageHome.getBtn_createCompany()).click();
    }
    @And("user input company name")
    public void user_input_company_name() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageGeneral.getInput_Name())
        );
        WebElement txt_companyName = driver.findElement(pageGeneral.getInput_Name());
        txt_companyName.click();
        String companyPrefix = faker.company().suffix();
        String companyName = companyPrefix + faker.number().numberBetween(11111, 99999);
        txt_companyName.sendKeys(companyName);
        accessFile.writeToFile(file_companyName, companyName);
    }

    @Then("user see success create company toast")
    public void user_see_success_create_company_toast() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageHome.getTxt_successCreateCompany())
        );
    }

    @When("user open certain company")
    public void user_open_certain_company() {
        By btn_certainCompany = pageHome.getBtn_company();
        driver.findElement(pageHome.getScroll_toCompany());
        wait.until(
                ExpectedConditions.elementToBeClickable(btn_certainCompany)
        );
        driver.findElement(btn_certainCompany).click();
    }

}
