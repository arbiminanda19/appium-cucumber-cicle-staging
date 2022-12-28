package stepDef;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.pageHome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.util.Random;

public class home extends env {

    pageHome pageHome = new pageHome();
    Random rand = new Random();

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
                ExpectedConditions.visibilityOfElementLocated(pageHome.getInput_companyName())
        );
        WebElement txt_companyName = driver.findElement(pageHome.getInput_companyName());
        txt_companyName.click();
        txt_companyName.sendKeys("User" + rand.nextInt(10000));
    }
    @And("user input description")
    public void user_input_description() {
        WebElement txt_companyDesc = driver.findElement(pageHome.getInput_companyDesc());
        txt_companyDesc.click();
        txt_companyDesc.sendKeys("description");
    }
    @And("user click create button")
    public void user_click_create_button() {
        driver.findElement(pageHome.getBtn_create()).click();
    }
    @Then("user see success create company toast")
    public void user_see_success_create_company_toast() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageHome.getTxt_successCreateCompany())
        );
    }

}
