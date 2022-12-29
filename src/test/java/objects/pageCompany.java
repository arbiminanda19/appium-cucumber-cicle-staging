package objects;

import helper.accessFile;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class pageCompany {

    accessFile accessFile = new accessFile();
    String file_teamName = "src/test/resources/data/teamName.txt";

    By btn_addTeam = By.xpath("//android.view.View[@content-desc='Add new team']");

    By container_team = By.xpath("//android.view.View[@content-desc='Team']");

    By btn_certainTeam = By.xpath("//android.widget.Button[contains(@content-desc, '" + accessFile.readFromFile(file_teamName) + "')]");

    By scroll_toCertainTeam = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(descriptionContains(\"" + accessFile.readFromFile(file_teamName) + "\"))");
    By btn_team = By.xpath("//android.view.View[@content-desc='Team']/android.view.View/android.view.View/android.view.View");


    public By getBtn_addTeam() {
        return btn_addTeam;
    }

    public By getContainer_team() {
        return container_team;
    }

    public By getBtn_team() {
        return btn_team;
    }

    public By getBtn_certainTeam() {
        return btn_certainTeam;
    }

    public By getScroll_toCertainTeam() {
        return scroll_toCertainTeam;
    }
}
