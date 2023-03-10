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

    public By getBtn_switchPrivateCard() {
        By btn_switchPrivateCard = By.xpath("//android.view.View[@content-desc='Private Card']/android.widget.Switch");
        return btn_switchPrivateCard;
    }

    public By getBox_cardContainer() {
        By box_cardContainer = By.xpath("//*/android.view.View[3]/android.view.View/android.view.View");
        return box_cardContainer;
    }

    public By getBtn_filter() {
        By btn_filter = By.xpath("//*/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]");
        return btn_filter;
    }

    public By getInput_filterCardName() {
        By input_filterCardName = By.xpath("//*/android.view.View/android.view.View/android.widget.EditText[1]");
        return input_filterCardName;
    }

    public By getTxt_boardNameGeneral(Integer boardOrder) {
        By txt_boardNameGeneral = By.xpath("//*/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[" + boardOrder + "]/android.view.View");
        return txt_boardNameGeneral;
    }

    public By getToast_reorderBoard() {
        By toast_reorderBoard = By.xpath("//android.view.View[@content-desc='Reorder list is success']");
        return toast_reorderBoard;
    }

    public By getBtn_boardOnSearch() {
        By btn_boardOnSearch = By.xpath("//android.view.View[contains(@content-desc, 'Board')]");
        return btn_boardOnSearch;
    }

    public By getBtn_certainCard() {
        By btn_certainCard = By.xpath("//android.widget.Button[contains(@content-desc,'"+ accessFile.readFromFile(file_cardName) +"')]");
        return btn_certainCard;
    }

    public By getBtn_attachFile() {
        By btn_attachFile = By.xpath("//android.widget.Button[@content-desc='Attach file']");
        return btn_attachFile;
    }

    public By getBtn_attachFileIcon() {
        By btn_attachFileIcon = By.xpath("//android.view.View[@content-desc='" + accessFile.readFromFile(file_cardName) + "'][1]/android.view.View[2]/android.view.View/android.view.View/android.view.View[5]");
        return btn_attachFileIcon;
    }

    public By getBtn_descriptionIcon() {
        By btn_descriptionIcon = By.xpath("//android.view.View[@content-desc='" + accessFile.readFromFile(file_cardName) + "'][1]/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]");
        return btn_descriptionIcon;
    }

    public By getInput_editText() {
        By input_editText = By.xpath("//*/android.widget.FrameLayout/descendant::android.widget.EditText");
        return input_editText;
    }

    public By getToast_attachFileSuccess() {
        By toast_attachFileSuccess = By.xpath("//android.view.View[@content-desc='Upload attachments is success']");
        return toast_attachFileSuccess;
    }

    public By getToast_createNoteSuccess() {
        By toast_createNoteSuccess = By.xpath("//android.view.View[@content-desc='update notes success']");
        return toast_createNoteSuccess;
    }
}
