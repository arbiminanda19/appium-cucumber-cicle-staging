package objects;

import org.openqa.selenium.By;

public class pageFileManager {

    public By getBtn_sideBar() {
        By btn_sideBar = By.xpath("//android.widget.ImageButton[@content-desc='Show roots']");
        return btn_sideBar;
    }

    public By getBtn_drive() {
        By btn_drive = By.xpath("//android.widget.FrameLayout[@content-desc='Open Drive']/parent::android.widget.LinearLayout");
        return btn_drive;
    }

    public By getBtn_fileDrive() {
        By btn_fileDrive = By.xpath("//*[@resource-id='com.google.android.documentsui:id/item_root']");
        return btn_fileDrive;
    }

    public By getBtn_cardImageDrive() {
        By btn_cardImageDrive = By.xpath("//*[@resource-id='com.google.android.apps.docs:id/document_layout']");
        return btn_cardImageDrive;
    }

    public By getBtn_optionSideBar() {
        By btn_optionSideBar = By.xpath("//android.widget.FrameLayout[@content-desc='Open Drive']/parent::android.widget.LinearLayout/preceding-sibling::android.widget.LinearLayout");
        return btn_optionSideBar;
    }

    public By getBtn_sdcard(Integer index) {
        By btn_sdcard = By.xpath("//android.widget.FrameLayout[@content-desc='Open Drive']/parent::android.widget.LinearLayout/preceding-sibling::android.widget.LinearLayout[" + index + "]");
        return btn_sdcard;
    }

    public By getBtn_fileSdCard() {
        By btn_fileSdCard = By.xpath("//*[contains(@content-desc, 'attachment')]/parent::android.widget.RelativeLayout/parent::androidx.cardview.widget.CardView/parent::androidx.cardview.widget.CardView");
        return btn_fileSdCard;
    }
}
