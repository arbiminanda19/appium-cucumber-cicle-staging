package objects;

import helper.accessFile;
import org.openqa.selenium.By;

public class pageTeam {

    accessFile accessFile = new accessFile();
    String file_teamName = "src/test/resources/data/teamName.txt";

    public By getTxt_teamName() {
        By txt_teamName = By.xpath("//android.view.View[contains(@content-desc, '" + accessFile.readFromFile(file_teamName) + "')]");
        return txt_teamName;
    }

    public By getBtn_board() {
        By btn_board = By.xpath("//*[@content-desc='Board']");
        return btn_board;
    }

    public By getTxt_recentlyViewed() {
        By txt_recentlyViewed = By.xpath("//*[contains(@content-desc, 'Recently Viewed')]");
        return txt_recentlyViewed;
    }

    public By getBtn_Team(String teamName) {
        By btn_certainTeam = By.xpath("//android.view.View[contains(@content-desc, '" + teamName + "')]");
        return btn_certainTeam;
    }
}
