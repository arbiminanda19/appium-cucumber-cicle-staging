package objects;

import helper.accessFile;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class pageHome {

    accessFile accessFile = new accessFile();
    String file_companyName = "src/test/resources/data/companyName.txt";

    public By getImg_logo() {
        By img_logo = By.xpath("//android.widget.ImageView[@content-desc='logo']");
        return img_logo;
    }

    public By getBtn_createCompany() {
        By btn_createCompany = By.xpath("//android.widget.Button[@content-desc='Create New Company']");
        return btn_createCompany;
    }

    public By getTxt_successCreateCompany() {
        By txt_successCreateCompany = By.xpath("//android.view.View[@content-desc='Successfully create company user']");
        return txt_successCreateCompany;
    }

    public By getBtn_company() {
        By btn_company = By.xpath("//android.view.View[contains(@content-desc,'" + accessFile.readFromFile(file_companyName) + "')]");
        return btn_company;
    }

    public By getScroll_toCompany() {
        By scroll_toCompany = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().descriptionContains(\"" + accessFile.readFromFile(file_companyName) + "\").instance(0))");
        return scroll_toCompany;
    }
}
