package objects;

import helper.accessFile;
import org.openqa.selenium.By;

public class pageBoard {

    accessFile accessFile = new accessFile();
    String file_cardName = "src/test/resources/data/cardName.txt";

    public By getBtn_dropdown() {
        By btn_dropdown = By.xpath("//android.widget.Button[@content-desc='Board']");
        return btn_dropdown;
    }

    public By getBtn_addNewCard() {
        By btn_addNewCard = By.xpath("//android.widget.Button[@content-desc='Add new card']");
        return btn_addNewCard;
    }

    public By getInput_cardName() {
        By input_cardName = By.xpath("//android.view.View[@content-desc='Private Card']/android.widget.EditText");
        return input_cardName;
    }

    public By getBtn_confirmCardName() {
        By btn_confirmCardName = By.xpath("//android.view.View[@content-desc='Private Card']/android.widget.EditText/android.view.View");
        return btn_confirmCardName;
    }

    public By getBtn_cardContainer(String cardName) {
        By btn_cardContainer = By.xpath("//android.widget.Button[contains(@content-desc,'" + cardName + "')]");
        return btn_cardContainer;
    }

    public By getTxt_boardName(String boardName) {
        By txt_boardName = By.xpath("//android.view.View[@content-desc='" + boardName + "']");
        return txt_boardName;
    }
}
