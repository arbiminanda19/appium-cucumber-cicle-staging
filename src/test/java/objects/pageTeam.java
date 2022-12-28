package objects;

import helper.accessFile;
import org.openqa.selenium.By;

public class pageTeam {

    accessFile accessFile = new accessFile();
    String file_teamName = "src/test/resources/data/teamName.txt";

    By txt_teamName = By.xpath("//android.view.View[@content-desc=\"" + accessFile.readFromFile(file_teamName) + "\"]");
    By btn_board = By.xpath("//android.widget.ImageView[@content-desc='Board']");

    public By getTxt_teamName() {
        return txt_teamName;
    }

    public By getBtn_board() {
        return btn_board;
    }
}
