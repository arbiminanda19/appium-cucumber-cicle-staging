package stepDef;

import config.env;
import helper.requestAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import objects.pageGeneral;
import org.openqa.selenium.WebElement;

public class general extends env {

    pageGeneral pageGeneral = new pageGeneral();

    @When("user click add button")
    public void user_click_add_button() {
        driver.findElement(pageGeneral.getBtn_add()).click();
    }

    @And("user input description")
    public void user_input_description() {
        WebElement txt_companyDesc = driver.findElement(pageGeneral.getInput_Desc());
        txt_companyDesc.click();
        txt_companyDesc.sendKeys("description");
    }
    @And("user click create button")
    public void user_click_create_button() {
        driver.findElement(pageGeneral.getBtn_create()).click();
    }

    @When("user click submit")
    public void user_click_submit() {
        driver.findElement(pageGeneral.getBtn_submit()).click();
    }

}
