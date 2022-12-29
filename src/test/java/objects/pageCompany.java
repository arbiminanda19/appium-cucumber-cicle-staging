package objects;

import helper.accessFile;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class pageCompany {

    accessFile accessFile = new accessFile();
    String file_teamName = "src/test/resources/data/teamName.txt";

    public By getBtn_addTeam() {
        By btn_addTeam = By.xpath("//android.view.View[@content-desc='Add new team']");
        return btn_addTeam;
    }

    public By getContainer_team() {
        By container_team = By.xpath("//android.view.View[@content-desc='Team']");
        return container_team;
    }

    public By getBtn_team() {
        By btn_team = By.xpath("//android.view.View[@content-desc='Team']/android.view.View/android.view.View/android.view.View");
        return btn_team;
    }

    public By getBtn_certainTeam(String teamName) {
        By btn_certainTeam = By.xpath("//android.widget.Button[contains(@content-desc, '" + teamName + "')]");
        return btn_certainTeam;
    }

    public By getScroll_toCertainTeam() {
        By scroll_toCertainTeam = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(descriptionContains(\"" + accessFile.readFromFile(file_teamName) + "\"))");
        return scroll_toCertainTeam;
    }
}
