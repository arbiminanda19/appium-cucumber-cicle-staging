package objects;

import helper.accessFile;
import org.openqa.selenium.By;

public class pageBoard {

    By btn_dropdown = By.xpath("//android.widget.Button[@content-desc='Board']");

    By btn_addNewCard = By.xpath("//android.widget.Button[@content-desc='Add new card']");

    public By getBtn_dropdown() {
        return btn_dropdown;
    }

    public By getBtn_addNewCard() {
        return btn_addNewCard;
    }
}
